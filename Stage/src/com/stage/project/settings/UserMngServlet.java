package com.stage.project.settings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stage.project.settings.UserInfo;
import com.stage.project.settings.UserMngDao;
import com.stage.project.data.FascicoloDao;
import com.stage.project.data.FascicoloInfo;
import com.stage.project.database.DBConnection;

@WebServlet({"/userslist", "/deleteuser"})
public class UserMngServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserMngDao usermngDao;
	
public void init() {
        
	String jdbcURL = "jdbc:mysql://localhost:3306/iif_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String jdbcUsername = "root";
    String jdbcPassword = "IIFLuca%Russo";
 
        usermngDao = new UserMngDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        
	    	doGet(request, response);
	    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
    	
        if (action.equals("/userslist")) {
        	ListUsers(request, response);}
        else if(action.equals("/deleteuser")) {
        	DeleteUser(request, response);}
        else {RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        		dispatcher.forward(request, response);}
	
		} catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void ListUsers(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < UserInfo > listUsers = usermngDao.ListAllUtenti();
	        request.setAttribute("listUsers", listUsers);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user_info.jsp");
	        dispatcher.forward(request, response);

		}
	
	private void DeleteUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, IllegalStateException, ServletException {
		        String email = request.getParameter("email");
		        
		        UserInfo user = new UserInfo(email);
		        usermngDao.deleteUtente(user);
		        response.sendRedirect("userlist");
		    }
}