package addressbooksystems;

import java.util.Scanner;

public class AddressBookTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook.welcomeMsg();
        
        // Creating an instance of AddressBook 
        
        AddressBook addressBook = new AddressBook();
        
        // Calling method to manage AddressBook operations
        addressBook.manageAddressBook(sc);

        sc.close(); // Closing the scanner
    }
}