package com.stage.project.data;

//import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet({"/reperti", "/newreperto", "/insertreperto", "/deletereperto", "/editreperto", "/updatereperto"})
public class RepertoServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
	private RepertoDao repertoDao;

  public void init() {
      
  	String jdbcURL = "jdbc:mysql://localhost:3306/utenti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
      String jdbcUsername = "root";
      String jdbcPassword = "ludovico97";

      repertoDao = new RepertoDao(jdbcURL, jdbcUsername, jdbcPassword);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
  	
  	String action = request.getServletPath();
  	System.out.println(action);
  	System.out.println("received HTTP GET");

      try {
      	System.out.println("entra nel try");
      	System.out.println(action);
          if (action.equals("/newreperto")) {
          	System.out.println("esegue newreperto");
              newReperto(request, response);}
          else if(action.equals("/insertreperto")) {
          	insertReperto(request, response);}
          else if(action.equals("/deletereperto")) {
          	deleteReperto(request, response);}
          else if(action.equals("/editreperto")) {
          	editReperto(request, response);}
          else if(action.equals("/updatereperto")) {
          	updateReperto(request, response);}
          else {listReperto(request, response);}
              /*case "fascicoli/new":
              	System.out.println("porcamadonna new");
                  newFascicolo(request, response);
                  break;
              case "fascicoli/insert":
                  insertFascicolo(request, response);
                  break;
              case "fascicoli/delete":
                  deleteFascicolo(request, response);
                  break;
              case "fascicoli/edit":
                  editFascicolo(request, response);
                  break;
              case "fascicoli/update":
                  updateFascicolo(request, response);
                  break;
              default:
              	System.out.println("default di merda");
                  listFascicolo(request, response);
                  break;
          }*/
      } catch (SQLException ex) {
          throw new ServletException(ex);
      }
  }

  private void listReperto(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, IOException, ServletException {
      List < RepertoInfo > listRep = repertoDao.ListAllReperti();
      request.setAttribute("listRep", listRep);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/reperto-list.jsp");
      dispatcher.forward(request, response);
  }

  private void newReperto(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/reperto-form.jsp");
      dispatcher.forward(request, response);
  }

  private void editReperto(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, ServletException, IOException {
      String nomina_id = request.getParameter("nomina");
      RepertoInfo existingRep = repertoDao.getReperto(nomina_id);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/reperto-form.jsp");
      request.setAttribute("rep", existingRep);
      dispatcher.forward(request, response);

  }

  private void insertReperto(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, IOException {
  	 
  	   //String nomina = request.getParameter("nomina");
       String nreperto = request.getParameter("nreperto");
       String sequestrato = request.getParameter("sequestrato");
       String supporto = request.getParameter("supporto");
       String seriale = request.getParameter("seriale");
       String note = request.getParameter("note");
       String operazioni = request.getParameter("operazioni");

       RepertoInfo newrep = new RepertoInfo(nreperto, sequestrato, supporto, seriale, note, operazioni);
       repertoDao.insertReperto(newrep);
       
   	 response.sendRedirect("reperti");
  }

  private void updateReperto(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, IOException {
  	
  	  //String nomina = request.getParameter("nomina");
      String nreperto = request.getParameter("nreperto");
      String sequestrato = request.getParameter("sequestrato");
      String supporto = request.getParameter("supporto");
      String seriale = request.getParameter("seriale");
      String note = request.getParameter("note");
      String operazioni = request.getParameter("operazioni");

      RepertoInfo rep = new RepertoInfo(nreperto, sequestrato, supporto, seriale, note, operazioni);
      repertoDao.updateReperto(rep);
      System.out.println(rep);
      response.sendRedirect("reperti");
  }

  private void deleteReperto(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, IOException {
      String nomina_id = request.getParameter("nomina");
      
      RepertoInfo  rep = new RepertoInfo(nomina_id);
      repertoDao.deleteReperto(rep);
      System.out.println("Reperto rimosso?");
      response.sendRedirect("reperti");
  }
}
