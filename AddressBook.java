package addressbooksystems;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    // HashMap to store multiple Address Books
    private static HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    // Defining an array for contacts with a fixed size
    private Contacts[] contactsArray;
    private int contactCount;

    // Constructor to initialize the array
    public AddressBook() {
        contactsArray = new Contacts[100]; // Example: array can hold up to 100 contacts
        contactCount = 0;
    }

    // Welcome message
    public static void welcomeMsg() {
        System.out.println("Welcome to the Address Book System!");
    }

    // Method to handle the menu and switch case logic
    public void manageAddressBook(Scanner sc) {
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new Address Book");
            System.out.println("2. Add a new contact to an Address Book");
            System.out.println("3. Edit a contact in the Address Book");
            System.out.println("4. Delete a contact from an Address Book");
            System.out.println("5. Display all contacts in an Address Book");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    // Add a new Address Book
                    addNewAddressBook(sc);
                    break;

                case 2:
                    // Add a new contact to an Address Book
                    System.out.println("Enter the name of the Address Book:");
                    String bookName = sc.nextLine();
                    AddressBook book = addressBookMap.get(bookName);
                    if (book != null) {
                        book.addNewContact(sc);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 3:
                    // Edit an existing contact
                    System.out.println("Enter the name of the Address Book:");
                    String bookNameToEdit = sc.nextLine();
                    AddressBook bookToEdit = addressBookMap.get(bookNameToEdit);
                    if (bookToEdit != null) {
                        System.out.println("Enter the first or last name of the contact you want to edit:");
                        String nameToEdit = sc.nextLine();
                        bookToEdit.editContact(nameToEdit, sc);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 4:
                    // Delete a contact from the Address Book
                    System.out.println("Enter the name of the Address Book:");
                    String bookNameToDelete = sc.nextLine();
                    AddressBook bookToDelete = addressBookMap.get(bookNameToDelete);
                    if (bookToDelete != null) {
                        System.out.println("Enter the first or last name of the contact you want to delete:");
                        String nameToDelete = sc.nextLine();
                        bookToDelete.deleteContact(nameToDelete, sc);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 5:
                    // Display all contacts in an Address Book
                    System.out.println("Enter the name of the Address Book:");
                    String bookNameToDisplay = sc.nextLine();
                    AddressBook bookToDisplay = addressBookMap.get(bookNameToDisplay);
                    if (bookToDisplay != null) {
                        bookToDisplay.displayAllContacts();
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 6:
                    // Exit the program
                    continueProgram = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Method to add a new Address Book
    private static void addNewAddressBook(Scanner sc) {
        System.out.println("Enter a unique name for the new Address Book:");
        String bookName = sc.nextLine();

        if (addressBookMap.containsKey(bookName)) {
            System.out.println("An Address Book with this name already exists.");
        } else {
            AddressBook newAddressBook = new AddressBook();
            addressBookMap.put(bookName, newAddressBook);
            System.out.println("New Address Book '" + bookName + "' added successfully.");
        }
    }

    // Method to add a new contact
    private void addNewContact(Scanner sc) {
        if (contactCount < contactsArray.length) {
            System.out.println("Enter first name:");
            String firstName = sc.nextLine();

            System.out.println("Enter last name:");
            String lastName = sc.nextLine();

            System.out.println("Enter Address:");
            String address = sc.nextLine();

            System.out.println("Enter city:");
            String city = sc.nextLine();

            System.out.println("Enter state:");
            String state = sc.nextLine();

            System.out.println("Enter pincode:");
            int zip = sc.nextInt();

            System.out.println("Enter mobile number:");
            long phoneNumber = sc.nextLong();

            System.out.println("Enter Email ID:");
            sc.nextLine(); // consume the newline
            String email = sc.nextLine();

            // Create a new Contacts object and add it to the AddressBook
            Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
            contactsArray[contactCount] = contact;
            contactCount++;

            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Address Book is full. Cannot add more contacts.");
        }
    }

    // Method to edit an existing contact
    private void editContact(String nameToEdit, Scanner sc) {
        boolean contactFound = false;

        for (int i = 0; i < contactCount; i++) {
            Contacts contact = contactsArray[i];
            if (contact.getFirstName().equalsIgnoreCase(nameToEdit) || contact.getLastName().equalsIgnoreCase(nameToEdit)) {
                System.out.println("Editing contact: " + contact);

                System.out.println("Enter new first name (or press Enter to keep the same):");
                String newFirstName = sc.nextLine();
                if (!newFirstName.isEmpty()) {
                    contact.setFirstName(newFirstName);
                }

                System.out.println("Enter new last name (or press Enter to keep the same):");
                String newLastName = sc.nextLine();
                if (!newLastName.isEmpty()) {
                    contact.setLastName(newLastName);
                }

                System.out.println("Enter new address (or press Enter to keep the same):");
                String newAddress = sc.nextLine();
                if (!newAddress.isEmpty()) {
                    contact.setAddress(newAddress);
                }

                System.out.println("Enter new city (or press Enter to keep the same):");
                String newCity = sc.nextLine();
                if (!newCity.isEmpty()) {
                    contact.setCity(newCity);
                }

                System.out.println("Enter new state (or press Enter to keep the same):");
                String newState = sc.nextLine();
                if (!newState.isEmpty()) {
                    contact.setState(newState);
                }

                System.out.println("Enter new pincode (or press Enter to keep the same):");
                String newZip = sc.nextLine();
                if (!newZip.isEmpty()) {
                    contact.setZip(Integer.parseInt(newZip));
                }

                System.out.println("Enter new mobile number (or press Enter to keep the same):");
                String newPhoneNumber = sc.nextLine();
                if (!newPhoneNumber.isEmpty()) {
                    contact.setPhoneNumber(Long.parseLong(newPhoneNumber));
                }

                System.out.println("Enter new email (or press Enter to keep the same):");
                String newEmail = sc.nextLine();
                if (!newEmail.isEmpty()) {
                    contact.setEmail(newEmail);
                }

                System.out.println("Contact updated successfully.");
                contactFound = true;
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }

    // Method to display all contacts
    private void displayAllContacts() {
        if (contactCount == 0) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts in the Address Book:");
            for (int i = 0; i < contactCount; i++) {
                System.out.println(contactsArray[i]);
            }
        }
    }

    // Method to delete a contact
    public void deleteContact(String name, Scanner sc) {
        boolean contactFound = false;

        for (int i = 0; i < contactCount; i++) {
            Contacts contact = contactsArray[i];

            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                contactFound = true;
                System.out.println("Contact found: " + contact);
                System.out.println("Are you sure you want to delete this contact? (yes/no):");
                String confirmation = sc.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    // Shift all elements to the left after deletion
                    for (int j = i; j < contactCount - 1; j++) {
                        contactsArray[j] = contactsArray[j + 1];
                    }

                    contactsArray[contactCount - 1] = null; // Set the last element to null
                    contactCount--; // Decrease the count of contacts
                    System.out.println("Contact deleted successfully!");
                } else {
                    System.out.println("Deletion canceled.");
                }
                return; // Exit after the first match
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }
}