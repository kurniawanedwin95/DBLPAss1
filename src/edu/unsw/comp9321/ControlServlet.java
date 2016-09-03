package edu.unsw.comp9321;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
	private ArrayList<ArticleBean> articleBeans;
	private ArrayList<BookBean> bookBeans;
	private ArrayList<InproceedingsBean> inproceedingsBeans;
	private ArrayList<ProceedingsBean> proceedingsBeans;
	private ArrayList<IncollectionBean> incollectionBeans;
	private ArrayList<MastersThesisBean> mastersThesisBeans;
	private ArrayList<PHDThesisBean> phdThesisBeans;
	private ArrayList<WWWBean> wwwBeans;
	
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
    	
    	GSONParser gsonParser;
    	try {
    		gsonParser = new GSONParser();
    		randomTen(gsonParser);
    	} catch(Exception e) {
    		logger.severe("XML parsing failed"+e.getMessage());
    		throw new ServletException(e);
    	}

//    	articles = gsonParser.getArticle();
//    	getServletContext().setAttribute("article", articles);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("articles", articleBeans);
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
	
	public void randomTen(GSONParser gsonParser) {
		//will get 1 articles, 2 books, 1 proceedings, 1 inproceedings, 1 mastersthesis, 1 phdthesis, 1 incollection, 2 www 
		ArrayList randomTen = new ArrayList();
		
		articleBeans = gsonParser.getArticle();
		bookBeans = gsonParser.getBook();
		inproceedingsBeans = gsonParser.getInproceedings();
		proceedingsBeans = gsonParser.getProceedings();
		incollectionBeans = gsonParser.getIncollection();
		mastersThesisBeans = gsonParser.getMastersThesis();
		phdThesisBeans = gsonParser.getPHDThesis();
		wwwBeans = gsonParser.getWWW();
		randomTen.add(articleBeans.get(1));
		randomTen.add(bookBeans.get(1));
		randomTen.add(bookBeans.get(2));
		randomTen.add(inproceedingsBeans.get(1));
		randomTen.add(proceedingsBeans.get(1));
		randomTen.add(incollectionBeans.get(1));
		randomTen.add(mastersThesisBeans.get(1));
		randomTen.add(phdThesisBeans.get(1));
		randomTen.add(wwwBeans.get(1));
		randomTen.add(wwwBeans.get(2));
		
    	getServletContext().setAttribute("randomtens", randomTen);
	}

}
