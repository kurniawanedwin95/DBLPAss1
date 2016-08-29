package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.*;

public class DBLPBean implements Serializable{
	
	ArrayList<String> dblp = new ArrayList<String>();
	
	public DBLPBean() {
		dblp.add("article");
		dblp.add("inproceedings");
		dblp.add("proceedings");
		dblp.add("book");
		dblp.add("incollection");
		dblp.add("phdthesis");
		dblp.add("mastersthesis");
		dblp.add("www");
	}
	
	public ArrayList<String> getDBLP() {
		return dblp;
	}
	
	public getDBLP() {
		
	}
	
	public setDBLP(ArrayList o) {
		dblp = o;
	}

}
