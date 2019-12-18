package com.stage.project.download;

import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.net.URL;  
  
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.zefer.pd4ml.PD4Constants;  
import org.zefer.pd4ml.PD4ML;  
  
 @WebServlet("/fascdownload") 
public class PD4MLServlet extends HttpServlet {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -5362765807908753988L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {  
  
        URL url = new URL("http://pd4ml.com");  
  
        PD4ML html = new PD4ML();  
        html.setPageSize( PD4Constants.A4 );  
        html.setPageInsets( new java.awt.Insets(20, 50, 10, 10) );  
        html.setHtmlWidth( 850 );  
  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        html.render( url, baos );  
  
        byte[] result = baos.toByteArray();  
  
        response.setContentType("application/pdf");   
        response.setHeader("Content-disposition","inline; filename=fascicolo.pdf");  
        response.setHeader("Pragma", "cache");  
        response.setHeader("Expires", "0");  
        response.setHeader("Cache-control", "private");  
          
        response.setContentLength(result.length);  
        ServletOutputStream sos = response.getOutputStream();   
        sos.write( result );  
    }  
}  
