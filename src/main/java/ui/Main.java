package ui;
import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import models.Customer;
import models.Loan;
import models.LoanAlreadyExistsException;
import utilities.GenderType;

public class Main {

	public static void main(String[] args) {

		BookCatalog bookCatalog = new BookCatalog();

		Book book1 = new Book(1,"An introduction to Java","Matt Greencroft","12345","Anytown Branch", 400);
		Book book2 = new Book(2,"Better Java","Joe Le Blanc","23456","Anytown Branch",150);

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);


		try {
			Book foundBook = bookCatalog.findBook("Better");
			System.out.println("We found " + foundBook.getTitle());
		}
		catch (BookNotFoundException e) {
			System.out.println("The book wasn't found");
		}

		int myTest = 1;

		try {
			if (myTest != 2) {
				throw new RuntimeException("Something went wrong");
			}
		}
		catch (RuntimeException e) {
			// do nothing here so that we can continue;
		}

		Customer customer = new Customer("Mr", "Michael", "Smith", "1 The High Street","1234","a@b.com",1,GenderType.MALE);
		System.out.println(customer.getExpiryDate());
		System.out.println(customer.getMailingName());

		System.out.println(customer);

		System.out.println(customer.equals(customer));

		Loan firstLoan = new Loan(1,customer,book1);
		System.out.println(firstLoan.getDueDate());
		System.out.println(firstLoan);
		
	}

}
