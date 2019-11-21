package com.stage.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
 
public class DBConnection {
 
 public static Connection createConnection() {
 
	 Connection conn = null;
	 String url = "jdbc:mysql://localhost:3306/utenti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //MySQL URL followed by the database name
	 String username = "root"; //MySQL username [da cambiare]
	 String password = "ludovico97"; //MySQL password [da cambiare]
 
	 try 
	 {
		 try 
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver"); //loading MySQL drivers. This differs for database servers
			 System.out.println("tryconnection");
		 } 
		 catch (ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 }
 
		 conn = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
		 System.out.println("Printing connection object "+conn.getMetaData().getDatabaseProductName());
	 } 
	 catch (Exception e) 
	 {
		 System.out.println("errore nella connessione al database");
		 e.printStackTrace();
	 }
 
	 return conn; 
 	}
}


