package edu.unsw.comp9321;

import javax.xml.parsers.*;
import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class DBLPParser implements ContentHandler{
	
	private StringBuilder builder;
	private ArrayList<DBLPBean> publications;
	private ArrayList<ArticleBean> articles;
	private enum TagType {article, book, inproceedings, proceedings, incollection, masterthesis, 
		phdthesis, www, author, title, publisher, isbn, year, unidentified};	
	private TagType openingTag = TagType.unidentified, closingTag = TagType.unidentified;
	private ArticleBean article;
	private DBLPBean book;
	private DBLPBean inproceedings;
	private DBLPBean proceedings;
	private DBLPBean incollection;
	private DBLPBean masterthesis;
	private DBLPBean phdthesis;
	private DBLPBean www;
	
//	boolean article = false;
//	boolean inproceedings = false;
//	boolean proceedings = false;
//	boolean book = false;
//	boolean incollection = false;
//	boolean phdthesis = false;
//	boolean masterthesis = false;
//	boolean www = false;
		
	public DBLPParser(InputStream is) {
		articles = new ArrayList<ArticleBean>();
		try {
			InputSource xml = new InputSource(is);
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser(); //might be ok to comment this
			
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(this);
			parser.setFeature("http://xml.org/sax/features/validation", false);
			parser.parse(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public ArrayList<DBLPBean> getDBLP() {
//		return publications;
//	}
	
	public ArrayList<ArticleBean> getArticle() {
		return articles;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		builder.append(new String(ch,start,length));
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing Ended");
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			closingTag = TagType.valueOf(TagType.class,qName);
		} catch(Exception e) {
			closingTag = TagType.unidentified;
		}
		String content = builder.toString();
		
		switch(closingTag){
		case article:
			articles.add(article);
			break;
		case book:
			articles.add(article);
			break;
		case author:
			article.setAuthor(content);
			System.out.println(content);
		default:
			break;
		}
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("Start Element :" + qName);
		try{
			openingTag = TagType.valueOf(TagType.class,qName);
		}catch(Exception e){
			openingTag = TagType.unidentified;
		}
		
		/*
		 * Create a new bean when opening tag for book element is encountered  
		 */
		if(openingTag.toString().equals("article")){
			article=new ArticleBean();
		}
		if(openingTag.toString().equals("book")){
			article=new ArticleBean();
		}
		
		/* Create a new character buffer to hold contents of the element */
		builder = new StringBuilder();
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}
}
	
