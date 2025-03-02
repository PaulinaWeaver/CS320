// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import contact.Contact;

public class ContactService {
    private static ContactService instance; // Singleton instance
    Map<String, Contact> contacts; // Store contacts

    // Private constructor to prevent instantiation and initialize the contacts map
    private ContactService() {
        contacts = new ConcurrentHashMap<>();
    }

    // Public method to get the single instance
    public static ContactService getInstance() {
        if (instance == null) {
            instance = new ContactService();
        }
        return instance;
    }

    // Add a contact
    public boolean add(Contact contact) {
    	return contacts.putIfAbsent(contact.getContactId(), contact) == null;
    }

    // Delete a contact
    public boolean delete(String contactId) {
    	return contacts.remove(contactId) != null;
    }
	
    //Update a contact
    public boolean update(String contactId, Contact updated) {
        Contact existing = contacts.get(contactId);

        if (existing != null) {
            // The setters will handle validation, throwing IllegalArgumentException if invalid
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setPhoneNumber(updated.getPhoneNumber());
            existing.setAddress(updated.getAddress());
            return true;
        }
        return false; // Contact not found
    }
    
    // Getter for contacts map (used for testing)
    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
