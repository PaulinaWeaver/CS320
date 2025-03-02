// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import appointment.Appointment;

class AppointmentTest {
	
    // Helper method to get a future date
    private Date getFutureDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    // Helper method to get a past date
    private Date getPastDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }
    
    // Helper method to create a valid Appointment
    private Appointment createValidAppointment() {
        return new Appointment("1234", getFutureDate(1), "This is my new appointment");
    }
	
    // Test valid Appointment creation
    @Test
    void testAppointmentId_ValidInput_AppointmentIdCreatedSuccessfully() {
        Appointment appointment = createValidAppointment();
        assertEquals("1234", appointment.getAppointmentId());
    }
    
    @Test
    void testAppointmentDate_ValidInput_AppointmentDateCreatedSuccessfully() {
        Appointment appointment = createValidAppointment();
        assertEquals(getFutureDate(1), appointment.getAppointmentDate());
    }
    
    @Test
    void testAppointmentDescription_ValidInput_AppointmentDescriptionCreatedSuccessfully() {
        Appointment appointment = createValidAppointment();
        assertEquals("This is my new appointment", appointment.getAppointmentDescription());
    }

    // Test Appointment creation with boundary values
    @Test
    void testAppointmentId_BoundaryValue_SuccessfulAppointmentIdCreation() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(1), "This is my new appointment that is 50 characters .");
        assertEquals("1234567890", appointment.getAppointmentId());
    }

    @Test
    void testAppointmentDescription_BoundaryValue_SuccessfulAppointmentDescriptionCreation() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(1), "This is my new appointment that is 50 characters .");
        assertEquals("This is my new appointment that is 50 characters .", appointment.getAppointmentDescription());
    }

    // Test for appointment ID too long
    @Test
    void testAppointmentIdIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("012345678901", getFutureDate(1), "This is my new appointment");
        });
    }

    // Test for null appointment ID
    @Test
    void testAppointmentIdIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(1), "This is my new appointment");
        });
    }

    // Test for empty appointment ID (only spaces)
    @Test
    void testAppointmentIdIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("          ", getFutureDate(1), "This is my new appointment");
        });
    }

    // Test for null appointment date
    @Test
    void testAppointmentDateIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", null, "This is my new appointment");
        });
    }

    // Test for past appointment date
    @Test
    void testAppointmentDateIsInThePast_ThrowsException() {
        Date pastDate = getPastDate(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", pastDate, "This is my new appointment");
        });
    }

    // Test for empty appointment description (only spaces)
    @Test
    void testAppointmentDescriptionIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", getFutureDate(1), "          ");
        });
    }

    // Test for appointment description too long
    @Test
    void testAppointmentDescriptionIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", getFutureDate(1), "This is my new appointment description that is super duper long");
        });
    }

    // Test for null appointment description
    @Test
    void testAppointmentDescriptionIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", getFutureDate(1), null);
        });
    }

    // --- Testing setters ---

    // Test setting a valid appointment date 
    @Test
    void testSetAppointmentDate_ValidInput_SetterSuccessful() {
        Appointment appointment = createValidAppointment();
        Date newDate = getFutureDate(7);
        appointment.setAppointmentDate(newDate);
        assertEquals(newDate, appointment.getAppointmentDate());
    }

    // Test for setting an appointment date to null
    @Test
    void testSetAppointmentDateIsNull_ThrowsException() {
        Appointment appointment = createValidAppointment();
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(null);
        });
    }

    // Test for setting an appointment date to a date in the past
    @Test
    void testSetAppointmentDateIsInThePast_ThrowsException() {
        Appointment appointment = createValidAppointment();
        Date pastDate = getPastDate(7);
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
    }

    // Test setting a valid appointment description 
    @Test
    void testSetAppointmentDescription_ValidInput_SetterSuccessful() {
        Appointment appointment = createValidAppointment();
        appointment.setAppointmentDescription("Updated description for my appointment");
        assertEquals("Updated description for my appointment", appointment.getAppointmentDescription());
    }

    // Test for setting appointment description too long
    @Test
    void testSetAppointmentDescriptionIsTooLong_ThrowsException() {
        Appointment appointment = createValidAppointment();
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription("This is my new appointment description that is super duper long");
        });
    }

    // Test for setting appointment description to null
    @Test
    void testSetAppointmentDescriptionIsNull_ThrowsException() {
        Appointment appointment = createValidAppointment();
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription(null);
        });
    }

    // Test for setting appointment description to empty string
    @Test
    void testSetAppointmentDescriptionIsEmpty_ThrowsException() {
        Appointment appointment = createValidAppointment();
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription("          ");
        });
    }
}