/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package Appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

    // List to store appointments
    final private List<Appointment> appointmentList = new ArrayList<>();

    // Generate a new unique ID using UUID
    private String newUniqueId() {
        // Generating a unique ID using UUID and taking the first 10 characters
        return UUID.randomUUID().toString().substring(
                0, Math.min(toString().length(), 10));
    }

    // Method to create a new appointment with a unique ID
    public void newAppointment() {
        Appointment appointment = new Appointment(newUniqueId());
        appointmentList.add(appointment);
    }

    // Method to create a new appointment with a unique ID and specified date
    public void newAppointment(Date date) {
        Appointment appointment = new Appointment(newUniqueId(), date);
        appointmentList.add(appointment);
    }

    // Method to create a new appointment with a unique ID, date, and description
    public void newAppointment(Date date, String description) {
        Appointment appointment = new Appointment(newUniqueId(), date, description);
        appointmentList.add(appointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String id) throws Exception {
        appointmentList.remove(searchForAppointment(id));
    }

    // Method to get the appointment list
    public List<Appointment> getAppointmentList() { return appointmentList; }

    // Helper method to search for an appointment by ID
    private Appointment searchForAppointment(String id) throws Exception {
        int index = 0;
        // Iterate through the appointment list to find the appointment with the specified ID
        while (index < appointmentList.size()) {
            if (id.equals(appointmentList.get(index).getAppointmentId())) {
                return appointmentList.get(index);
            }
            index++;
        }
        // Throw an exception if the appointment is not found
        throw new Exception("The appointment does not exist!");
    }
}
