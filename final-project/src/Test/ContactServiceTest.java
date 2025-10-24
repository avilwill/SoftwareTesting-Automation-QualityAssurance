package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.Contact;
import Main.ContactService;

import static org.junit.jupiter.api.Assertions.*;
// above are the imports needed for JUnit 5 testing and assertions

public class ContactServiceTest {
    // setting the private variables for the service and contact objects
    private ContactService service;
    private Contact contact;

    //using the beforeEach setup method to initialize the service and contact objects before each test
    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("1", "Danielle", "Williams", "555-867-1022", "307 B Ave");
    }


    //Tests below use the assertTrue, assertFalse, assertEquals, assertNull, and assertThrows methods to verify expected outcomes.
    // Test adding a contact successfully
    @Test
    void testAddContactSuccess() {
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("1"));
    }

    // Test adding a contact with a duplicate ID
    @Test
    void testAddContactDuplicateId() {
        service.addContact(contact);
        Contact duplicate = new Contact("1", "John", "Doe", "555-432-8967", "308 B Ave");
        assertFalse(service.addContact(duplicate));
    }

    // Test deleting a contact successfully
    @Test
    void testDeleteContactSuccess() {
        service.addContact(contact);
        assertTrue(service.deleteContact("1"));
        assertNull(service.getContact("1"));
    }

    // Test deleting a contact that does not exist
    @Test
    void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("999"));
    }

    // Test updating a contact successfully
    @Test
    void testUpdateContactSuccess() {
        service.addContact(contact);
        assertTrue(service.updateContact("1", "John", "Smith", "5557758333", "222 Elk Blvd"));
        Contact updated = service.getContact("1");
        assertEquals("John", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("5557758333", updated.getPhone());
        assertEquals("222 Elk Blvd", updated.getAddress());
    }

    // Test updating a contact with partial fields (only first and last name)
    @Test
    void testUpdateContactPartialFields() {
        service.addContact(contact);
        assertTrue(service.updateContact("1", "Kate", "Free", null, null));
        Contact updated = service.getContact("1");
        assertEquals("Kate", updated.getFirstName());
        assertEquals("Free", updated.getLastName());
    }

    // Test updating a contact that does not exist
    @Test
    void testUpdateContactNotFound() {
        assertFalse(service.updateContact("777", "John", "Smith", "5557758333", "222 Elk Blvd"));
    }

    // Test updating a contact with invalid fields (too long first name, invalid phone, too long address)
    @Test
    void testUpdateContactInvalidFields() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", "Supercalafragalisticexpeolidotious", null, null, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", null, null, "123", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", null, null, null, "Address should be less than thirty characters");
        });
    }
}
