package com.stage.project.auth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.stage.project.auth.LoginBean;
import com.stage.project.database.DBConnection;
public class LoginDao {
public String authenticateUser(LoginBean loginBean)
{

String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
String password = loginBean.getPassword();
System.out.println("Avvio!");
Connection conn = null;
Statement statement = null;
ResultSet resultSet = null;

String userNameDB = "";
String passwordDB = "";

try
{
conn = DBConnection.createConnection();
System.out.println("Connessione Stabilita!");//establishing connection
statement = conn.createStatement(); //Statement is used to write queries. Read more about it.
resultSet = statement.executeQuery("select userName,password from data");
System.out.println("Query chiamata!");//Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

while(resultSet.next()) // Until next row is present otherwise it return false
{
 userNameDB = resultSet.getString("userName"); //fetch the values present in database
 passwordDB = resultSet.getString("password");

  if(userName.equals(userNameDB) && password.equals(passwordDB))
  {
     return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
  }
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Credenziali utente errate!"; // Just returning appropriate message otherwise
}
}