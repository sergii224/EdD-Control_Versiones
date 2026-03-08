import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
    public void testAddDuplicateBook() {

        Library lib = new Library();
        Book b1 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book b2 = new Book("Clean Code", "Robert Martin", "978-0132350884");

        lib.addBook(b1);
        lib.addBook(b2);

        System.out.println("Libros en biblioteca: " + lib.findAvailableBooks().size());
    }
}