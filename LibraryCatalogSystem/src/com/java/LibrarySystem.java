package com.java;

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static LibraryCatalog catalog = new LibraryCatalog();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List All Books");
            System.out.println("5. Exit\n");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchByTitle();
                    break;
                case 3:
                    searchByAuthor();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exit..");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        catalog.addBook(title, author);
        System.out.println("Book added successfully.");
    }

    private static void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> results = catalog.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("Book not found with title.");
        } else {
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private static void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        List<Book> results = catalog.searchByAuthor(author);
        if (results.isEmpty()) {
            System.out.println("Book not found with author.");
        } else {
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private static void listBooks() {
        System.out.println("List of books:\n");
        catalog.listBooks();
    }
}

