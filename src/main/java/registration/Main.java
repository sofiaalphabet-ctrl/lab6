
package registration;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final RegistrationManager MANAGER =
            new RegistrationManager();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();

            System.out.print("Choose an option: ");
            String input = SCANNER.nextLine().trim();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a menu number.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    addRegistration();
                    break;

                case 2:
                    MANAGER.displayAll();
                    break;

                case 3:
                    MANAGER.searchById(readInteger("Enter ID: "));
                    break;

                case 4:
                    MANAGER.deleteById(readInteger("Enter ID to delete: "));
                    break;

                case 5:
                    showEvents();
                    MANAGER.displayByEvent(readInteger("Select event: "));
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Unknown menu option. Choose 0-5.");
            }

            System.out.println();
        }

        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println("=== Event Registration ===");
        System.out.println("1. Add registration");
        System.out.println("2. Show all registrations");
        System.out.println("3. Find registration by ID");
        System.out.println("4. Delete registration by ID");
        System.out.println("5. Show registrations for an event");
        System.out.println("0. Exit");
    }

    private static void addRegistration() {
        System.out.print("Full name: ");
        String name = SCANNER.nextLine();

        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        System.out.print("Student group: ");
        String group = SCANNER.nextLine();

        showEvents();

        int event = readInteger("Select event: ");

        MANAGER.addRegistration(name, email, group, event);
    }

    private static void showEvents() {
        String[] events = RegistrationManager.getEvents();

        System.out.println("Available events:");

        for (int i = 0; i < events.length; i++) {
            System.out.println((i + 1) + ". " + events[i]);
        }
    }

    private static int readInteger(String prompt) {
        System.out.print(prompt);

        try {
            return Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter digits.");
            return -1;
        }
    }
}
