package edu.unsw.comp9321;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class DBLPP {
	
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

}
