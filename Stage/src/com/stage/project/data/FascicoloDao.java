package com.stage.project.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;


public class FascicoloDao {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public FascicoloDao(String jdbcURL, String jdbcUsername, String jdbcPassword)	{
		
		this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public boolean insertFascicolo(FascicoloInfo fasc) throws SQLException {
    	
    	String sql = "INSERT INTO fascicolo (Nomina, Pubblico Ministero, Polizia Giudiziaria, Indagato, Reato, Consulente, Ausiliario, Data Affidamento Incarico, Data Inizio Operazioni, Giorni Concessi, Proroga, Richiesta a Gestori, Relazione, Richiesta Spese, Pagamento Avvenuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	connect();
    	
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, fasc.getNomina());
        statement.setString(2, fasc.getProcura());
        statement.setString(3, fasc.getPm());
        statement.setString(4, fasc.getPg());
        statement.setString(5, fasc.getIndagato());
        statement.setString(6, fasc.getReato());
        statement.setString(7, fasc.getConsulente());
        statement.setString(8, fasc.getAusiliario());
        statement.setString(9, fasc.getD_incarico());
        statement.setString(10, fasc.getD_inizio());
        statement.setInt(11, fasc.getGiorni());
        statement.setString(12, fasc.getScadenza());
        statement.setInt(13, fasc.getProroga());
        statement.setString(14, fasc.getRichiesta());
        statement.setString(15, fasc.getRelazione());
        statement.setString(16, fasc.getCosto());
        statement.setString(17, fasc.getPagamento());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    /**
     * Update fascicolo
     * @param fasc
     */
    public boolean updateFascicolo(FascicoloInfo fasc) throws SQLException {
        String sql = "UPDATE fascicolo SET Nomina = ?, Pubblico Ministero = ?, Polizia Giudiziaria = ?, Indagato = ?, Reato = ?, Consulente = ?, Ausiliario = ?, Data Affidamento Incarico = ?, Data Inizio Operazioni = ?, Giorni Concessi = ?, Proroga = ?, Richiesta a Gestori = ?, Relazione = ?, Richiesta Spese = ?, Pagamento Avvenuto = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, fasc.getNomina());
        statement.setString(2, fasc.getProcura());
        statement.setString(3, fasc.getPm());
        statement.setString(4, fasc.getPg());
        statement.setString(5, fasc.getIndagato());
        statement.setString(6, fasc.getReato());
        statement.setString(7, fasc.getConsulente());
        statement.setString(8, fasc.getAusiliario());
        statement.setString(9, fasc.getD_incarico());
        statement.setString(10, fasc.getD_inizio());
        statement.setInt(11, fasc.getGiorni());
        statement.setString(12, fasc.getScadenza());
        statement.setInt(13, fasc.getProroga());
        statement.setString(14, fasc.getRichiesta());
        statement.setString(15, fasc.getRelazione());
        statement.setString(16, fasc.getCosto());
        statement.setString(17, fasc.getPagamento());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    /**
     * Delete fascicolo
     * @param nomina
     */
        public boolean deleteFascicolo(FascicoloInfo fasc) throws SQLException {
            String sql = "DELETE FROM fascicolo where Nomina = ?";
             
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, fasc.getNomina());
             
            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowDeleted;
        }

    /**
     * Get fascicoli By ID
     * @param id
     * @return
     */
    public FascicoloInfo getFascicolo(String nomina_id) throws SQLException {
        FascicoloInfo fasc = null;
        String sql = "SELECT * FROM fascicolo WHERE Nomina = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, nomina_id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String nomina = resultSet.getString("Nomina");
        	String procura = resultSet.getString("Procura");
        	String pm = resultSet.getString("Pubblico Ministero");
        	String pg = resultSet.getString("Polizia Giudiziaria");
        	String indagato = resultSet.getString("Indagato");
        	String reato = resultSet.getString("Reato");
        	String consulente = resultSet.getString("Consulente");
        	String ausiliario = resultSet.getString("Ausiliario");
        	String d_incarico = resultSet.getString("Data Affidamento Incarico");
        	String d_inizio = resultSet.getString("Data Inizio Operazioni");
        	int giorni = resultSet.getInt("Giorni Concessi");
        	String scadenza = resultSet.getString("Scadenza");
        	int proroga = resultSet.getInt("Proroga");
        	String richiesta = resultSet.getString("Richiesta a Gestori");
        	String relazione = resultSet.getString("Relazione");
        	String costo = resultSet.getString("Richiesta Spesa");
        	String pagamento = resultSet.getString("Pagamento Avvenuto");
        	
        	fasc = new FascicoloInfo(nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, relazione, costo, pagamento);
        	
        }
         
        resultSet.close();
        statement.close();
         
        return fasc;
    }

    /**
     * Get all fascicoli
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < FascicoloInfo > ListAllFascicoli() throws SQLException {

    	List<FascicoloInfo> listFasc = new ArrayList<>();
        
        String sql = "SELECT * FROM fascicolo";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while(resultSet.next()) {
        	
        	String nomina = resultSet.getString("Nomina");
        	String procura = resultSet.getString("Procura");
        	String pm = resultSet.getString("Pubblico Ministero");
        	String pg = resultSet.getString("Polizia Giudiziaria");
        	String indagato = resultSet.getString("Indagato");
        	String reato = resultSet.getString("Reato");
        	String consulente = resultSet.getString("Consulente");
        	String ausiliario = resultSet.getString("Ausiliario");
        	String d_incarico = resultSet.getString("Data Affidamento Incarico");
        	String d_inizio = resultSet.getString("Data Inizio Operazioni");
        	int giorni = resultSet.getInt("Giorni Concessi");
        	String scadenza = resultSet.getString("Scadenza");
        	int proroga = resultSet.getInt("Proroga");
        	String richiesta = resultSet.getString("Richiesta a Gestori");
        	String relazione = resultSet.getString("Relazione");
        	String costo = resultSet.getString("Richiesta Spesa");
        	String pagamento = resultSet.getString("Pagamento Avvenuto");
        	
        	FascicoloInfo fasc = new FascicoloInfo(nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, relazione, costo, pagamento);
        	listFasc.add(fasc);
        }
        
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listFasc;
    	
    	
    }
}