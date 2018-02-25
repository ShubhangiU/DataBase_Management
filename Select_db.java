package data_connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import data_connect.Books;
 
/*
 * Here we will learn to connect to Oracle DB using JDBC Driver.
 */
public class Select_db {
	
	 
 
	public static void main(String[] args) throws SQLException, IOException {
		
		 Map <Integer, Books> map = new HashMap<Integer, Books>();
		 
		
 
        System.out.println("connecting to Oracle Database");
		
		String dbName ="XE";
		
		String userName = "dbuser";
	
		String password = "abcd";
	    
		 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 
		Connection connection = null;
		
		
		Statement stmt=null;
	
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:" + dbName, userName,password);
			System.out.println("connected to oracle databse");
			Statement statement = connection.createStatement();	
			ResultSet resultSet1 = statement.executeQuery("SELECT * from books");
			ResultSetMetaData rsmd = resultSet1.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet1.next()) {
				Integer Status=resultSet1.getInt("Status");
				Integer Author_id=resultSet1.getInt("Author_id");
				String Book_name= resultSet1.getString("Book_name");
				Integer price= resultSet1.getInt("price");
				Books book= new Books(Status,Author_id,Book_name,price);
				map.put(Author_id, book);
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(",  ");
			       String columnValue = resultSet1.getString(i);
			       System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");
			}
		     
		} catch (SQLException e) {
			
			System.out.println("");
			e.printStackTrace();
		}
				for(Integer j : map.keySet()){
			Books book=map.get(j);
			//String bk= book.ToString();
		//	System.out.println("HashMap Values Inserted:" +bk);
			stmt = connection.createStatement();
			//int status= book.getStatus();
			int aid = book.getAuthor_id();
			String bookname = book.getBook_name();
			int p = book.getPrice();
	
			String sql="insert into books_copy(STATUS,AUTHOR_ID,BOOK_NAME, PRICE) values(1,'"+aid+"','"+bookname+"','"+p+"')";
			 stmt.executeUpdate(sql);
					 
		
				}
		
		if (connection != null) {
			System.out.println("Successfullly connected to Oracle DB");
		}
		else {
			System.out.println("failed to connect to Oracle database");
		}
		
		
	}
	

		

}

