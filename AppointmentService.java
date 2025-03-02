// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package appointment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppointmentService {
    private static AppointmentService instance; // Singleton instance
    private Map<String, Appointment> appointments; // Store appointments

    // Private constructor to prevent instantiation and initialize the appointments map
    private AppointmentService() {
        appointments = new ConcurrentHashMap<>();
    }

    // Public method to get the single instance
    public static AppointmentService getInstance() {
        if (instance == null) {
            instance = new AppointmentService();
        }
        return instance;
    }

    // Add an appointment
    public boolean add(Appointment appointment) {
        // Add if appointment ID is not already taken
        return appointments.putIfAbsent(appointment.getAppointmentId(), appointment) == null;
    }   

    // Delete an appointment by ID
    public boolean delete(String appointmentId) {
        return appointments.remove(appointmentId) != null;
    }

    // Getter for appointments map (used for testing)
    public Map<String, Appointment> getAppointments() {
        return appointments;
    }
}