package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviesDAO {
	public void addBook(int id, String name, int price) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into Movies(name,id,price) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = null;
		System.out.println("Enter the name:");
		preparedStatement.setString(1, name);
		System.out.println("Enter the id:");
		preparedStatement.setInt(2, id);

		System.out.println("Enter the Price:");
		preparedStatement.setInt(3, price);
		int rows1 = preparedStatement.executeUpdate();
		System.out.println("Rows inserted: " + rows1);
        ConnectionUtil.close(connection, preparedStatement, resultSet);
	}
	public void updateBook(int id, String name) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql2 = "update Movies set name = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);
		ResultSet resultSet = null;
		System.out.println("Enter the name to be updated:");
		preparedStatement.setString(1, name);
		System.out.println("Enter the id:");
		preparedStatement.setInt(2, id);
		int rows2 = preparedStatement.executeUpdate();
		System.out.println("Rows updated: " + rows2);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public void deleteBook(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql3 = "delete from Movies where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql3);
		ResultSet resultSet = null;
		System.out.println("Enter the id to be deleted:");
		preparedStatement.setInt(1, id);
		int rows3 = preparedStatement.executeUpdate();
		System.out.println("Rows deleted: " + rows3);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public void findAll() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql5 = "select id,price,name from Movies";
		PreparedStatement preparedStatement = connection.prepareStatement(sql5);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			 System.out.println(resultSet.getInt("id")+ " \t  " + resultSet.getString("name")+ " \t " + resultSet.getInt("price"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);

	}

	public void findById(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql4 = "select id from Movies where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql4);
		System.out.println("Enter the id:");
		preparedStatement.setInt(1, id);
		int rows4 = preparedStatement.executeUpdate();
		System.out.println("Rows selected: " + rows4);
		ResultSet resultSet = preparedStatement.executeQuery();
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}
}


