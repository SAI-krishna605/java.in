import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Contact {
    String name;
    String email;
    String[] phoneNumbers;

    public Contact(String name, String email, String[] phoneNumbers) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
          .append(", Email: ").append(email)
          .append(", Phones: ");
        for (int i = 0; i < phoneNumbers.length; i++) {
            sb.append(phoneNumbers[i]);
            if (i < phoneNumbers.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}

class RecentCall {
    String contactName;
    String phoneNumber;
    long timestamp;

    public RecentCall(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return contactName + " - " + phoneNumber + " at " + new java.util.Date(timestamp);
    }
}

public class MINITEAM {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static LinkedList<RecentCall> recentCalls = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Contact Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Make a Call");
            System.out.println("5. View Recent Calls");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> makeCall();
                case 5 -> viewRecentCalls();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 6);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("Invalid email format");
            return;
        }

        System.out.print("How many phone numbers: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        String[] phones = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter phone " + (i + 1) + ": ");
            phones[i] = scanner.nextLine();
        }

        contacts.add(new Contact(name, email, phones));
        System.out.println("Contact added successfully");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String key = scanner.nextLine();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(key)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Contact not found");
    }

    private static void makeCall() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println("Select phone number:");
                for (int i = 0; i < c.phoneNumbers.length; i++) {
                    System.out.println((i + 1) + ". " + c.phoneNumbers[i]);
                }
                int opt = scanner.nextInt();
                scanner.nextLine();

                if (opt > 0 && opt <= c.phoneNumbers.length) {
                    recentCalls.addFirst(new RecentCall(c.name, c.phoneNumbers[opt - 1]));
                    if (recentCalls.size() > 5) recentCalls.removeLast();
                    System.out.println("Calling " + c.phoneNumbers[opt - 1]);
                    return;
                }
            }
        }
        System.out.println("Contact not found");
    }

    private static void viewRecentCalls() {
        if (recentCalls.isEmpty()) {
            System.out.println("No recent calls");
            return;
        }
        for (RecentCall r : recentCalls) {
            System.out.println(r);
        }
    }
}
