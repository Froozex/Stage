package com.stage.project.data;

//import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import com.stage.project.auth.LoginBean;



@WebServlet({"/fascicoli", "/newfascicolo", "/insertfascicolo", "/deletefascicolo", "/editfascicolo", "/updatefascicolo"})
@MultipartConfig(maxFileSize = 16177215)
public class FascicoloServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	
	private FascicoloDao fascicoloDao;
	InputStream relazione = null;
	
	
    public void init() {
        
    	String jdbcURL = "jdbc:mysql://localhost:3306/iif_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String jdbcUsername = "root";
        String jdbcPassword = "IIFLuca%Russo";
 
        fascicoloDao = new FascicoloDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        
    	    	doGet(request, response);
    	    }

    	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	
    	    	String action = request.getServletPath();
    	    	System.out.println("received HTTP GET");

    	        try {
    	        	System.out.println("entra nel try");
    	        	System.out.println(action);
    	            if (action.equals("/newfascicolo")) {
    	            	System.out.println("esegue new");
    	                newFascicolo(request, response);}
    	            else if(action.equals("/insertfascicolo")) {
    	            	insertFascicolo(request, response);}
    	            else if(action.equals("/deletefascicolo")) {
    	            	deleteFascicolo(request, response);
    	            	System.out.println("entra in elimina");}
    	            else if(action.equals("/editfascicolo")) {
    	            	editFascicolo(request, response);}
    	            else if(action.equals("/updatefascicolo")) {
    	            	updateFascicolo(request, response);}
    	            else {listFascicolo(request, response);}
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

    	    private void listFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List < FascicoloInfo > listFasc = fascicoloDao.ListAllFascicoli();
    	        request.setAttribute("listFasc", listFasc);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fascicolo-list.jsp");
    	        dispatcher.forward(request, response);
    	    }

    	    private void newFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fascicolo-form.jsp");
    	        dispatcher.forward(request, response);
    	    }

    	    private void editFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	        String nomina_id = request.getParameter("nomina");
    	        FascicoloInfo existingFasc = fascicoloDao.getFascicolo(nomina_id);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fascicolo-form.jsp");
    	        request.setAttribute("fasc", existingFasc);
    	        dispatcher.forward(request, response);

    	    }

    	    private void insertFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, IllegalStateException, ServletException {
    	    	
    	    	
    	    	
    	    	int id = 0;
    	    	if(request.getParameter("id")=="" || request.getParameter("id")==null) {
    	    		id = 0;
    	    	} else id = Integer.parseInt(request.getParameter("id"));
    	    	
    	    	
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
    	         Part filePart = request.getPart("relazione");
    	         if (filePart != null) {
    	             // prints out some information for debugging
    	             System.out.println(filePart.getName());
    	             System.out.println(filePart.getSize());
    	             System.out.println(filePart.getContentType());

    	             // obtains input stream of the upload file
    	             relazione = filePart.getInputStream();}
    	         String scelta1 = request.getParameter("costo");
    	         String costo = (scelta1.equals("SI")?"SI":"NO");
    	         String scelta = request.getParameter("pagamento");
    	         String pagamento = (scelta.equals("SI")?"SI":"NO");

    	         FascicoloInfo newfasc = new FascicoloInfo(id, nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico, d_inizio, giorni, scadenza, proroga, richiesta, costo, pagamento);
    	         fascicoloDao.insertFascicolo(newfasc);
    	     	 response.sendRedirect("fascicoli");
    	    }

    	    private void updateFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, IllegalStateException, ServletException {
    	    	
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
    	        Part filePart = request.getPart("relazione");
    	        if (filePart != null) {
    	            // prints out some information for debugging
    	            System.out.println(filePart.getName());
    	            System.out.println(filePart.getSize());
    	            System.out.println(filePart.getContentType());

    	            // obtains input stream of the upload file
    	            relazione = filePart.getInputStream();}
    	        String scelta1 = request.getParameter("costo");
    	        String costo = (scelta1.equals("SI")?"SI":"NO");
    	        String scelta2 = request.getParameter("pagamento");
    	        String pagamento = (scelta2.equals("SI")?"SI":"NO");

    	        FascicoloInfo fasc = new FascicoloInfo(nomina, procura, pm, pg, indagato, reato, consulente, ausiliario, d_incarico,
    						d_inizio, giorni, scadenza, proroga, richiesta,relazione, costo, pagamento);
    	        fascicoloDao.updateFascicolo(fasc);
    	        response.sendRedirect("fascicoli");
    	    }

    	    private void deleteFascicolo(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, IllegalStateException, ServletException {
    	        String nomina = request.getParameter("nomina");
    	        
    	        FascicoloInfo  fasc = new FascicoloInfo(nomina);
    	        fascicoloDao.deleteFascicolo(fasc);
    	        response.sendRedirect("fascicoli");
    	    }
    	    
    	}