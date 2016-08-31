package edu.unsw.comp9321;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/result",displayName="IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	super.init();
    	
    	InputStream is = getServletContext().getResourceAsStream("/WEB-INF/nijuuman.xml");
    	DBLPParser parser;
    	try {
    		parser = new DBLPParser(is);
    	} catch(ParsingFailedException e) {
    		logger.severe("XML parsing failed"+e.getMessage());
    		throw new ServletException(e);
    	}
    	
    	//gotta make list of parsed stuff available for the entire app
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
