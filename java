import java.util.*;
class Book {
    private String title, author, isbn;
    private int year;
    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Book-no: " + isbn + " | Year: " + year);
    }
}
class LibraryManagementSystem {
    private ArrayList<Book> books;
    private Scanner scanner;
    public LibraryManagementSystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addBook() {
        System.out.print("\nEnter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book-no: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Publication Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        books.add(new Book(title, author, isbn, year));
        System.out.println("yo your book added");
    }
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("\n*** No books in the library ***");
            return;
        }
        System.out.println("\n========== LIBRARY BOOKS ==========");
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i + 1) + ". ");
            books.get(i).display();
        }
        System.out.println("==================================");
    }
    public void removeBook() {
        if (books.isEmpty()) {
            System.out.println("\n*** No books to remove ***");
            return;
        }
        showAllBooks();
        System.out.print("\nEnter book number to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index > 0 && index <= books.size()) {
            String removed = books.remove(index - 1).getTitle();
            System.out.println("✓ Book '" + removed + "' removed successfully!");
        } else {
            System.out.println("nuh uh it wrong!");
        }
    }
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\n---- Library Management System ----");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addBook(); break;
                case 2: showAllBooks(); break;
                case 3: removeBook(); break;
                case 4: 
                    System.out.println("come back soon or goodluck dealing with duolingo bird");
                    running = false;
                    break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
public class lms {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.menu();
    }
}

