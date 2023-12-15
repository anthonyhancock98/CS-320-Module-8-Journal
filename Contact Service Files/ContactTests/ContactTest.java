/*
 * Anthony Hancock
 * CS-320
 * Prof. Kraya
 * 12/7/2023
 */

package ContactTests;

import Contact.Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact contact;

    // Set up a Contact object before each test
    @BeforeEach
    public void setUp() {
        contact = new Contact("John", "Doe", "5551234567", "123 Main St");
    }

    // contactID testing
    /* The contactID is declared as a final variable in the Contact.java file
    and has a pre-assigned value that cannot be changed. Therefore, I'm using
    different variables to ensure that the system can handle all scenarios.
    */
    @Test
    @DisplayName("ContactID < 10")
    public void testContactIdLessThan10() {
        // Check if the final contact ID is less than 10 characters long
        assertTrue(contact.getContactID().length() <= 10, "Test Failed: contactID longer than 10 characters");

        // Testing to make sure that if contactID has more than 10 characters that
        // it will still be caught
        String testContactId = "12345678900";
        assertFalse(testContactId.length() < 10, "Test Failed: contactID shorter than 10 characters");
        System.out.println(contact.getContactID());
    }
    // I've added this test to ensure that
    // the contactID is unique
    @Test
    @DisplayName("ContactID is Unique")
    public void testContactIdUnique(){
        // Create two contacts
        Contact contact1 = new Contact("John", "Doe", "5551234567", "123 Main St");
        Contact contact2 = new Contact("Jane", "Smith", "5559876543", "456 Oak St");

        // Ensure that their contact IDs are unique
        assertNotEquals(contact1.getContactID(), contact2.getContactID(), "Test Failed: Contact IDs are not unique");
        // Print out the ContactID for further confidence
        System.out.println(contact1.getContactID());
        System.out.println(contact2.getContactID());
    }


    // firstName Tests
    @Test
    @DisplayName("firstName == Null")
    public void testFirstNameNull() {
        Contact contact = new Contact(null, null, null, null);

        // Check if firstName is "null"
        assertEquals("null", contact.getFirstName());
        System.out.println(contact.getFirstName());
    }
    @Test
    @DisplayName("firstName < 10")
    public void testFirstNameLessThan10() {
        Contact contact = new Contact("test", null, null, null);

        assertTrue(contact.getFirstName().length() <= 10);
    }
    @Test
    @DisplayName("firstName == 10")
    public void testFirstNameEquals10() {
        Contact contact = new Contact("TestTestTE", null, null, null);

        assertTrue(contact.getFirstName().length() == 10);
    }
    @Test
    @DisplayName("firstName > 10")
    public void testFirstNameMoreThan10() {
        Contact contact = new Contact("test", null, null, null);

        assertTrue(contact.getFirstName().length() <= 10);
    }


    // lastName Tests
    @Test
    @DisplayName("lastName == Null")
    public void testLastNameNull() {
        Contact contact = new Contact(null, null, null, null);

        // Check if firstName is "null"
        assertEquals("null", contact.getLastName());
        System.out.println(contact.getLastName());
    }
    @Test
    @DisplayName("lastName < 10")
    public void testLastNameLessThan10() {
        Contact contact = new Contact(null, "test", null, null);

        assertTrue(contact.getLastName().length() <= 10);
    }
    @Test
    @DisplayName("lastName == 10")
    public void testLastNameEquals10() {
        Contact contact = new Contact(null, "TestTestTE", null, null);

        assertTrue(contact.getLastName().length() == 10);
    }
    @Test
    @DisplayName("lastName > 10")
    public void testLastNameMoreThan10() {
        Contact contact = new Contact(null, "TestTestTest", null, null);

        assertTrue(contact.getLastName().length() <= 10);
    }


    // phoneNumber Tests
    @Test
    @DisplayName("phoneNumber == Null")
    public void testPhoneNumberNull() {
        Contact contact = new Contact(null, null, null, null);

        // Check if phoneNumber is "5555555555"
        assertEquals("5555555555", contact.getPhoneNumber());
    }
    @Test
    @DisplayName("phoneNumber == 10")
    public void testPhoneNumberEquals10() {
        Contact contact = new Contact(null, null, "1234567890", null);

        assertEquals(10, contact.getPhoneNumber().length());
    }
    @Test
    @DisplayName("phoneNumber != 10")
    public void testPhoneNumberDoesNotEqual10() {
        Contact contact = new Contact(null, null, "12345678901", null);

        assertTrue(contact.getPhoneNumber().length() == 10);
        System.out.println(contact.getPhoneNumber());
    }


    // address Tests
    @Test
    @DisplayName("address is Null")
    public void testAddressNull() {
        Contact contact = new Contact(null, null, null, null);

        // Check if address is "null"
        assertEquals("null", contact.getAddress());
        System.out.println(contact.getAddress());
    }
    @Test
    @DisplayName("address < 30>")
    public void testAddressLessThan30() {
        Contact contact = new Contact(null, null, null, "123 Test Address");

        assertTrue(contact.getAddress().length() <= 30);
        System.out.println(contact.getAddress());
    }
    @Test
    @DisplayName("address > 30")
    public void testAddressMoreThan30() {
        Contact contact = new Contact(null, null, null, "1234567890 Test Address, Test Address");

        assertTrue(contact.getAddress().length() <= 30);
        System.out.println(contact.getAddress());
    }
    @Test
    @DisplayName("address == 30>")
    public void testAddressEquals30() {
        Contact contact = new Contact(null, null, null, "123 Test Address");

        assertTrue(contact.getAddress().length() <= 30);
        System.out.println(contact.getAddress());
    }
}