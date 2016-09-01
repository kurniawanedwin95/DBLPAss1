package edu.unsw.comp9321;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Servlet implementation class ControlServlet
 */
@WebServlet({"/","/search"})
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ArticleBean> articles;
	Logger logger = Logger.getLogger(this.getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	super.init();
    	
//    	InputStream is = getServletContext().getResourceAsStream("/WEB-INF/test.xml");
//    	DBLPParser parser;
    	GSONParser gsonParser;
    	try {
//    		parser = new DBLPParser(is);
    		gsonParser = new GSONParser();
    	} catch(Exception e) {
    		logger.severe("XML parsing failed"+e.getMessage());
    		throw new ServletException(e);
    	}
//    	List<DBLPBean> dblp = parser.getDBLP();
//    	articles = parser.getArticle();
    	articles = gsonParser.getArticle();
//    	System.out.println(articles.toString());
    	getServletContext().setAttribute("article", articles);
    	//gotta make list of parsed stuff available for the entire app
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(articles.toString());
		request.setAttribute("articles", articles);
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
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
