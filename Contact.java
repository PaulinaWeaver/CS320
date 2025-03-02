// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package contact;

public class Contact {

	// Instance variables to store contact information
	public String contactId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;
	
	// Constructor to initialize a new Contact object with validation
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address){
		super();
		
		// Validate contactId - must not be null and should not exceed 10 characters
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		// Validate firstName - must not be null, empty, or exceed 10 characters
		if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Validate lastName - must not be null, empty, or exceed 10 characters
		if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Validate phoneNumber - must not be null, must be 10 digits, and only contain digits
		if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Validate address - must not be null, empty, and should not exceed 30 characters
		if (address == null || address.trim().isEmpty() || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// Assign values to the instance variables if all validations pass
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// Getter method for firstName
	public String getFirstName() {
		return firstName;
	}

	// Setter method for firstName with validation
	public void setFirstName(String firstName) {
		// Validate firstName - must not be null, empty, or exceed 10 characters
		if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Set the firstName if validation passes
		this.firstName = firstName;
	}

	// Getter method for lastName
	public String getLastName() {
		return lastName;
	}

	// Setter method for lastName with validation
	public void setLastName(String lastName) {
		// Validate lastName - must not be null, empty, or exceed 10 characters
		if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Set the lastName if validation passes
		this.lastName = lastName;
	}

	// Getter method for phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Setter method for phoneNumber with validation
	public void setPhoneNumber(String phoneNumber) {
		// Validate phoneNumber - must be 10 digits and contain only digits
		if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Set the phoneNumber if validation passes
		this.phoneNumber = phoneNumber;
	}

	// Getter method for address
	public String getAddress() {
		return address;
	}

	// Setter method for address with validation
	public void setAddress(String address) {
		// Validate address - must not be null, empty, or exceed 30 characters
		if (address == null || address.trim().isEmpty() || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		// Set the address if validation passes
		this.address = address;
	}

	// Getter method for contactId
	public String getContactId() {
		return contactId;
	}
}