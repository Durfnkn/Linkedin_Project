package com.Librarian;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Book> borrowedBooks = new ArrayList<>();

    public Student(int id, String name) { super(id, name); }

    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrowedDate(LocalDate.now());
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        if (book.getBorrowedDate() != null) {
            long days = ChronoUnit.DAYS.between(book.getBorrowedDate(), LocalDate.now());
            if (days > 7) {
                long fine = (days - 7) * 10;
                System.out.println("⚠️ Late return! Fine: ₹" + fine);
            }
        }
        book.setBorrowedDate(null);
    }

    @Override
    public void displayInfo() {
        System.out.printf("\nStudent ID: %-5d Name: %-20s Borrowed Books: %-3d\n",
                getId(), getName(), borrowedBooks.size());
        if (!borrowedBooks.isEmpty()) {
            System.out.printf("%-25s %-12s %-12s %-6s\n", "Book Title", "Borrowed On", "Due Date", "Fine");
            System.out.println("--------------------------------------------------------");
            for (Book b : borrowedBooks) {
                long fine = 0;
                if (b.getBorrowedDate() != null) {
                    long days = ChronoUnit.DAYS.between(b.getBorrowedDate(), java.time.LocalDate.now());
                    if (days > 7) fine = (days - 7) * 10;
                }
                System.out.printf("%-25s %-12s %-12s %-6s\n",
                        b.getTitle(),
                        b.getBorrowedDate(),
                        b.getBorrowedDate().plusDays(7),
                        fine > 0 ? "₹" + fine : "-");
            }
        }
    }
}

