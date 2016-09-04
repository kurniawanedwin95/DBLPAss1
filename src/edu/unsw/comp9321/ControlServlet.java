package edu.unsw.comp9321;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ControlServlet
 */
@WebServlet({"/"})
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			this.publicationBeans = gsonParser.getPublication();
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
		
		HttpSession session = request.getSession(true);
		if (session.isNew()) {
			session.setAttribute("users-cart",  new HashMap<Integer, PublicationBean>());
		}
		HashMap<Integer, PublicationBean> cartBeans = (HashMap<Integer, PublicationBean>) session.getAttribute("users-cart");
		
		if(request.getServletPath().equals("/details")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("details", this.publicationBeans.get(id));
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			rd.forward(request, response);
		} 

		else if(request.getServletPath().equals("/cart")) {			
			getServletContext().setAttribute("cart", cartBeans.values());
			System.out.println(cartBeans.values());
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		}

		else if(request.getServletPath().equals("/results")) {
			int page = Integer.parseInt(request.getParameter("page"));
			String searchQuery = request.getParameter("searchQuery").toLowerCase();
			ArrayList<PublicationBean> resultBeans = this.simpleSearch(searchQuery);
			boolean lastPage = this.isLastPage(resultBeans.size(), page);
			resultBeans = pagination(resultBeans, page);

			getServletContext().setAttribute("lastPage", lastPage);
			getServletContext().setAttribute("results", resultBeans);
			getServletContext().setAttribute("searchQuery", searchQuery);
			getServletContext().setAttribute("page", page);
			RequestDispatcher rd = request.getRequestDispatcher("/results.jsp");
			rd.forward(request, response);
		}

		else if(request.getServletPath().equals("/advance")) {
			RequestDispatcher rd = request.getRequestDispatcher("/advance.jsp");
			rd.forward(request, response);
		}

		else if(request.getServletPath().equals("/advance-results")) {
			int page = Integer.parseInt(request.getParameter("page"));
			String type = request.getParameter("type").toLowerCase();
			String author = request.getParameter("author").toLowerCase();
			String title = request.getParameter("title").toLowerCase();
			String publisher = request.getParameter("publisher").toLowerCase();
			String year = request.getParameter("year").toLowerCase();
			String isbn = request.getParameter("isbn").toLowerCase();
			ArrayList<PublicationBean> resultBeans = this.advanceSearch(type, author, title, publisher, year, isbn);
			boolean lastPage = this.isLastPage(resultBeans.size(), page);
			resultBeans = pagination(resultBeans, page);

			getServletContext().setAttribute("lastPage", lastPage);
			getServletContext().setAttribute("results", resultBeans);
			getServletContext().setAttribute("type", type);
			getServletContext().setAttribute("author", author);
			getServletContext().setAttribute("title", title);
			getServletContext().setAttribute("publisher", publisher);
			getServletContext().setAttribute("year", year);
			getServletContext().setAttribute("isbn", isbn);
			getServletContext().setAttribute("page", page);
			RequestDispatcher rd = request.getRequestDispatcher("/advance-results.jsp");
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
		
		HttpSession session = request.getSession(true);
		if (session.isNew()) {
			session.setAttribute("users-cart",  new HashMap<Integer, PublicationBean>());
		}
		HashMap<Integer, PublicationBean> cartBeans = (HashMap<Integer, PublicationBean>) session.getAttribute("users-cart");

		if(request.getServletPath().equals("/add-cart")) {
			int id = Integer.parseInt(request.getParameter("id"));
			this.addToCart(cartBeans, id);
			
			getServletContext().setAttribute("cart", cartBeans.values());
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		} 
		
		else if(request.getServletPath().equals("/delete-cart")) {			
			if(request.getParameterValues("delete-cart") == (null)) {
				
			}
			else {
				ArrayList<Integer> arrayint = new ArrayList<Integer>();
				String id[] = request.getParameterValues("delete-cart");
				for (int i = 0; i < id.length; i++) {
					arrayint.add(Integer.parseInt(id[i]));
				}
				
				this.deleteFromCart(cartBeans, arrayint);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		}
		
		else {
			doGet(request, response);
		}
		
		session.setAttribute("users-cart",  cartBeans);
	}

	public void randomTen(GSONParser gsonParser) {
		ArrayList<PublicationBean> randomTen = new ArrayList<PublicationBean>();
		Random rand = new Random();

		for(int i=0; i<10; i++){
			int random = rand.nextInt(this.publicationBeans.size())+1;
			randomTen.add(this.publicationBeans.get(random));
		}

		getServletContext().setAttribute("randomtens", randomTen);
	}

	public ArrayList<PublicationBean> simpleSearch(String searchQuery) {
		ArrayList<PublicationBean> resultBeans = new ArrayList<PublicationBean>();
		if(searchQuery.equalsIgnoreCase("")) {

		} else {
			for(int id=0; id<this.publicationBeans.size();id++) {

				if(this.publicationBeans.get(id).getAuthor().toLowerCase().contains(searchQuery)) {
					resultBeans.add(this.publicationBeans.get(id));
					continue;
				}


				if(this.publicationBeans.get(id).getTitle().toLowerCase().contains(searchQuery)) {
					resultBeans.add(this.publicationBeans.get(id));
					continue;
				}

				if(this.publicationBeans.get(id).getType().toLowerCase().contains(searchQuery)) {
					resultBeans.add(this.publicationBeans.get(id));
					continue;
				}

				if(this.publicationBeans.get(id).getYear().toLowerCase().contains(searchQuery)) {
					resultBeans.add(this.publicationBeans.get(id));
					continue;
				}

			}
		}
		return resultBeans;
	}

	public ArrayList<PublicationBean> advanceSearch(String type, String author, String title, String publisher,
			String year, String isbn) {
		ArrayList<PublicationBean> resultBeans = new ArrayList<PublicationBean>();

		if(type.equals("") && author.equals("") && title.equals("") && 
				publisher.equals("") && year.equals("") && isbn.equals("")) {

		}
		else {
			for(int id=0; id<this.publicationBeans.size();id++) {

				if(this.publicationBeans.get(id).getType().toLowerCase().contains(type) && 
						this.publicationBeans.get(id).getAuthor().toLowerCase().contains(author) && 
						this.publicationBeans.get(id).getTitle().toLowerCase().contains(title) && 
						this.publicationBeans.get(id).getPublisher().toLowerCase().contains(publisher) && 
						this.publicationBeans.get(id).getYear().toLowerCase().contains(year) &&
						this.publicationBeans.get(id).getIsbn().toLowerCase().contains(isbn)) {

					resultBeans.add(this.publicationBeans.get(id));
				}
			}
		}
		return resultBeans;
	}

	public ArrayList<PublicationBean> pagination(ArrayList<PublicationBean> resultBeans, int page) {
		ArrayList<PublicationBean> pagedBeans = new ArrayList<PublicationBean>();
		int lowerbound = (page-1)*10;
		int upperbound = (page*10)-1;
		for(int i=lowerbound; (i<=upperbound) && (i<resultBeans.size()); i++) {
			pagedBeans.add(resultBeans.get(i));
		}
		return pagedBeans;
	}

	public boolean isLastPage(int beanSize, int page) {
		int last = page*10;
		if(last >= beanSize) {
			return true;
		} else {
			return false;
		}
	}

	public void addToCart(HashMap<Integer, PublicationBean> cartBeans, int id) {
		cartBeans.put(id, this.publicationBeans.get(id));
	}
	
	public void deleteFromCart(HashMap<Integer, PublicationBean> cartBeans, ArrayList<Integer> id) {
		for(int i=0; i<id.size(); i++) {
			cartBeans.remove(id.get(i));
		}
	}

}
