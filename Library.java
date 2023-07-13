import java.util.*;
public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }
}
