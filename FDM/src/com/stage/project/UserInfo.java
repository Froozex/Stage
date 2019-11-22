package com.stage.project;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stage.project.auth.LoginBean;
import com.stage.project.database.DBConnection;

public class UserInfo {

	public UserInfo(LoginBean loginBean) {
		String userName = loginBean.getUserName();
		String fullName = "";
		String email = "";//Keeping user entered values in temporary variables.
		Connection conne = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conne = DBConnection.createConnection();
			System.out.println("Connessione Stabilita!");//establishing connection
			String query =("select fullName, userName, Email from data where username='?'");
			statement = conne.prepareStatement(query);
			statement.setString(1, userName);
			System.out.println("Query chiamata!");//Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
		}
	} */