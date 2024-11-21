package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {

	//VG
	@Test
	public void testDueDate() {
		LocalDate expectedDueDate = LocalDate.now().plusDays(14);

		int ID = 123;
		Customer customer = new Customer("", "","","","", "", 123, GenderType.UNKNOWN );
		Book book = new Book(ID, "", "", "","", 123);
		Loan loan = new Loan(ID, customer, book);

		assertEquals(expectedDueDate, loan.getDueDate());
   }
}