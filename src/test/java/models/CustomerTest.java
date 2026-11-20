package models;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    //G
    @Test
    void testGetGender() {
        Customer customerTest = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
        assertEquals(GenderType.MALE, customerTest.getGender());
    }

    //G
    @Test
    void testGetMailingName() {
        Customer customerTest = new Customer("Mr", "John", "Johansson", "First Street", "0701234567", "john@email.com", 10, GenderType.MALE);
        assertEquals("Mr J Johansson", customerTest.getMailingName());
    }

}
