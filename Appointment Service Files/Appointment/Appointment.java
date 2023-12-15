/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package Appointment;

import java.util.Date;

public class Appointment {

    // Constants for character lengths
    final private byte APPOINTMENT_ID_LENGTH;
    final private byte APPOINTMENT_DESCRIPTION_LENGTH;
    final private String INITIALIZER;

    // Instance variables
    private String appointmentId;
    private Date appointmentDate;
    private String description;

    // Initialization block to set constant values
    {
        APPOINTMENT_ID_LENGTH = 10;
        APPOINTMENT_DESCRIPTION_LENGTH = 50;
        INITIALIZER = "INITIAL";
    }

    // Default constructor
    public Appointment() {
        Date today = new Date();
        appointmentId = INITIALIZER;
        appointmentDate = today;
        description = INITIALIZER;
    }

    // Constructor with appointment ID
    public Appointment(String id) {
        Date today = new Date();
        setAppointmentId(id);
        appointmentDate = today;
        description = INITIALIZER;
    }

    // Constructor with appointment ID and date
    public Appointment(String id, Date date) {
        setAppointmentId(id);
        updateDate(date);
        description = INITIALIZER;
    }

    // Full constructor with appointment ID, date, and description
    public Appointment(String id, Date date, String description) {
        setAppointmentId(id);
        updateDate(date);
        updateDescription(description);
    }

    // Method to update appointment ID
    public void setAppointmentId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        } else if (id.length() > APPOINTMENT_ID_LENGTH) {
            throw new IllegalArgumentException("Appointment ID cannot exceed " +
                    APPOINTMENT_ID_LENGTH +
                    " characters.");
        } else {
            this.appointmentId = id;
        }
    }

    // Method to get appointment ID
    public String getAppointmentId() { return appointmentId; }

    // Method to update appointment date
    public void updateDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        } else if (date.before(new Date())) {
            throw new IllegalArgumentException(
                    "Cannot make appointment in the past.");
        } else {
            this.appointmentDate = date;
        }
    }

    // Method to get appointment date
    public Date getAppointmentDate() { return appointmentDate; }

    // Method to update appointment description
    public void updateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(
                    "Appointment description cannot be null.");
        } else if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(
                    "Appointment description cannot exceed " +
                            APPOINTMENT_DESCRIPTION_LENGTH + " characters.");
        } else {
            this.description = description;
        }
    }

    // Method to get appointment description
    public String getDescription() { return description; }
}
