// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
    
	private ContactService contactService;
	
	@BeforeEach
	void init() {
	    contactService = ContactService.getInstance();
	    // Clear any existing contacts before each test
	    contactService.getContacts().clear();
	}
	
	// Helper method to create a valid contact
    private Contact createValidContact(String contactId) {
        return new Contact(contactId, "Paulina", "Weaver", "6462845409", "2665 Price Blvd");
    }
    
    // Helper method to get the current size of the contact list
    private int getCurrentSizeOfContactList() {
        return contactService.getContacts().size();
    }

    @Test
    void testAddNewContact_ContactAddedSuccessfully() {
        Contact contact = createValidContact("123");
        
        int initialSize = getCurrentSizeOfContactList(); // Get initial contact list size
        
        // Add the new contact
        boolean isAdded = contactService.add(contact);
        
        // Assert that the contact was added successfully
        assertTrue(isAdded, "Contact should be added successfully.");
        
        // Verify that the contact exists in the contacts map
        assertNotNull(contactService.getContacts().get("123"), "Contact should exist in the map.");
        assertEquals(contact, contactService.getContacts().get("123"), "Retrieved contact should match the added one.");
        
        // Verify that the size of the contacts list increased by 1
        assertEquals(initialSize + 1, getCurrentSizeOfContactList(), "Contact list size should increase by 1.");
    }
	

    @Test
    void testAddingDuplicateContact_ContactNotAddedAgain() {
        Contact contact = createValidContact("123");

        // Add the contact for the first time and verify it was added
        boolean isAddedFirstTime = contactService.add(contact);
        assertTrue(isAddedFirstTime, "First addition should succeed.");
        
        int sizeAfterFirstAdd = getCurrentSizeOfContactList();

        // Attempt to add the same contact again
        boolean isAddedAgain = contactService.add(contact);

        // Assert that adding the same contact returns false
        assertFalse(isAddedAgain, "Adding an existing contact should return false.");

        // Verify that the contact remains unchanged
        assertEquals(contact, contactService.getContacts().get("123"), "The contact data should remain unchanged.");

        // Verify that the size of the list did not increase
        assertEquals(sizeAfterFirstAdd, getCurrentSizeOfContactList(), "Contact list size should remain the same after attempting to add a duplicate.");
    }
	
    @Test
    void testSuccessfulContactDeletion_ContactSuccessfullyRemovedFromList() {
        // Create a new contact
        Contact contact = createValidContact("123");

        // Add the contact to the service
        contactService.add(contact);
        
        // Capture initial size after adding
        int initialSize = getCurrentSizeOfContactList();

        // Delete the contact by its contactId
        boolean isDeleted = contactService.delete("123");

        // Assert that the contact was deleted successfully
        assertTrue(isDeleted, "Deleting an existing contact should return true.");

        // Verify the contact no longer exists in the contacts map
        assertNull(contactService.getContacts().get("123"), "Deleted contact should not exist in the contacts list.");

        // Verify that the size of the list decreased by 1
        assertEquals(initialSize - 1, getCurrentSizeOfContactList(), "Contact list size should decrease by 1 after deletion.");
    }
	
    @Test
    void testDeleteNonExistentContact_NoContactsDeleted() {
        // Add a valid contact
        Contact contact = createValidContact("123");
        contactService.add(contact);

        int initialSize = getCurrentSizeOfContactList(); // Get the initial size of the contact list

        // Try to delete a non-existent contact (contact with ID "999")
        boolean result = contactService.delete("999");

        // Assert that the delete operation failed (it should return false)
        assertFalse(result, "Deleting a non-existent contact should return false.");

        // Verify that the contact list size remains unchanged
        assertEquals(initialSize, getCurrentSizeOfContactList(), "Contact list size should remain the same after attempting to delete a non-existent contact.");

        // Verify that the original contact still exists
        assertTrue(contactService.getContacts().containsKey("123"), "The original contact should still exist in the contact list.");
    }
	
    @Test
    void testUpdateContact_ValidInput_ContactUpdatedSuccessfully() {
        // Create a new contact
        Contact contact = createValidContact("123");
        
        // Add the contact to the service
        contactService.add(contact);

        int initialSize = getCurrentSizeOfContactList(); // Get the initial size of the contact list
        
        // Create an updated contact with new values
        Contact updatedContact = new Contact("123", "Emma", "Marino", "0123456789", "1234 Another Address");

        // Update the contact
        boolean isUpdated = contactService.update("123", updatedContact);

        // Assert that the contact was updated successfully
        assertTrue(isUpdated, "Contact should be updated successfully.");

        // Verify that the contact's details were updated
        assertEquals("Emma", contactService.getContacts().get("123").getFirstName());
        assertEquals("Marino", contactService.getContacts().get("123").getLastName());
        assertEquals("0123456789", contactService.getContacts().get("123").getPhoneNumber());
        assertEquals("1234 Another Address", contactService.getContacts().get("123").getAddress());

        // Verify that the size of the contact list remains the same after the update
        assertEquals(initialSize, getCurrentSizeOfContactList(), "Contact list size should remain the same after updating a contact.");
    }
	
	@Test
	void testContactUpdate_InvalidData_UpdateNotSuccessful() {
	    // Add a valid contact
        Contact contact = createValidContact("123");	    
        contactService.add(contact);

	    // Create a new contact object for updating with valid data initially
	    Contact updatedContact = new Contact("123", "Emma", "Marino", "6462845410", "2665 Another Blvd");

	    // Try to update the contact with invalid data (empty first name)
	    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	        updatedContact.setFirstName(""); // Set invalid first name
	        contactService.update("123", updatedContact); // This should throw an exception due to invalid first name
	    });
	    // Verify the exception message
	    assertEquals("Invalid first name", exception.getMessage());
	    
	    // Try to update the contact with an invalid last name (empty last name)
	    IllegalArgumentException exceptionLastName = assertThrows(IllegalArgumentException.class, () -> {
	        updatedContact.setLastName(""); // Set invalid last name
	        contactService.update("123", updatedContact); // This should throw an exception due to invalid last name
	    });
	    assertEquals("Invalid last name", exceptionLastName.getMessage());
	    
	    // Try to update the contact with an invalid phone number (empty phone number)
	    IllegalArgumentException exceptionPhoneNumber = assertThrows(IllegalArgumentException.class, () -> {
	        updatedContact.setPhoneNumber(""); // Set invalid phone number
	        contactService.update("123", updatedContact); // This should throw an exception due to invalid phone number
	    });
	    assertEquals("Invalid phone number", exceptionPhoneNumber.getMessage());
	    
	    // Try to update the contact with an invalid address (empty address)
	    IllegalArgumentException exceptionAddress = assertThrows(IllegalArgumentException.class, () -> {
	        updatedContact.setAddress(""); // Set invalid address
	        contactService.update("123", updatedContact); // This should throw an exception due to invalid address
	    });
	    assertEquals("Invalid address", exceptionAddress.getMessage());

	    // Verify that the contact's data remains unchanged 
	    Contact storedContact = contactService.getContacts().get("123");
	    assertNotNull(storedContact);
	    assertEquals("Paulina", storedContact.getFirstName());
	    assertEquals("Weaver", storedContact.getLastName());
	    assertEquals("6462845409", storedContact.getPhoneNumber());
	    assertEquals("2665 Price Blvd", storedContact.getAddress());
	}
	
	@Test
	void testUpdateContact_ContactNotFound_ReturnFalse() {
	    // Try to update a contact with a non-existent ID ("999")
	    Contact updated = new Contact("999", "Noname", "Noname", "0000000000", "No Address");

	    // Ensure that the contact with ID "999" does not exist (we haven't added it)
	    assertNull(contactService.getContacts().get("999"), "Contact with ID 999 should not exist.");

	    // Try to update a contact with a non-existent ID
	    boolean isUpdated = contactService.update("999", updated);

	    // Assert that the update operation failed (returns false)
	    assertFalse(isUpdated, "Updating a non-existent contact should return false.");

	    // Verify that the contact list has not been altered (no new contact added)
	    assertNull(contactService.getContacts().get("999"), "Contact with ID 999 should still not exist after the update attempt.");
	}
}