package data_connect;


import java.util.HashMap;
import java.util.Map;

public class Books {
	 
	Map<Integer,Books> map = new HashMap<Integer, Books>();
	
	private int Status;
	private int Author_id;
	public String Book_name;
	private int price;
	


public Books(){
	
}
 public Books(int Status,int Author_id, String Book_name, int price){
	 this.Status=Status;
	 this.Author_id=Author_id;
	 this.Book_name=Book_name;
	 this.price=price;
 }
public Map<Integer, Books> getMap() {
	return map;
}


public int getAuthor_id() {
	return Author_id;
}


public String getBook_name() {
	return Book_name;
}

public int getPrice() {
	return price;
}

public String ToString(){
	return this.Status+""+this.Author_id +" "+this.Book_name+" "+this.price;
}
public void setMap(Map<Integer, Books> map) {
	this.map = map;
}
public void setAuthor_id(int author_id) {
	Author_id = author_id;
}
public void setBook_name(String book_name) {
	Book_name = book_name;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}

}