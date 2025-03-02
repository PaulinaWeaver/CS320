// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	
	// Helper method to create a valid Contact
	private Contact createValidContact() {
	    return new Contact("0123456789", "Paulina", "Weaver", "9419935149", "123 Price Blvd");
	}

    // Test valid Contact creation
	@Test
	void testContactId_ValidInput_ContactIdCreatedSuccessfully() {
	    Contact contact = createValidContact();
	    assertEquals("0123456789", contact.getContactId()); // Check contact ID
	}

	@Test
	void testContactFirstName_ValidInput_ContactFirstNameCreatedSuccessfully() {
	    Contact contact = createValidContact();
	    assertEquals("Paulina", contact.getFirstName()); // Check first name
	}

	@Test
	void testContactLastName_ValidInput_ContactLastNameCreatedSuccessfully() {
	    Contact contact = createValidContact();
	    assertEquals("Weaver", contact.getLastName()); // Check last name
	}

	@Test
	void testContactPhoneNumber_ValidInput_ContactPhoneNumberCreatedSuccessfully() {
	    Contact contact = createValidContact();
	    assertEquals("9419935149", contact.getPhoneNumber()); // Check phone number
	}

	@Test
	void testContactAddress_ValidInput_ContactAddressCreatedSuccessfully() {
	    Contact contact = createValidContact();
	    assertEquals("123 Price Blvd", contact.getAddress()); // Check address
	}
	
	// Test valid Contact creation with boundary values
	@Test
	void testContactId_BoundaryValue_SuccessfulContactIdCreation() {
	    Contact contact = new Contact("0123456789", "Paulina123", "Weaver1234", "9419935149", "123 Price Blvd1234567890123456");
	    assertEquals("0123456789", contact.getContactId()); // Check contact ID
	}

	@Test
	void testContactFirstName_BoundaryValue_SuccessfulContactFirstNameCreation() {
	    Contact contact = new Contact("0123456789", "Paulina123", "Weaver1234", "9419935149", "123 Price Blvd1234567890123456");
	    assertEquals("Paulina123", contact.getFirstName()); // Check first name
	}

	@Test
	void testContactLastName_BoundaryValue_SuccessfulContactLastNameCreation() {
	    Contact contact = new Contact("0123456789", "Paulina123", "Weaver1234", "9419935149", "123 Price Blvd1234567890123456");
	    assertEquals("Weaver1234", contact.getLastName()); // Check last name
	}

	@Test
	void testContactPhoneNumber_BoundaryValue_SuccessfulContactPhoneNumberCreation() {
	    Contact contact = new Contact("0123456789", "Paulina123", "Weaver1234", "9419935149", "123 Price Blvd1234567890123456");
	    assertEquals("9419935149", contact.getPhoneNumber()); // Check phone number
	}

	@Test
	void testContactAddress_BoundaryValue_SuccessfulContactAddressCreation() {
	    Contact contact = new Contact("0123456789", "Paulina123", "Weaver1234", "9419935149", "123 Price Blvd1234567890123456");
	    assertEquals("123 Price Blvd1234567890123456", contact.getAddress()); // Check address
	}
    
    // Test for invalid contact ID length (too long)
    @Test
    void testContactIdTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("012345678999", "Paulina", "Weaver", "9419935149", "123 Price Blvd");
        });
    }

    // Test for null contact ID
    @Test
    void testContactIdIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Paulina", "Weaver", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for first name too long
    @Test
    void testFirstNameIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "PaulinaAAAA", "Weaver", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for null first name
    @Test
    void testFirstNameIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", null, "Weaver", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for empty first name (only spaces)
    @Test
    void testFirstNameIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "  ", "Weaver", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for last name too long
    @Test
    void testLastNameIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "WeaverRRRRRRR", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for null last name
    @Test
    void testLastNameIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", null, "9419935149", "123 Price Blvd");
        });    
    }

    // Test for empty last name (only spaces)
    @Test
    void testLastNameIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "   ", "9419935149", "123 Price Blvd");
        });    
    }

    // Test for phone number too long
    @Test
    void testPhoneNumberIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "9419935149999", "123 Price Blvd");
        });    
    }

    // Test for phone number too short
    @Test
    void testPhoneNumberIsTooShort_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "94199", "123 Price Blvd");
        });    
    }

    // Test for null phone number
    @Test
    void testPhoneNumberIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", null, "123 Price Blvd");
        });    
    }

    // Test for phone number containing letters
    @Test
    void testPhoneNumberWithLetters_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "ABC9935149", "123 Price Blvd");
        });    
    }

    // Test for address too long
    @Test
    void testAddressIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "9419935149", "123 Price Blvd QWERTYUIOPASDFGHJ");
        });    
    }

    // Test for null address
    @Test
    void testAddressIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "9419935149", null);
        });    
    }

    // Test for empty address (only spaces)
    @Test
    void testAddressIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Paulina", "Weaver", "9419935149", "    ");
        });    
    }
    
    // --- Testing setters ---

    // Test setting a valid first name
    @Test
    void testSetFirstName_ValidInput_SetterSuccessful() {
	    Contact contact = createValidContact();
        contact.setFirstName("Brady");
        assertEquals("Brady", contact.getFirstName());    
    }

    // Test setting a too long first name
    @Test
    void testSetFirstNameIsTooLong_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("BradyYYYYYY");
        });
    }

    // Test setting a null first name
    @Test
    void testSetFirstNameIsNull_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Test setting an empty first name (only spaces)
    @Test
    void testSetFirstNameIsSpace_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("   ");
        });
    }

    // Test setting a valid last name
    @Test
    void testSetLastName_ValidInput_SetterSuccessful() {
	    Contact contact = createValidContact();
        contact.setLastName("Miller");
        assertEquals("Miller", contact.getLastName());    
    }

    // Test setting a too long last name
    @Test
    void testSetLastNameIsTooLong_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("MillerRRRRR");
        });
    }

    // Test setting a null last name
    @Test
    void testSetLastNameIsNull_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Test setting an empty last name (only spaces)
    @Test
    void testSetLastNameIsSpace_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("   ");
        });
    }

    // Test setting a valid phone number
    @Test
    void testSetPhoneNumber_ValidInput_SetterSuccessful() {
	    Contact contact = createValidContact();
        contact.setPhoneNumber("6462845400");
        assertEquals("6462845400", contact.getPhoneNumber());    
    }

    // Test setting a too long phone number
    @Test
    void testSetPhoneNumberIsTooLong_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("6462845400000");
        });
    }

    // Test setting a too short phone number
    @Test
    void testSetPhoneNumberIsTooShort_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("64628");
        });
    }

    // Test setting a null phone number
    @Test
    void testSetPhoneNumberIsNull_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });
    }

    // Test setting a phone number with letters
    @Test
    void testSetPhoneNumberWithLetters_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("DEF2845400");
        });
    }

    // Test setting a valid address
    @Test
    void testSetAddress_ValidInput_SetterSuccessful() {
	    Contact contact = createValidContact();
        contact.setAddress("456 Maple Street");
        assertEquals("456 Maple Street", contact.getAddress());    
    }

    // Test setting a too long address
    @Test
    void testSetAddressIsTooLong_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("456 Maple Street QWERTYUIOPASDFGHJ");
        });
    }

    // Test setting a null address
    @Test
    void testSetAddressIsNull_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    // Test setting an empty address (only spaces)
    @Test
    void testSetAddressIsSpace_ThrowsException() {
	    Contact contact = createValidContact();
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("    ");
        });
    }
}
