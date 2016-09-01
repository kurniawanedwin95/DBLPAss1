package edu.unsw.comp9321;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class GSONParser {
	private ArrayList<ArticleBean> articles;
	private ArticleBean article;
	
	public GSONParser() {
		super();
		
		try {
			JsonReader jsonReader = new JsonReader(new FileReader("trimmed-dblp.json"));
			Gson gson = new GsonBuilder().create();

			jsonReader.beginObject();
			while(jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if(name.equals("dblp")) {
					readJson(jsonReader);
				}
			}
			jsonReader.endObject();
			jsonReader.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void init() throws ServletException {
//		try {
//			JsonReader jsonReader = new JsonReader(new FileReader("trimmed-dblp.json"));
//			Gson gson = new GsonBuilder().create();
//
//			jsonReader.beginObject();
//			while(jsonReader.hasNext()) {
//				String name = jsonReader.nextName();
//				if(name.equals("dblp")) {
//					readJson(jsonReader);
//				}
//			}
//			jsonReader.endObject();
//			jsonReader.close();			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void readJson(JsonReader jsonReader) throws IOException {
		jsonReader.beginObject();
		while(jsonReader.hasNext()) {
			String name = jsonReader.nextName();
			System.out.println(name);
			if(name.contains("article")) {
				articles = new ArrayList<ArticleBean>();
				articles.add(article);
				jsonReader.beginObject();
				while(jsonReader.hasNext()) {
					String n = jsonReader.nextName();
					if(n.equals("author")){
						String input = jsonReader.nextString();
						System.out.println("Article author: " + input);
						article.setAuthor(input);
					}
					if(n.equals("title")){
						String input = jsonReader.nextString();
						System.out.println("Article title: " + input);
						article.setTitle(input);
					}
					if(n.equals("publisher")){
						String input = jsonReader.nextString();
						System.out.println("Article publisher: " + input);
						article.setPublisher(input);
					}
					if(n.equals("year")){
						int input = jsonReader.nextInt();
						System.out.println("Article year: " + input);
						article.setYear(input);
					}
					if(n.equals("isbn")){
						String input = jsonReader.nextString();
						System.out.println("Article isbn: " + input);
						article.setIsbn(input);
					}
//					if (n.equals("messages")){
//	                     jsonReader.beginArray();
//	                     while  (jsonReader.hasNext()) {
//	                          System.out.println(jsonReader.nextString());
//	                     }
//	                     jsonReader.endArray();
//	                }
				}
				jsonReader.endObject();
			}
		}
		jsonReader.endObject();
	}
	
	public ArrayList<ArticleBean> getArticle() {
		return articles;
	}
	
}
