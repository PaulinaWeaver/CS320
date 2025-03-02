// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import appointment.Appointment;
import appointment.AppointmentService;
import java.util.Calendar;
import java.util.Date;

class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    
    // Helper method to get a future date
    private Date getFutureDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
    
    // Helper method to create a valid appointment for testing
    private Appointment createValidAppointment(String appointmentId, Date futureDate, String description) {
    	return new Appointment(appointmentId, futureDate, description);
    }
    
    // Helper method to get the current size of the contact list
    private int getCurrentSizeOfAppointmentList() {
        return appointmentService.getAppointments().size();
    }

    
    // Clear any existing appointments before each test
    @BeforeEach
    void init() {
        appointmentService = AppointmentService.getInstance();
        appointmentService.getAppointments().clear();
    }
    
    @Test
    void testAddNewAppointment_AppointmentAddedSuccessfully() {
        // Create a new appointment with ID "1234"
        Appointment appointment = createValidAppointment("1234", getFutureDate(1), "This is my new appointment");
    
        // Save the initial size of the appointment list
        int initialSize = getCurrentSizeOfAppointmentList();
        
        // Add the appointment to the service
        boolean isAdded = appointmentService.add(appointment);
    
        // Assert that the appointment was added successfully
        assertTrue(isAdded);
        
        // Verify the appointment exists in the appointments map
        assertNotNull(appointmentService.getAppointments().get("1234"));
        assertEquals(appointment, appointmentService.getAppointments().get("1234"));
        
        // Verify the size of the appointment list increased by 1
        assertEquals(initialSize + 1, getCurrentSizeOfAppointmentList());
    }
    
    @Test
    void testAddDuplicateAppointment_AppointmentNotAddedAgain() {
        // Add the appointment for the first time
        Appointment appointment = createValidAppointment("1234", getFutureDate(1), "This is my new appointment");
        appointmentService.add(appointment);

        // Save the initial size of the appointment list
        int initialSize = getCurrentSizeOfAppointmentList();

        // Attempt to add the same appointment again
        boolean isAddedAgain = appointmentService.add(appointment);

        // Assert that adding the same appointment returns false (because the appointment already exists)
        assertFalse(isAddedAgain);

        // Verify that the size of the list has not changed
        assertEquals(initialSize, getCurrentSizeOfAppointmentList());

        // Verify that the original appointment remains in the list
        assertEquals(appointment, appointmentService.getAppointments().get("1234"));
    }
    
    @Test
    void testSuccessfulAppointmentDeletion_AppointmentRemovedFromList() {
        // Create a new appointment with ID "1234"
        Appointment appointment = createValidAppointment("1234", getFutureDate(1), "This is my new appointment");

        // Add the appointment to the service
        appointmentService.add(appointment);
        
        // Save the initial size of the appointment list
        int initialSize = getCurrentSizeOfAppointmentList();
        
        // Delete the appointment by its appointmentId
        boolean isDeleted = appointmentService.delete("1234");
        
        // Assert that the appointment was deleted successfully
        assertTrue(isDeleted);
        
        // Verify the appointment no longer exists in the appointments map
        assertNull(appointmentService.getAppointments().get("1234"));

        // Verify that the list size decreased by 1
        assertEquals(initialSize - 1, getCurrentSizeOfAppointmentList());
    }
    
    @Test
    void testDeleteNonExistentAppointment_NoAppointmentsDeleted() {
        // Add a valid appointment with ID "1234"
        Appointment appointment = createValidAppointment("1234", getFutureDate(1), "This is my new appointment");
        appointmentService.add(appointment);

        // Save the initial size of the appointment list
        int initialSize = getCurrentSizeOfAppointmentList();

        // Try to delete a non-existent appointment (appointment with ID "5678")
        boolean result = appointmentService.delete("5678");

        // Assert that the delete operation failed (it should return false)
        assertFalse(result);

        // Verify that the number of appointments hasn't changed
        assertEquals(initialSize, getCurrentSizeOfAppointmentList());

        // Verify that the original appointment still exists in the appointments map
        assertTrue(appointmentService.getAppointments().containsKey("1234"));
    }
}
