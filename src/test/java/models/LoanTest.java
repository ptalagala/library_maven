package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;
import utilities.LoanStatus;

import java.time.LocalDate;

public class LoanTest {

	private Customer customer1 = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
	private Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);


	//G
	@Test
	public void testDueDate() {
		//Customer customer1 = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
		//	Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);

		Loan loan = new Loan(1,customer1,book1);
		LocalDate dueDate = LocalDate.now().plusDays(14);
		assertEquals(dueDate, loan.getDueDate());


	}

	//VG
	@Test
	void newLoanShouldBeCurrent() {
		//Customer customer1 = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
		// Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);

		Loan loan = new Loan(1,customer1,book1);
		LocalDate dueDate = LocalDate.now().plusDays(14);
		assertEquals(LoanStatus.CURRENT, loan.getStatus());


	}
	
	//VG
	@Test
	void endLoanShouldBeHistoric() {
		// Customer customer1 = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
		// Book book1 = new Book(1,"Book 1","Author1","1234567890123","Branch1",300);

		Loan loan = new Loan(1,customer1,book1);
		loan.endLoan();
		assertEquals(LoanStatus.HISTORIC, loan.getStatus());
		
	}	
}