package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BookDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAddBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
		book.name = "Junit";
		book.price = 400;
		book.publishedDate = LocalDate.parse("2019-02-15");
		bookDAO.addBook(book);
		
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id, b.id);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
		book.name = "java";
		bookDAO.updateBook(book);
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals("JUnit", b.name);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		
		book.id=1;
		bookDAO.deleteBook(book.id);
		Book b = bookDAO.findById(book);
		assertEquals(null, b);
		
		//fail("Not yet implemented");
	}

	@Ignore
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testFindById() {
		fail("Not yet implemented");
	}

}
