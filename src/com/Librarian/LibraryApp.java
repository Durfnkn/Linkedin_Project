package com.Librarian;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addLibrarian(new Librarian(1, "Alice"));
        library.addLibrarian(new Librarian(2, "Bob"));
        library.addStudent(new Student(101, "Saurabh Pal"));
        library.addStudent(new Student(102, "Masume"));
        library.addBook(new Book(201, "Java OOP", "James Gosling"));
        library.addBook(new Book(202, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(203, "Head First Java", "Kathy Sierra"));

        int choice;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Show All Students");
            System.out.println("3. Show All Librarians");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Add Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> library.showBooks();
                case 2 -> library.showStudents();
                case 3 -> library.showLibrarians();
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    library.issueBook(sid, bid);
                }
                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    library.returnBook(sid, bid);
                }
                case 6 -> {
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                }
                case 7 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int bid = sc.nextInt();
                    library.removeBook(bid);
                }
                case 8 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 8);

        sc.close();
    }
}

