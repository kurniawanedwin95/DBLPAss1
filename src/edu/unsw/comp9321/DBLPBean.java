package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.*;

public class DBLPBean{
	
	private String article;
	private String book;
	private String inproceedings;
	private String proceedings;
	private String incollection;
	private String masterthesis;
	private String phdthesis;
	private String www;
	private String author;
	private String title;
	private String publisher;
	private String isbn;
//	private String ee;
	private int year;

	public DBLPBean() {
	}
	
	public DBLPBean(String article, String book, String inproceedings, String proceedings, 
			String incollection, String masterthesis, String phdthesis, String www,
			String author, String title, String publisher, String isbn, int year) {
		super();
		this.setArticle(article);
		this.setBook(book);
		this.setInproceedings(inproceedings);
		this.setProceedings(proceedings);
		this.setIncollection(incollection);
		this.setMasterthesis(masterthesis);
		this.setPhdthesis(phdthesis);
		this.setWww(www);
		this.setAuthor(author);
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setIsbn(isbn);
		this.setYear(year);
	}
	

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getInproceedings() {
		return inproceedings;
	}

	public void setInproceedings(String inproceedings) {
		this.inproceedings = inproceedings;
	}

	public String getProceedings() {
		return proceedings;
	}

	public void setProceedings(String proceedings) {
		this.proceedings = proceedings;
	}

	public String getIncollection() {
		return incollection;
	}

	public void setIncollection(String incollection) {
		this.incollection = incollection;
	}

	public String getMasterthesis() {
		return masterthesis;
	}

	public void setMasterthesis(String masterthesis) {
		this.masterthesis = masterthesis;
	}

	public String getPhdthesis() {
		return phdthesis;
	}

	public void setPhdthesis(String phdthesis) {
		this.phdthesis = phdthesis;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
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
