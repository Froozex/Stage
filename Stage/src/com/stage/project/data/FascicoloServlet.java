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




public class FascicoloServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	
	private FascicoloDao fascicoloDao;

    public void init() {
        
    	String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/utenti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("ludovico97");
 
        fascicoloDao = new FascicoloDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertFascicolo(request, response);
                    break;
                case "/delete":
                    deleteFascicolo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateFascicolo(request, response);
                    break;
                default:
                    listFascicolo(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFascicolo(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < FascicoloInfo > listFasc = fascicoloDao.ListAllFascicoli();
        request.setAttribute("listFasc", listFasc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("fascicolo-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("fascicolo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String nomina_id = request.getParameter("Nomina");
        FascicoloInfo existingFasc = fascicoloDao.getFascicolo(nomina_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("fascicolo-form.jsp");
        request.setAttribute("fasc", existingFasc);
        dispatcher.forward(request, response);

    }

    private void insertFascicolo(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 String nomina = request.getParameter("nomina");
         String procura = request.getParameter("procura");
         String pm = request.getParameter("pm");
         String pg = request.getParameter("pg");
         String indagato = request.getParameter("indagato");
         String reato = request.getParameter("reato");
         String consulente = request.getParameter("consulente");
         String ausiliario = request.getParameter("ausiliario");
         String d_incarico = request.getParameter("d_incarico");
         String d_inizio = request.getParameter("d_inizio");
         int giorni = Integer.parseInt(request.getParameter("giorni"));
         String scadenza = request.getParameter("scadenza");
         int proroga = Integer.parseInt(request.getParameter("proroga"));
         String richiesta = request.getParameter("richiesta");
         String relazione = request.getParameter("relazione");
         String costo = request.getParameter("costo");
         String pagamento = request.getParameter("pagamento");

         FascicoloInfo newfasc = new FascicoloInfo(id, nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, relazione, costo, pagamento);
         fascicoloDao.insertFascicolo(newfasc);
     	 response.sendRedirect("list");
    }

    private void updateFascicolo(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
        String nomina = request.getParameter("nomina");
        String procura = request.getParameter("procura");
        String pm = request.getParameter("pm");
        String pg = request.getParameter("pg");
        String indagato = request.getParameter("indagato");
        String reato = request.getParameter("reato");
        String consulente = request.getParameter("consulente");
        String ausiliario = request.getParameter("ausiliario");
        String d_incarico = request.getParameter("d_incarico");
        String d_inizio = request.getParameter("d_inizio");
        int giorni = Integer.parseInt(request.getParameter("giorni"));
        String scadenza = request.getParameter("scadenza");
        int proroga = Integer.parseInt(request.getParameter("proroga"));
        String richiesta = request.getParameter("richiesta");
        String relazione = request.getParameter("relazione");
        String costo = request.getParameter("costo");
        String pagamento = request.getParameter("pagamento");

        FascicoloInfo fasc = new FascicoloInfo(nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico,
					d_inizio, giorni, scadenza, proroga, richiesta,relazione,costo,pagamento);
        fascicoloDao.updateFascicolo(fasc);
        response.sendRedirect("list");
    }

    private void deleteFascicolo(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String nomina_id = request.getParameter("Nomina");
        
        FascicoloInfo  fasc = new FascicoloInfo(nomina_id);
        fascicoloDao.deleteFascicolo(fasc);
        response.sendRedirect("list");
    }
}