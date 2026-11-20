package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);
		Book book2 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);

		assertEquals(book1, book2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);
		Book book2 = new Book(2,"Book 2","Author2","1234567890124","Branch1",310);

		assertNotEquals(book1, book2);
	}

	//G
	@Test
	void booksWithSameIdAndTitleShouldBeEqual() {
		Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);
		Book book2 = new Book(1,"Book 1","Author1","1234567890123","Branch3",300);

		assertEquals(book1, book2);

	}

	//G
	@Test
	void booksWithDifferentIdsShouldNotBeEqual() {
		Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);
		Book book2 = new Book(2,"Book 1","Author2","1234567890124","Branch3",310);

		assertNotEquals(book1, book2);

	}


	//G
	@Test
	void booksWithSameIdButDifferentTitlesShouldNotBeEqual() {
		Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);
		Book book2 = new Book(1,"Book 2","Author2","1234567890124","Branch3",300);

		assertNotEquals(book1, book2);


	}
}
