package Main;

import java.util.HashMap;
import java.util.Map;
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();
//add contacts with a unique ID.
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            return false; // ID must be unique
        }
        contacts.put(contact.getId(), contact);
        return true;
    }

//delete contacts per contact ID.
    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

//update contact fields per contact ID.
    public boolean updateContact(String contactId, String firstName, String lastName, String number, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (number != null) contact.setPhone(number);
        if (address != null) contact.setAddress(address);
        return true;
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}


