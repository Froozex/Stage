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


public class RepertoDao {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public RepertoDao(String jdbcURL, String jdbcUsername, String jdbcPassword)	{
		
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
    
    public boolean insertReperto(RepertoInfo rep) throws SQLException {
    	
    	String sql = "INSERT INTO reperto (nomina, numero_reperto, sequestrato, tipo_supporto, seriale, note, operazioni) VALUES(?, ?, ?, ?, ?, ?, ?)";
    	connect();
    	
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, rep.getNomina());
        statement.setString(2, rep.getNreperto());
        statement.setString(3, rep.getSequestrato());
        statement.setString(4, rep.getSupporto());
        statement.setString(5, rep.getSeriale());
        statement.setString(6, rep.getNote());
        statement.setString(7, rep.getOperazioni());

        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    /**
     * Update fascicolo
     * @param fasc
     */
    public boolean updateReperto(RepertoInfo rep) throws SQLException {
        String sql = "UPDATE reperto SET numero_reperto = ?, sequestrato = ?, tipo_supporto = ?, seriale = ?, note = ?, operazioni = ? WHERE numero_reperto = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        //statement.setString(1, rep.getNomina());
        statement.setString(1, rep.getNreperto());
        statement.setString(2, rep.getSequestrato());
        statement.setString(3, rep.getSupporto());
        statement.setString(4, rep.getSeriale());
        statement.setString(5, rep.getNote());
        statement.setString(6, rep.getOperazioni());
        statement.setString(7, rep.getNreperto());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    /**
     * Delete reperto
     * @param nomina
     */
        public boolean deleteReperto(RepertoInfo rep) throws SQLException {
            String sql = "DELETE FROM reperto where nomina = ?";
            
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, rep.getNomina()); 
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
    public RepertoInfo getReperto(String numrep) throws SQLException {
        
    	RepertoInfo rep = null;
        String sql = "SELECT * FROM reperto WHERE numero_reperto = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, numrep);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String nomina = resultSet.getString("nomina");
        	String nreperto = resultSet.getString("numero_reperto");
        	String sequestrato = resultSet.getString("sequestrato");
        	String supporto = resultSet.getString("tipo_supporto");
        	String seriale = resultSet.getString("seriale");
        	String note = resultSet.getString("note");
        	String operazioni = resultSet.getString("operazioni");
        	
        	rep = new RepertoInfo(nomina, nreperto, sequestrato, supporto, seriale, note, operazioni);
            System.out.println(rep);

        }
         
        resultSet.close();
        statement.close();
         
        return rep;
    }

    /**
     * Get all fascicoli
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < RepertoInfo > ListAllReperti(String nominarep) throws SQLException {

    	List<RepertoInfo> listRep = new ArrayList<>();
    	
        String sql = "SELECT * FROM utenti.reperto where nomina = ?";
        		
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, nominarep);
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()) {
        	
        	String nomina = resultSet.getString("nomina");
        	String nreperto = resultSet.getString("numero_reperto");
        	String sequestrato = resultSet.getString("sequestrato");
        	String supporto = resultSet.getString("tipo_supporto");
        	String seriale = resultSet.getString("seriale");
        	String note = resultSet.getString("note");
        	String operazioni = resultSet.getString("operazioni");
        	
        	RepertoInfo rep = new RepertoInfo(nomina, nreperto, sequestrato, supporto, seriale, note, operazioni);
        	listRep.add(rep);
        }
        
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listRep;
    	
    	
    }
}