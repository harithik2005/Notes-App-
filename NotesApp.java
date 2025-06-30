// NotesApp.java - Simple Java Notes App using FileReader/FileWriter
// Made by Harithik Sharma during Java Internship @ Elevate Labs

import java.io.*;
import java.util.*;

public class NotesApp {
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\n### Welcome to My Notes App ###");

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    static void addNote(Scanner sc) {
        try {
            System.out.print("\nEnter your note: ");
            String note = sc.nextLine();

            FileWriter writer = new FileWriter(FILE_NAME, true); // append mode
            writer.write(note + System.lineSeparator());
            writer.close();

            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    static void viewNotes() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No notes found yet.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}
