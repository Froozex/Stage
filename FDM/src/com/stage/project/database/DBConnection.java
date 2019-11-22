package com.stage.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
 
 public static Connection createConnection()
 {
 Connection conn = null;
 String url = "jdbc:mysql://localhost:3306/iif_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //MySQL URL followed by the database name
 String username = "root"; //MySQL username [da cambiare]
 String password = "IIFLuca%Russo"; //MySQL password [da cambiare]
 System.out.println("Connessione stabilita!");
 
 try 
 {
 try 
 {
 Class.forName("com.mysql.cj.jdbc.Driver");
 System.out.println("Driver disponibile!");//loading MySQL drivers. This differs for database servers 
 } 
 catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 }
 
 conn = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 System.out.println("Printing connection object "+conn);
 } 
 catch (Exception e) 
 {
 e.printStackTrace();
 }
 
 return conn; 
 }
}
