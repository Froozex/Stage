package com.stage.project.settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stage.project.settings.UserInfo;
import com.stage.project.data.FascicoloInfo;
import com.stage.project.database.DBConnection;

public class UserMngDao {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public UserMngDao(String jdbcURL, String jdbcUsername, String jdbcPassword)	{
		
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
    
    /**
     * Get all users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < UserInfo > ListAllUtenti() throws SQLException, IOException {

    	List<UserInfo> listUsers = new ArrayList<>();
        
        String sql = "select fullName,Email,userName,role from users";
         
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while(resultSet.next()) {
        	
        	String fullName = resultSet.getString("fullName");
        	String email = resultSet.getString("email");
        	String userName = resultSet.getString("userName");
        	String role = resultSet.getString("role");
        	
        	UserInfo user = new UserInfo(fullName, email, userName, role);
        	listUsers.add(user);
        }
        
        resultSet.close();
        statement.close();
        disconnect();
         
        return listUsers;	
    }
    
    /**
     * Delete user
     * @param user
     */
        public boolean deleteUtente(UserInfo user) throws SQLException {
            String sql = "DELETE FROM fascicolo where email = ?";
             
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
             
            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowDeleted;
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