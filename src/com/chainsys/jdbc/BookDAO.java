package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	/*
	* Pre condition 
	* id,name,price must be valid
	*/
	//Connection connection = null;
	//PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	public void addBook(Book book) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into books(name,id,price) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Enter the name:");
		preparedStatement.setString(1, book.name);
		System.out.println("Enter the id:");
		preparedStatement.setInt(2,book.id);
        System.out.println("Enter the Price:");
		preparedStatement.setInt(3,book.price);
		int rows1 = preparedStatement.executeUpdate();
		System.out.println("Rows inserted: " + rows1);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		BookValidator bookValidator = new BookValidator();
		bookValidator.validateAdd(book);
	}

	public void updateBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql2 = "update books set name = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);
		preparedStatement.setString(1, book.name);
		preparedStatement.setInt(2, book.id);
		int rows2 = preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public void deleteBook(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql3 = "delete from books where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql3);
		System.out.println("Enter the id to be deleted:");
		preparedStatement.setInt(1, id);
		int rows3 = preparedStatement.executeUpdate();
		System.out.println("Rows deleted: " + rows3);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public ArrayList<Book> findAll() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String sql5 = "select id,price,name from books";
	  preparedStatement = connection.prepareStatement(sql5);
       resultSet = preparedStatement.executeQuery();
		ArrayList<Book> list = new ArrayList();
		while (resultSet.next()) {
			Book book = new Book();
			book.id = resultSet.getInt("id");
			book.name = resultSet.getString("name");
			book.price = resultSet.getInt("price");
			list.add(book);
			 System.out.println(resultSet.getInt("id")+ " \t  " + resultSet.getString("name")+ " \t " + resultSet.getInt("price"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;

	}

	public Book findById(Book book) throws Exception {
		 Book b=null;
		Connection connection = ConnectionUtil.getConnection();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		String sql4 = "select id,name,price from books where id=?";
		 preparedStatement = connection.prepareStatement(sql4);
		preparedStatement.setInt(1,book.id);
		 resultSet = preparedStatement.executeQuery();
		
		 if(resultSet.next())
		 {
			 b = new Book();
			 b.id = resultSet.getInt("id");
			 b.name = resultSet.getString("name");
			 b.price= resultSet.getInt("price");
			 ConnectionUtil.close(connection, preparedStatement, resultSet);
		 }
		
		return b;
	}
}

