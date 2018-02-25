package data_connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import data_connect.Books;

public class Update_db {

		private static Scanner sc1;
		private static Scanner sc;

		public static void main(String[] args) throws SQLException, IOException {
			
			 Map <Integer, Books> map = new HashMap<Integer, Books>();
			 Books book= new Books();
			 
			
	 
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
		    String ch;
		    sc = new Scanner(System.in);
		    System.out.println("enter your choice:");
		    ch = sc.next();
		    switch (ch) {
		        case "insert":		        	
		        {
		            try{
		            	
		    			connection = DriverManager.getConnection(
		    					"jdbc:oracle:thin:@localhost:1521:" + dbName, userName,password);
		    			System.out.println("connected to oracle databse");
		    			Statement statement = connection.createStatement();
		    			
		    			sc1 = new Scanner(System.in);
		    			
		    			System.out.println("enter Status:");
		    		    int  status = sc1.nextInt();
		    		    book.setStatus(status);
		    		    System.out.println("enter Author_id:");
		    		    int  id = sc1.nextInt();
		    		    book.setAuthor_id(id);
		    		    System.out.println("enter Book_name:");
		    		    String  bk = sc1.next();
		    		    book.setBook_name(bk);
		    		    System.out.println("enter Book_price:");
		    		    int  bp = sc1.nextInt();
		    		    book.setPrice(bp);
		    		    map.put(id, book);
		    			String query ="insert into Books VALUES('"+status+"', '"+id+"' ,'"+bk+"' , '"+bp+"') ";
		    			statement.executeUpdate(query);
		    			System.out.println("values inserted in Books");
		    			
		    		     
		    		} catch (SQLException e) {
		    			
		    			System.out.println("");
		    			e.printStackTrace();
		    		} finally {
					}
		    				
		    			stmt = connection.createStatement();
		    			int status= book.getStatus();
		    			int aid = book.getAuthor_id();
		    			String bookname = book.getBook_name();
		    			int p = book.getPrice();
		    			if(status ==0){
		    			String sql="insert into books_copy values('"+status+"','"+aid+"','"+bookname+"','"+p+"')";
		    			 stmt.executeUpdate(sql);
		    			 System.out.println("values inserted in Books_copy");
		    			
		    			}
		    			else{
		    				System.out.println("Cannot insert values due to wrong status value");
		    			}
		    	 
		            }
		        
		           
		            break;
		    case "delete":
		      {
		        	
		      }
		        
		    default:
		    {	
		    	System.out.println("wrong Choice");
		    	break;
		}
		    
		   
		}
			
		}
}	    	 
		
