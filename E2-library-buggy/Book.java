// Book.java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }
    
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return available; }

    public void borrow() {
        
        if (available) {
            available = false;
        } else {
            System.out.println("Error: Ya está prestado.");
        }
    }
    
    public void returnBook() {

        if (!available) {
            available = true;
        } else {
            System.out.println("Error: No estaba prestado");
        }
    }
}
