package com.stage.project.auth;
 
 import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
import com.stage.project.auth.LoginBean;
 import com.stage.project.auth.LoginDao;
 
@WebServlet(urlPatterns = {"/login"})
 public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
public LoginServlet() {
 	}


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

     
    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
     
    dispatcher.forward(request, response);
   
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
	 System.out.println("Pagina caricata con successo!");
	 
String userName = request.getParameter("username");
 String password = request.getParameter("password");
 


 LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
 loginBean.setPassword(password);
 
LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
 
String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
 {
	 
 request.setAttribute("userName", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
 request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
 }
 else
 {
	 
	 System.out.println("Errore!");
 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returns other than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);//forwarding the request
 }
 }
 
}