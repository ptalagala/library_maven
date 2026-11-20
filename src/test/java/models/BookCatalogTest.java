package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        Book book2 = new Book(2, "Learning C#", "", "", "", 0);
        bc.addBook(book2);
        assertEquals(book2, bc.getBookArray()[1]);
    }

    //G
    @Test
    public void testFindBook() throws BookNotFoundException {
        assertEquals(book1, bc.findBook("Learning Java"));
    }

    //G
    @Test
    public void testFindBookIgnoringCase() throws BookNotFoundException {
        assertEquals(book1, bc.findBook("learning java"));
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() throws BookNotFoundException {
        assertEquals(book1, bc.findBook("  learning java  "));
    }

    //G
    @Test
    public void shouldThrowExceptionWhenCatalogIsEmpty() throws BookNotFoundException {
        try {
            BookCatalog bc2 = new BookCatalog();
            bc2.findBook("Learning Java Advanced");
            fail("Expected Catalog is empty");
        } catch (BookNotFoundException e) {
            System.out.println("BookNotFoundException thrown");
        }
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        try {
            bc.findBook("Handbok för Superhältar");
            fail("Expected BookNotFoundException exception");
        } catch (BookNotFoundException e) {
            System.out.println("BookNotFoundException thrown");
        }
    }

    //VG
    //Skriv ett parameteriserat test som verifierar att metoden findBook(String title)
    // hittar samma bok oavsett hur titeln skrivs med stora och små bokstäver.
    //Du kan testa med
    // "Learning Java"
    //"learning java"
    //"LEARNING JAVA"

    @ParameterizedTest
    @ValueSource(strings = {"Learning Java", "learning java", "LEARNING JAVA"})
    public void shouldFindBookRegardlessOfCase(String title) throws BookNotFoundException {
        bc.findBook(title);
    }

}
