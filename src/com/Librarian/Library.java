package com.Librarian;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();

    public void addBook(Book book) { books.add(book); System.out.println("🎉 Book added: " + book.getTitle()); }
    public void removeBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null) { books.remove(book); System.out.println("❌ Book removed: " + book.getTitle()); }
        else System.out.println("❌ Book not found!");
    }

    public void addStudent(Student student) { students.add(student); System.out.println("🎉 Student registered: " + student.getName()); }
    public void addLibrarian(Librarian librarian) { librarians.add(librarian); System.out.println("🎉 Librarian added: " + librarian.getName()); }

    public Book findBook(int bookId) { for (Book b : books) if (b.getBookId() == bookId) return b; return null; }
    public Student findStudent(int studentId) { for (Student s : students) if (s.getId() == studentId) return s; return null; }

    public void issueBook(int studentId, int bookId) {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);
        if (student != null && book != null && book.isAvailable()) {
            student.borrowBook(book);
            book.setAvailable(false);
            System.out.println("✅ Book issued: " + book.getTitle() + " to " + student.getName());
        } else System.out.println("❌ Cannot issue book!");
    }

    public void returnBook(int studentId, int bookId) {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);
        if (student != null && book != null && !book.isAvailable()) {
            student.returnBook(book);
            book.setAvailable(true);
            System.out.println("✅ Book returned: " + book.getTitle() + " by " + student.getName());
        } else System.out.println("❌ Cannot return book!");
    }

    public void showBooks() {
        System.out.printf("\n%-5s %-25s %-20s %-10s %-12s %-12s\n",
                "ID", "Title", "Author", "Available", "Borrowed On", "Due Date");
        System.out.println("----------------------------------------------------------------------------------");
        for (Book b : books) b.displayInfo();
    }

    public void showStudents() { for (Student s : students) s.displayInfo(); }
    public void showLibrarians() { for (Librarian l : librarians) l.displayInfo(); }
}

