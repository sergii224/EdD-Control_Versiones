// Library.java
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private boolean isIsbnUnique(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return false;
        }
        return true;
    }

    public void addBook(Book book) {
       if (isIsbnUnique(book.getIsbn())){
        books.add(book);
       }
    }    

    public Book findBookByTitle(String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        // BUG 6: ConcurrentModificationException potencial
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    public void removeBook(String isbn){
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }
}

