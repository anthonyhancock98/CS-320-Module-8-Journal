/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package AppointmentTests;

import Appointment.AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
    // Test data
    private String id, description, tooLongDescription;
    private Date date, pastDate;

    @BeforeEach
    void setUp() {
        // Set up test data before each test method
        id = "1234567890";
        description = "This is the test description";
        // Deprecated date creation for testing purposes
        date = new Date(3021, Calendar.JANUARY, 1);
        tooLongDescription =
                "This test description is too long for the appointment requirements but good for testing";
        pastDate = new Date(0);
    }

    @Test
    @DisplayName("Test Creating a New Appointment")
    // Running all tests sequentially so that the new appointment
    // follows all requirements
    void testNewAppointment() {
        // Create a new instance of the AppointmentService
        AppointmentService service = new AppointmentService();

        // Test the creation of new appointments
        service.newAppointment();
        // Validate the created appointment
        assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
        assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
        assertNotNull(service.getAppointmentList().get(0).getDescription());

        service.newAppointment(date);
        assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
        assertEquals(date,
                service.getAppointmentList().get(1).getAppointmentDate());
        assertNotNull(service.getAppointmentList().get(1).getDescription());

        service.newAppointment(date, description);
        assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
        assertEquals(date,
                service.getAppointmentList().get(2).getAppointmentDate());
        assertEquals(description,
                service.getAppointmentList().get(2).getDescription());

        // Ensure appointment IDs are unique
        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                service.getAppointmentList().get(1).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                service.getAppointmentList().get(2).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
                service.getAppointmentList().get(2).getAppointmentId());

        // Test for exceptions when creating appointments with invalid data
        assertThrows(IllegalArgumentException.class,
                () -> service.newAppointment(pastDate));
        assertThrows(IllegalArgumentException.class,
                () -> service.newAppointment(date, tooLongDescription));
    }

    @Test
    @Description("Test Deleting Appointment")
    // Running all tests sequentially so that the appointment
    // is properly deleted.
    void deleteAppointment() throws Exception {
        // Create a new instance of the AppointmentService
        AppointmentService service = new AppointmentService();

        // Create and add new appointments
        service.newAppointment();
        service.newAppointment();
        service.newAppointment();

        // Retrieve appointment IDs
        String firstId = service.getAppointmentList().get(0).getAppointmentId();
        String secondId = service.getAppointmentList().get(1).getAppointmentId();
        String thirdId = service.getAppointmentList().get(2).getAppointmentId();

        // Ensure appointment IDs are unique
        assertNotEquals(firstId, secondId);
        assertNotEquals(firstId, thirdId);
        assertNotEquals(secondId, thirdId);
        assertNotEquals(id, firstId);
        assertNotEquals(id, secondId);
        assertNotEquals(id, thirdId);

        // Test deleting appointments and verify the changes
        assertThrows(Exception.class, () -> service.deleteAppointment(id));

        service.deleteAppointment(firstId);
        assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
        assertNotEquals(firstId,
                service.getAppointmentList().get(0).getAppointmentId());
    }
}
