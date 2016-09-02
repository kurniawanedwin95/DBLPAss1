package edu.unsw.comp9321;

public class BookBean {
	private String author;
	private String title;
	private String publisher;
	private String isbn;
	private int year;
	
	public BookBean() {
		
	}
	public BookBean(String author, String title, String publisher, String isbn, int year) {
		super();
		this.setAuthor(author);
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setIsbn(isbn);
		this.setYear(year);
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
