package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(123,
		"Book Title",
		"Book Author",
		"978-0-306-40615-7",
		"Book Branch",
		333);

		Book book2 = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);

		assertEquals(book1, book2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(321,
				"Title",
				"Author",
				"7-40615-306-0-978",
				"Branch",
				333);

		Book book2 = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);
		assertNotEquals(book1, book2);
	}
}
