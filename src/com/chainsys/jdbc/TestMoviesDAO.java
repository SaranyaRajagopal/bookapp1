package com.chainsys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMoviesDAO {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do
		{
			MoviesDAO moviesDAO = new MoviesDAO();
			
			System.out.println("enter the numbers given to do the operations");
			System.out.println("1-insert \n 2-update \n 3-delete \n 4-select one record");
		
		 int num = scanner.nextInt();
	       switch (num) {
	       case 1:
	    	   System.out.println("Enter id,name,price to add");
	   		int id = scanner.nextInt();
	   		String name = scanner.next();
			int price = scanner.nextInt();
			
			moviesDAO.addBook(id,name,price);
			moviesDAO.findAll();
			scanner.close();
	    	   break;
	       case 2:
	    	   System.out.println("Enter id,name to be updated");
	    	   id = scanner.nextInt();
		   		 name = scanner.next();
		   		moviesDAO.updateBook(id,name);
				moviesDAO.findAll();
	    	   break;
	       case 3:
	    	   System.out.println("Enter id to be deleted");
	    	   id = scanner.nextInt();
	    	   moviesDAO.deleteBook(id);
				moviesDAO.findAll();
	    	   break;
	       case 4:
	    	   System.out.println("Enter id of the Movie to be found");
	    	   id = scanner.nextInt();
	    	   moviesDAO.findById(id);
	    	   break;
	      default:
	    	   break;
	       }System.out.println("press 1 to continue or 0 to exit");
	       choice  = scanner.nextInt();
	}while(choice == 1);
	scanner.close();
	
	}



	}


