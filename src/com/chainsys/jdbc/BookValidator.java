package com.chainsys.jdbc;

public class BookValidator {
	public void validateAdd(Book book) throws Exception{
			if(book.name == null){
				throw new Exception("Invalid name");
				}
			if(book.price<=0){
					throw new Exception ("Invalid price...! Please enter the price more than 0");
	}
	}
			public void validateUpdate(Book book) throws Exception{
				if(book.id <= 0){
					throw new Exception("Invalid id");
					}
				if(book.price<=0){
						throw new Exception ("Invalid price...! Please enter the price more than 0");
		}
			if(book.name == null){
				throw new Exception("Invalid name");
			}

}
}
