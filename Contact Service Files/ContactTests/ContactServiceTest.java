/*
 * Anthony Hancock
 * CS-320
 * Prof. Kraya
 * 12/7/2023
 */

package ContactTests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Contact.ContactService;
import Contact.Contact;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactServiceTest {

    private ContactService service; // Declare service at the class level

    @BeforeEach
    public void setUp() {
        service = new ContactService(); // Initialize a new service before each test
    }

    @Test
    @DisplayName("Update First Name")
    @Order(1)
    void testUpdateFirstName() {
        // Arrange
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Act
        service.updateFirstName("Sven", "0");

        // Assert
        assertEquals("Sven", service.getContact("0").getFirstName(), "Test Failed: First name was not updated.");
    }

    @Test
    @DisplayName("Update Last Name")
    @Order(2)
    void testUpdateLastName() {
        // Arrange
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Act
        service.updateLastName("Shirley", "2");

        // Assert
        assertEquals("Shirley", service.getContact("2").getLastName(), "Test Failed: Last name was not updated.");
    }

    @Test
    @DisplayName("Update Phone Number")
    @Order(3)
    void testUpdatePhoneNumber() {
        // Arrange
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Act
        service.updatePhoneNumber("5555550000", "4");

        // Assert
        assertEquals("5555550000", service.getContact("4").getPhoneNumber(), "Test Failed: Phone number was not updated.");
    }

    @Test
    @DisplayName("Update Address")
    @Order(4)
    void testUpdateAddress() {
        // Arrange
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Act
        service.updateAddress("555 Nowhere Ave", "6");

        // Assert
        assertEquals("555 Nowhere Ave", service.getContact("6").getAddress(), "Test Failed: Address was not updated.");
    }

    @Test
    @DisplayName("Delete Contact")
    @Order(5)
    void testDeleteContact() {
        // Arrange
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Act
        service.deleteContact("8");

        // Assert
        ArrayList<Contact> contactListEmpty = new ArrayList<>();
        assertEquals(contactListEmpty, service.contactList, "Test Failed: The contact was not deleted.");
    }

    @Test
    @DisplayName("Add Contact")
    @Order(6)
    void testAddContact() {
        // Act
        service.addContact("John", "Doe", "5551234567", "123 Main St");

        // Assert
        assertNotNull(service.getContact("10"), "Test Failed: Contact was not added correctly.");
    }
}
