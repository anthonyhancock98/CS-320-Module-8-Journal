/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package AppointmentTests;

import Appointment.Appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {

    // Test data
    private String id, description;
    private String tooLongId, tooLongDescription;
    private Date date, pastDate;

    // Set up test data before each test method
    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        id = "1234567890";
        description = "This is the test description";
        // Deprecated date creation for testing purposes
        date = new Date(3021, Calendar.JANUARY, 1);
        tooLongId = "123456789012345678901234567890";
        tooLongDescription =
                "This test description is too long for the appointment requirements but good for testing";
        pastDate = new Date(0);
    }

    // Test updating appointment ID
    @Test
    @Description("Test Updating AppointmentID")
    void testUpdateAppointmentId() {
        Appointment appt = new Appointment();
        // Test invalid updates
        assertThrows(IllegalArgumentException.class,
                () -> appt.setAppointmentId(null));
        assertThrows(IllegalArgumentException.class,
                () -> appt.setAppointmentId(tooLongId));
        // Test valid update
        appt.setAppointmentId(id);
        assertEquals(id, appt.getAppointmentId());
    }

    // Test getting appointment ID
    @Test
    @Description("Test Getting AppointmentID")
    void testGetAppointmentId() {
        Appointment appointment = new Appointment(id);
        // Validate getting appointment ID
        assertNotNull(appointment.getAppointmentId());
        assertEquals(appointment.getAppointmentId().length(), 10);
        assertEquals(id, appointment.getAppointmentId());
    }

    // Test updating appointment date
    @Test
    @Description("Test Updating Appointment Date")
    void testUpdateDate() {
        Appointment appointment = new Appointment();
        // Test invalid updates
        assertThrows(IllegalArgumentException.class, () -> appointment.updateDate(null));
        assertThrows(IllegalArgumentException.class,
                () -> appointment.updateDate(pastDate));
        // Test valid update
        appointment.updateDate(date);
        assertEquals(date, appointment.getAppointmentDate());
    }

    // Test getting appointment date after its been updated
    @Test
    @Description("Test Getting Appointment Date")
    void testGetAppointmentDate() {
        Appointment appt = new Appointment(id, date);
        // Validate getting appointment date
        assertNotNull(appt.getAppointmentDate());
        assertEquals(date, appt.getAppointmentDate());
    }

    // Test updating appointment description
    @Test
    @Description("Test Updating Appointment Description")
    void testUpdateDescription() {
        Appointment appt = new Appointment();
        // Test invalid updates
        assertThrows(IllegalArgumentException.class,
                () -> appt.updateDescription(null));
        assertThrows(IllegalArgumentException.class,
                () -> appt.updateDescription(tooLongDescription));
        // Test valid update
        appt.updateDescription(description);
        assertEquals(description, appt.getDescription());
    }

    // Test getting appointment description after its been updated
    @Test
    @Description("Test Getting Appointment Description")
    void testGetDescription() {
        Appointment appt = new Appointment(id, date, description);
        // Validate getting appointment description
        assertNotNull(appt.getDescription());
        assertTrue(appt.getDescription().length() <= 50);
        assertEquals(description, appt.getDescription());
    }
}
