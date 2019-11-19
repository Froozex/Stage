package com.stage.project.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.stage.project.auth.RegisterBean;
import com.stage.project.auth.RegisterDao;
 
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
	public RegisterServlet() {

	}
	
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	 
	       
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
	        
	       dispatcher.forward(request, response);
	 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //Copying all the input parameters in to local variables
 String fullName = request.getParameter("fullname");
 String email = request.getParameter("email");
 String userName = request.getParameter("username");
 String password = request.getParameter("password");
 
 RegisterBean registerBean = new RegisterBean();
 //Using Java Beans - An easiest way to play with group of related data
 registerBean.setFullName(fullName);
 registerBean.setEmail(email);
 registerBean.setUserName(userName);
 registerBean.setPassword(password); 
 
 RegisterDao registerDao = new RegisterDao();
 
 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
 String userRegistered = registerDao.registerUser(registerBean);
 
 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
 {
 request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
 }
 else   //On Failure, display a meaningful message to the User.
 {
 request.setAttribute("errMessage", userRegistered);
 request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
 }
 }
}
