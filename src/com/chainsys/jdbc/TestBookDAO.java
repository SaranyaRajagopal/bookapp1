package com.chainsys.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int choice;
		String date;
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		do
		{
			
			
			System.out.println("enter the numbers given to do the operations");
			System.out.println("1-insert \n 2-update \n 3-delete \n 4-select one record");
		
		 int num = scanner.nextInt();
	       switch (num) {
	       case 1:
	    	   System.out.println("Enter id,name,price to add");
	   		book.id = scanner.nextInt();
	   		book.name = scanner.next();
			book.price = scanner.nextInt();
			
			bookDAO.addBook(book);
			bookDAO.findAll();
			scanner.close();
	    	   break;
	       case 2:
	    	   System.out.println("Enter id,name to be updated");
	    	   book.id = scanner.nextInt();
		   		 book.name = scanner.next();
		   		bookDAO.updateBook(book);
				bookDAO.findAll();
	    	   break;
	       case 3:
	    	   System.out.println("Enter id to be deleted");
	    	   book.id = scanner.nextInt();
	    	   bookDAO.deleteBook(book.id);
				bookDAO.findAll();
	    	   break;
	       case 4:
	    	   System.out.println("Enter id of the book to be found");
	    	   book.id = scanner.nextInt();
	    	   
	    	   Book b = bookDAO.findById(book);
	    	   if(b == null)
	    	   {
	    		   System.out.println("no records found");
	    	   }
	    	   else
	    	   {
	    		   System.out.println(b.id);
	    		   System.out.println(b.name);
	    		   System.out.println(b.price);
	    	   }
	    	   break;
	      default:
	    	   break;
	       }System.out.println("press 1 to continue or 0 to exit");
	       choice  = scanner.nextInt();
	}while(choice == 1);
	scanner.close();
	
	}

}
