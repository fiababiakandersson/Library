package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilities.GenderType;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book book = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);
		bc.addBook(book);
		assertEquals(2, bc.getNumberOfBooks());
	}

	//G
	@Test
	public void testFindBook()  {
		Book book = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);
		bc.addBook(book);
        try {
            assertEquals(book, bc.findBook("Book Title"));
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

	//G
	@Test
	public void testFindBookIgnoringCase() {
		Book book = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);
		bc.addBook(book);
        try {
            assertEquals(book, bc.findBook("book title"));
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
		Book book = new Book(123,
				"Book Title",
				"Book Author",
				"978-0-306-40615-7",
				"Book Branch",
				333);
		bc.addBook(book);
		try {
			assertEquals(book, bc.findBook("  book title  "));
		} catch (BookNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		assertThrows(BookNotFoundException.class, () ->  bc.findBook("No Title"));
	}

}
