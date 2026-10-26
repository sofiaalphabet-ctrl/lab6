
package registration;

import java.util.ArrayList;

public class RegistrationManager {
    private final ArrayList<Registration> registrations =
            new ArrayList<>();

    private int nextId = 1;

    private static final String[] EVENTS = {
            "Web Design Workshop",
            "JavaScript Quiz",
            "IT Career Talk"
    };

    public static String[] getEvents() {
        return EVENTS.clone();
    }

    public boolean addRegistration(String fullName, String email,
                                   String studentGroup, int eventChoice) {
        String name = fullName == null ? "" : fullName.trim();
        String address = email == null ? "" : email.trim();
        String group = studentGroup == null ? "" : studentGroup.trim();

        if (name.length() < 3) {
            System.out.println("Invalid full name: enter at least 3 characters.");
            return false;
        }

        int at = address.indexOf('@');

        if (at <= 0 || at != address.lastIndexOf('@')
                || at == address.length() - 1) {
            System.out.println("Invalid email: include @ with text before and after it.");
            return false;
        }

        if (group.isBlank()) {
            System.out.println("Invalid student group: it cannot be blank.");
            return false;
        }

        if (eventChoice < 1 || eventChoice > EVENTS.length) {
            System.out.println("Invalid event choice. Select a number from 1 to 3.");
            return false;
        }

        Registration registration = new Registration(
                nextId++, name, address, group, EVENTS[eventChoice - 1]
        );

        registrations.add(registration);
        System.out.println("Registration created. ID: " + registration.getId());
        return true;
    }

    public void displayAll() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }

        for (Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    public Registration findById(int id) {
        for (Registration registration : registrations) {
            if (registration.getId() == id) {
                return registration;
            }
        }

        return null;
    }

    public void searchById(int id) {
        Registration found = findById(id);

        if (found == null) {
            System.out.println("Registration not found.");
        } else {
            System.out.println(found);
        }
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < registrations.size(); i++) {
            if (registrations.get(i).getId() == id) {
                registrations.remove(i);
                System.out.println("Registration deleted.");
                return true;
            }
        }

        System.out.println("Registration not found. Nothing was deleted.");
        return false;
    }

    public void displayByEvent(int eventChoice) {
        if (eventChoice < 1 || eventChoice > EVENTS.length) {
            System.out.println("Invalid event choice. Select a number from 1 to 3.");
            return;
        }

        boolean found = false;

        for (Registration registration : registrations) {
            if (registration.getEventTitle().equals(EVENTS[eventChoice - 1])) {
                System.out.println(registration);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No registrations for this event.");
        }
    }
}
