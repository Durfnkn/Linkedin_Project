package com.Librarian;

import java.time.LocalDate;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available = true;
    private LocalDate borrowedDate;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate date) { this.borrowedDate = date; }

    public void displayInfo() {
        String borrowedOn = borrowedDate != null ? borrowedDate.toString() : "-";
        String dueDate = borrowedDate != null ? borrowedDate.plusDays(7).toString() : "-";
        System.out.printf("%-5d %-25s %-20s %-10s %-12s %-12s\n",
                bookId, title, author, available ? "Yes" : "No", borrowedOn, dueDate);
    }
}

