/*
 * Anthony Hancock
 * CS-320
 * Prof. Kraya
 * 12/7/2023
 */

package Contact;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    // Variable Declarations
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Using AtomicLong for generating a value
    private static AtomicLong idGenerator = new AtomicLong();

    // Set to store used contact IDs
    private static Set<String> usedIds = ConcurrentHashMap.newKeySet();

    // Constructor with four parameters (removed address parameter as it wasn't used in the constructor)
    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        // Generate a new ID until a unique one is found
        do {
            this.contactID = String.valueOf(idGenerator.getAndIncrement());
        } while (!usedIds.add(this.contactID));

        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    // GETTERS
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // SETTERS
    public void setFirstName(String firstName) {
        // If the first name is null or empty, then assign "null" to it
        if (firstName == null || firstName.isEmpty()) {
            this.firstName = "null";
        }
        // If first name is longer than 10 characters, just grab the first 10 characters
        else if (firstName.length() > 10) {
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // If the last name is null or empty, then assign "null" to it
        if (lastName == null || lastName.isEmpty()) {
            this.lastName = "null";
        }
        // If last name is longer than 10 characters, just grab the first 10 characters
        else if (lastName.length() > 10) {
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        // if the phone number is null, empty, or doesn't have a length of 10 characters
        // then a default value is assigned
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10) {
            this.phoneNumber = "5555555555";
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setAddress(String address) {
        // if the address is null or empty, then assign "null"
        if (address == null || address.isEmpty()) {
            this.address = "null";
        }
        // if the address is greater than 30 characters, grab the first 30 characters
        else if (address.length() > 30) {
            this.address = address.substring(0, 30);
        } else {
            this.address = address;
        }
    }
}
