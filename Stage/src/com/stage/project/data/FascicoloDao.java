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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.mysql.cj.protocol.Resultset;


public class FascicoloDao {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	InputStream input = null;
	FileOutputStream output = null;
	
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
    
    public boolean insertFascicolo(FascicoloInfo fasc, InputStream relazione) throws SQLException {
    	
    	String sql = "INSERT INTO fascicolo (nomina, procura, pubblico_ministero, polizia_giudiziaria, indagato, reato, consulente, ausiliario, data_affidamento_incarico, data_inizio_operazioni, giorni_concessi, scadenza, proroga, richiesta_gestori, relazione, richiesta_spese, pagamento_avvenuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        
        if(relazione != null) {
        	statement.setBlob(15, relazione);
        }
        
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
    public boolean updateFascicolo(FascicoloInfo fasc, InputStream relazione) throws SQLException {
        String sql = "UPDATE fascicolo SET nomina = ?, procura = ?, pubblico_ministero = ?, polizia_giudiziaria = ?, indagato = ?, reato = ?, consulente = ?, ausiliario = ?, data_affidamento_incarico = ?, data_inizio_operazioni = ?, giorni_concessi = ?, scadenza = ?, proroga = ?, richiesta_gestori = ?, relazione = ?, richiesta_spese = ?, pagamento_avvenuto = ?";
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
        
        if(relazione != null) {
        	statement.setBlob(15, relazione);
        }
        
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
        public boolean deleteFascicolo(FascicoloInfo fasc, InputStream relazione) throws SQLException {
            String sql = "DELETE FROM fascicolo where nomina = ?";
             
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
     * @param nomina
     * @return
     */
    public FascicoloInfo getFascicolo(String nomina_id) throws SQLException, IOException {
        FascicoloInfo fasc = null;
        String sql = "SELECT * FROM fascicolo WHERE nomina = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, nomina_id);
         
        ResultSet resultSet = statement.executeQuery();
        
        File theFile = new File("resume_from_db.pdf");
		output = new FileOutputStream(theFile);
         
        if (resultSet.next()) {
        	String nomina = resultSet.getString("nomina");
        	String procura = resultSet.getString("procura");
        	String pm = resultSet.getString("pubblico_ministero");
        	String pg = resultSet.getString("polizia_giudiziaria");
        	String indagato = resultSet.getString("indagato");
        	String reato = resultSet.getString("reato");
        	String consulente = resultSet.getString("consulente");
        	String ausiliario = resultSet.getString("ausiliario");
        	String d_incarico = resultSet.getString("data_affidamento_incarico");
        	String d_inizio = resultSet.getString("data_inizio_operazioni");
        	int giorni = resultSet.getInt("giorni_concessi");
        	String scadenza = resultSet.getString("scadenza");
        	int proroga = resultSet.getInt("proroga");
        	String richiesta = resultSet.getString("richiesta_gestori");
        	input = resultSet.getBinaryStream("relazione"); 

        	byte[] buffer = new byte[1024];
			while (input.read(buffer) > 0) {
				output.write(buffer);
			}
        	String costo = resultSet.getString("richiesta_spese");
        	String pagamento = resultSet.getString("pagamento_avvenuto");
        	
        	fasc = new FascicoloInfo(nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, costo, pagamento);
        	
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
    public List < FascicoloInfo > ListAllFascicoli() throws SQLException, IOException {

    	List<FascicoloInfo> listFasc = new ArrayList<>();
        
        String sql = "SELECT * FROM utenti.fascicolo";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        File theFile = new File("resume_from_db.pdf");
		output = new FileOutputStream(theFile);
        
        while(resultSet.next()) {
        	
        	int id = resultSet.getInt("id");
        	String nomina = resultSet.getString("nomina");
        	String procura = resultSet.getString("procura");
        	String pm = resultSet.getString("pubblico_ministero");
        	String pg = resultSet.getString("polizia_giudiziaria");
        	String indagato = resultSet.getString("indagato");
        	String reato = resultSet.getString("reato");
        	String consulente = resultSet.getString("consulente");
        	String ausiliario = resultSet.getString("ausiliario");
        	String d_incarico = resultSet.getString("data_affidamento_incarico");
        	String d_inizio = resultSet.getString("data_inizio_operazioni");
        	int giorni = resultSet.getInt("giorni_concessi");
        	String scadenza = resultSet.getString("scadenza");
        	int proroga = resultSet.getInt("proroga");
        	String richiesta = resultSet.getString("richiesta_gestori");
        	input = resultSet.getBinaryStream("relazione"); 

        	byte[] buffer = new byte[1024];
			while (input.read(buffer) > 0) {
				output.write(buffer);
			}
        	String costo = resultSet.getString("richiesta_spese");
        	String pagamento = resultSet.getString("pagamento_avvenuto");
        	
        	FascicoloInfo fasc = new FascicoloInfo(id, nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, costo, pagamento);
        	listFasc.add(fasc);
        }
        
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listFasc;
    	
    	
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}