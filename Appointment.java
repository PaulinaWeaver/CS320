// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package appointment;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String appointmentDescription;

    public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
        if (appointmentId == null || appointmentId.length() > 10 || appointmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (appointmentDescription == null || appointmentDescription.length() > 50 || appointmentDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    // Setters
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50 || appointmentDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appointmentDescription = appointmentDescription;
    }
}
