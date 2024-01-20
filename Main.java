package internship;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnBook() {
        isCheckedOut = false;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public void checkOutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.checkOut();
            System.out.println("Book '" + book.getTitle() + "' checked out successfully.");
        } else {
            System.out.println("Book '" + book.getTitle() + "' is already checked out.");
        }
    }

    public void returnBook(Book book) {
        if (book.isCheckedOut()) {
            book.returnBook();
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not checked out.");
        }
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> searchResult = library.searchByAuthor("Harper Lee");
        System.out.println("Books by Harper Lee: " + searchResult);

        library.checkOutBook(book1);
        library.checkOutBook(book1); // Trying to check out the same book again

        library.returnBook(book1);
        library.returnBook(book1); // Trying to return the same book again
    }
}