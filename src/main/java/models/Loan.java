package models;


//import java.util.Date;
//import java.util.GregorianCalendar;

import java.time.LocalDate;
import utilities.LoanStatus;

public class Loan {

private int ID;
private Customer customer;
private Book book;
//private Date startDate;
private LocalDate dueDate;
//private Date returnDate;
private LoanStatus status;
	
public Loan(int iD, Customer customer, Book book) {
  super();
  ID = iD;
  this.customer = customer;
  this.book = book;  
  dueDate = LocalDate.now().plusDays(14);
  status = LoanStatus.CURRENT;
}

@Override
public String toString() {
  return "Loan [ID=" + ID + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle()
    + "]";
}

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ID;
  return result;
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  Loan other = (Loan) obj;
  if (ID != other.ID)
    return false;
  return true;
}

public Customer getCustomer() {
  return customer;
}

public Book getBook() {
  return book;
}

public LocalDate getDueDate() {
  return dueDate;
}
	
public LoanStatus getStatus() {
  return status;
}

public void endLoan() {
  //returnDate = new Date();
  status = LoanStatus.HISTORIC;
}
	
}
