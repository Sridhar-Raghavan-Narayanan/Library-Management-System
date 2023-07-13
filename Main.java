import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        Book book1 = new Book("Java: A Beginner's Guide", "Herbert Schildt");
        Book book2 = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin");
        Book book3 = new Book("The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Search by title");
            System.out.println("2. Search by author");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> searchByTitle(scanner, library);
                case 2 -> searchByAuthor(scanner, library);
                case 3 -> borrowBook(scanner, library);
                case 4 -> returnBook(scanner, library);
                case 5 -> {
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void searchByTitle(Scanner scanner, Library library) {
        System.out.print("Enter the title to search: ");
        String title = scanner.next();

        List<Book> foundBooks = library.searchByTitle(title);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            System.out.println("Books found with the title: " + title);
            for (Book book : foundBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static void searchByAuthor(Scanner scanner, Library library) {
        System.out.print("Enter the author to search: ");
        String author = scanner.next();

        List<Book> foundBooks = library.searchByAuthor(author);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by the author: " + author);
        } else {
            System.out.println("Books found by the author: " + author);
            for (Book book : foundBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static void borrowBook(Scanner scanner, Library library) {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.next();

        List<Book> foundBooks = library.searchByTitle(title);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            for (Book book : foundBooks) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book '" + book.getTitle() + "' borrowed successfully.");
                    return;
                }
            }

            System.out.println("Book '" + title + "' is currently not available for borrowing.");
        }
    }

    private static void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.next();

        List<Book> foundBooks = library.searchByTitle(title);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            for (Book book : foundBooks) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book '" + book.getTitle() + "' returned successfully.");
                    return;
                }
            }

            System.out.println("Book '" + title + "' was not borrowed from this library.");
        }
    }
}