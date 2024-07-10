import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        System.out.println("System closed.");
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nContacts List:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static void updateContact() {
        System.out.print("Enter the contact number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            System.out.print("Enter new name (current: " + contact.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone number (current: " + contact.getPhoneNumber() + "): ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email address (current: " + contact.getEmail() + "): ");
            String email = scanner.nextLine();

            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter the contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }
}
