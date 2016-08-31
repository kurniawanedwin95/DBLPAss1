package edu.unsw.comp9321;

import javax.xml.parsers.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class DBLPParser implements ContentHandler {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private StringBuilder builder;
	
	public DBLPParser(InputStream xmlFile) throws ParsingFailedException {
		try {
			InputSource xmlSource = new InputSource(xmlFile);
			XMLReader parser = XMLReaderFactory.createXMLReader();
			
			parser.setContentHandler(this);
			parser.parse(xmlSource);
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Failed to process XML File", e);
			throw new ParsingFailedException(e);
		}
	}
	
	public static void main(String argv[]) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {//am confused here
				
				boolean article = false;
				boolean inproceedings = false;
				boolean proceedings = false;
				boolean book = false;
				boolean incollection = false;
				boolean phdthesis = false;
				boolean masterthesis = false;
				boolean www = false;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					System.out.println("Start Element :" + qName);
					
					if(qName.equalsIgnoreCase("ARTICLE")) {
						article = true;
					}
					if(qName.equalsIgnoreCase("INPROCEEDINGS")) {
						inproceedings = true;
					}
					if(qName.equalsIgnoreCase("PROCEEDINGS")) {
						proceedings = true;
					}
					if(qName.equalsIgnoreCase("BOOK")) {
						book = true;
					}
					if(qName.equalsIgnoreCase("INCOLLECTION")) {
						incollection = true;
					}
					if(qName.equalsIgnoreCase("PHDTHESIS")) {
						phdthesis = true;
					}
					if(qName.equalsIgnoreCase("MASTERTHESIS")) {
						masterthesis = true;
					}
					if(qName.equalsIgnoreCase("WWW")) {
						www = true;
					}
				}
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println("End Element :" + qName);
				}
				
				public void characters(char ch[], int start, int length) throws SAXException {
					if(article) {
						System.out.println("Article :" + new String(ch, start, length));
						article = false;
					}
					if(inproceedings) {
						System.out.println("Inproceedings :" + new String(ch, start, length));
						inproceedings = false;
					}
					if(proceedings) {
						System.out.println("Proceedings :" + new String(ch, start, length));
						proceedings = false;
					}
					if(book) {
						System.out.println("Book :" + new String(ch, start, length));
						book = false;
					}
					if(incollection) {
						System.out.println("Incollection :" + new String(ch, start, length));
						incollection = false;
					}
					if(phdthesis) {
						System.out.println("PHDThesis :" + new String(ch, start, length));
						phdthesis = false;
					}
					if(masterthesis) {
						System.out.println("MasterThesis :" + new String(ch, start, length));
						masterthesis = false;
					}
					if(www) {
						System.out.println("WWW :" + new String(ch, start, length));
						www = false;
					}
					
				}
				
			};
			
			saxParser.parse("nijuuman.xml", handler);
			
			}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		logger.info("Adding characters to the buffer");
		builder.append(new String(ch,start,length));
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
