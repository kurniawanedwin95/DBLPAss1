package edu.unsw.comp9321;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControlServlet
 */
@WebServlet({"/"})
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
	private ArrayList<PublicationBean> publicationBeans;

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
			this.randomTen(gsonParser);
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
		//		request.setAttribute("articles", articleBeans);
		if(request.getServletPath().equals("/details")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("details", this.publicationBeans.get(id));
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			rd.forward(request, response);
		} 
		else if(request.getServletPath().equals("/cart")) {
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/result")) {
			String searchQuery = request.getParameter("searchQuery").toLowerCase();
			this.simpleSearch(searchQuery);
			
			getServletContext().setAttribute("searchQuery", searchQuery);
			RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
		}

		else {	
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void randomTen(GSONParser gsonParser) {
		ArrayList<PublicationBean> randomTen = new ArrayList<PublicationBean>();
		Random rand = new Random();
		this.publicationBeans = gsonParser.getPublication();

		for(int i=0; i<10; i++){
			int random = rand.nextInt(publicationBeans.size())+1;
			randomTen.add(publicationBeans.get(random));
		}

		getServletContext().setAttribute("randomtens", randomTen);
	}

	public void simpleSearch(String searchQuery) {
		if(searchQuery.equalsIgnoreCase("")) {
			getServletContext().setAttribute("results", null);
		} else {
			ArrayList<PublicationBean> resultBeans = new ArrayList<PublicationBean>();
			int found=0;
			for(int id=0; id<this.publicationBeans.size();id++) {
				String author = this.publicationBeans.get(id).getAuthor();
				String title = this.publicationBeans.get(id).getTitle();
				String type = this.publicationBeans.get(id).getType();

				if(author != null) {
					if(author.toLowerCase().contains(searchQuery)) {
						resultBeans.add(this.publicationBeans.get(id));
						found++;
						continue;
					}
				}

				if(title != null) {
					if(title.toLowerCase().contains(searchQuery)) {
						resultBeans.add(this.publicationBeans.get(id));
						found++;
						continue;
					}
				}

				if(type != null) {
					if(type.toLowerCase().contains(searchQuery)) {
						resultBeans.add(this.publicationBeans.get(id));
						found++;
						continue;
					}
				}

			}
			if(found == 0) {
				getServletContext().setAttribute("results", null);
			} else {
				getServletContext().setAttribute("results", resultBeans);
			}
		}
	}

}
