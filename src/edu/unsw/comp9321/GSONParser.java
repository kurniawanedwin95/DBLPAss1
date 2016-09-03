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

	private ArrayList<ArticleBean> articleBeans;
	private ArrayList<BookBean> bookBeans;
	private ArrayList<InproceedingsBean> inproceedingsBeans;
	private ArrayList<ProceedingsBean> proceedingsBeans;
	private ArrayList<IncollectionBean> incollectionBeans;
	private ArrayList<MastersThesisBean> mastersThesisBeans;
	private ArrayList<PHDThesisBean> phdThesisBeans;
	private ArrayList<WWWBean> wwwBeans;

	public GSONParser() {
		try {
			String path = new File("WebContent/WEB-INF/trimmed-dblp.json").getAbsolutePath();
			JsonReader jsonReader = new JsonReader(new FileReader(path));

			Gson gson = new Gson();

			jsonReader.beginObject();
			while (jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				System.out.println("before switch");
				switch (name) {
				case "article":
					Type articleBeanListType = new TypeToken<ArrayList<ArticleBean>>() {}.getType();
					articleBeans = gson.fromJson(jsonReader, articleBeanListType);
					System.out.println(articleBeans.size());
					System.out.println(name);
					break;
				case "book":
					Type bookBeanListType = new TypeToken<ArrayList<BookBean>>() {}.getType();
					bookBeans = gson.fromJson(jsonReader, bookBeanListType);
					System.out.println(bookBeans.size());
					System.out.println(name);
					break;
				case "inproceedings":
					Type inproceedingsBeanListType = new TypeToken<ArrayList<InproceedingsBean>>() {}.getType();
					inproceedingsBeans = gson.fromJson(jsonReader,  inproceedingsBeanListType);
					System.out.println(inproceedingsBeans.size());
					System.out.println(name);
					break;
				case "proceedings":
					Type proceedingsBeanListType = new TypeToken<ArrayList<ProceedingsBean>>() {}.getType();
					proceedingsBeans = gson.fromJson(jsonReader, proceedingsBeanListType);
					System.out.println(proceedingsBeans.size());
					System.out.println(name);
					break;
				case "incollection":
					Type incollectionBeanListType = new TypeToken<ArrayList<IncollectionBean>>() {}.getType();
					incollectionBeans = gson.fromJson(jsonReader, incollectionBeanListType);
					System.out.println(incollectionBeans.size());
					System.out.println(name);
					break;
				case "mastersthesis":
					Type masterThesisBeanListType = new TypeToken<ArrayList<MastersThesisBean>>() {}.getType();
					mastersThesisBeans = gson.fromJson(jsonReader, masterThesisBeanListType);
					System.out.println(mastersThesisBeans.size());
					System.out.println(name);
					break;
				case "phdthesis":
					Type phdThesisBeanListType = new TypeToken<ArrayList<PHDThesisBean>>() {}.getType();
					phdThesisBeans = gson.fromJson(jsonReader, phdThesisBeanListType);
					System.out.println(phdThesisBeans.size());
					System.out.println(name);
					break;
				case "www":
					Type wwwBeanListType = new TypeToken<ArrayList<WWWBean>>() {}.getType();
					wwwBeans = gson.fromJson(jsonReader, wwwBeanListType);
					System.out.println(wwwBeans.size());
					System.out.println(name);
					break;
				default:
					System.out.println("im in default");
					break;
				}
			}
			jsonReader.endObject();
			jsonReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ArticleBean> getArticle() {
		return articleBeans;
	}
	
	public ArrayList<BookBean> getBook() {
		return bookBeans;
	}
	
	public ArrayList<InproceedingsBean> getInproceedings() {
		return inproceedingsBeans;
	}
	
	public ArrayList<ProceedingsBean> getProceedings() {
		return proceedingsBeans;
	}
	
	public ArrayList<IncollectionBean> getIncollection() {
		return incollectionBeans;
	}

	public ArrayList<MastersThesisBean> getMastersThesis() {
		return mastersThesisBeans;
	}
	
	public ArrayList<PHDThesisBean> getPHDThesis() {
		return phdThesisBeans;
	}
	
	public ArrayList<WWWBean> getWWW() {
		return wwwBeans;
	}
	

}
