package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.Contact;
import static org.junit.jupiter.api.Assertions.*;

// above are the imports needed for JUnit 5 testing and assertions

public class ContactTest {
    private Contact contact;

    // set up each test with a valid contact with beforeEach setup method
    @BeforeEach
    void setUp() {
        contact = new Contact("1", "Danielle", "Williams", "5558671022", "307 B Ave");
    }

// Test all getters and setters, including boundary tests for invalid inputs
    @Test
    void testGetters() {
        assertEquals("1", contact.getId());
        assertEquals("Danielle", contact.getFirstName());
        assertEquals("Williams", contact.getLastName());
        assertEquals("5558671022", contact.getPhone());
        assertEquals("307 B Ave", contact.getAddress());
    }

    // tests for firstName, lastName, phone, and address setters with valid and invalid inputs
    // all using the assertThrows method to check for exceptions on invalid inputs
    // and assertEquals to check for correct values on valid inputs
    @Test
    void testSetFirstNameValid() {
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void testSetFirstNameInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertEquals("First name cannot be null and must be no longer than 10 characters.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsWayTooLong");
        });
        assertEquals("First name cannot be null and must be no longer than 10 characters.", exception.getMessage());
    }

    @Test
    void testSetLastNameValid() {
        contact.setLastName("Doe");
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    void testSetLastNameInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertEquals("Last name cannot be null and must be no longer than 10 characters.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisNameIsWayTooLong");
        });
        assertEquals("Last name cannot be null and must be no longer than 10 characters.", exception.getMessage());
    }

    @Test
    void testSetPhoneValid() {
        contact.setPhone("1234567890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    void testSetPhoneInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.",
            exception.getMessage());
    }

}
