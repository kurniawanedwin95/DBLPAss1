package edu.unsw.comp9321;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.lang.reflect.Type;
import javax.servlet.ServletException;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;

public class GSONParser {
	private ArrayList<ArticleBean> articles;
	private ArticleBean article;

	private ArrayList<BookBean> books;
	private BookBean book;

	public GSONParser() {
		try {
	    String path = new File("WebContent/WEB-INF/trimmed-dblp.json").getAbsolutePath();
			JsonReader jsonReader = new JsonReader(new FileReader(path));
      
      Gson gson = new Gson();
      ArrayList<ArticleBean> articleBeans;

      jsonReader.beginObject();
      while (jsonReader.hasNext()) {
        String name = jsonReader.nextName();
        System.out.println("am here");
        switch (name) {
          case "article":
            Type articleBeanListType = new TypeToken<ArrayList<ArticleBean>>() {}.getType();
            articleBeans = gson.fromJson(jsonReader, articleBeanListType);
            System.out.println(name);
            System.out.println("please?");
            break;
        }
      }
      jsonReader.endObject();
			jsonReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

//  private ArrayList<ArticleBean> readArticleList(JsonReader jsonReader) {
//    Gson gson = new Gson();
//
//    jsonReader.beginArray();
//    while (jsonReader.hasNext()) {
//      jsonReader.beginObject();
//      gson.fromJson(jsonReader);
//    }
//  }

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

			if(name.contains("book")) {
				books = new ArrayList<BookBean>();
				books.add(book);
				jsonReader.beginObject();
				while(jsonReader.hasNext()) {
					String n = jsonReader.nextName();
					if(n.equals("author")){
						String input = jsonReader.nextString();
						System.out.println("Book author: " + input);
						book.setAuthor(input);
					}
					if(n.equals("title")){
						String input = jsonReader.nextString();
						System.out.println("Book title: " + input);
						book.setTitle(input);
					}
					if(n.equals("publisher")){
						String input = jsonReader.nextString();
						System.out.println("Book publisher: " + input);
						book.setPublisher(input);
					}
					if(n.equals("year")){
						int input = jsonReader.nextInt();
						System.out.println("Book year: " + input);
						book.setYear(input);
					}
					if(n.equals("isbn")){
						String input = jsonReader.nextString();
						System.out.println("Book isbn: " + input);
						book.setIsbn(input);
					}
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
