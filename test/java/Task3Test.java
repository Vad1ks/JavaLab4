import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    HashMap<Integer,Task3.Book> setup;
    @BeforeEach
    void setUp() {
        setup = new HashMap<>();
        setup.put(1, new Task3.Book("AAA", "Author1", "Publisher1",2010, 200));
        setup.put(2, new Task3.Book("ABC", "Author3", "Publisher3",1970, 250));
        setup.put(3, new Task3.Book("BAC", "Author2", "Publisher2",1995, 130));
        setup.put(4, new Task3.Book("BBC", "Author4", "Publisher4",2007, 280));
    }

    @Test
    void sort_by_surname() {
        ArrayList<Task3.Book> expected = new ArrayList<>();
        expected.add(new Task3.Book("AAA", "Author1", "Publisher1",2010, 200));
        expected.add(new Task3.Book("BAC", "Author2", "Publisher2",1995, 130));
        expected.add(new Task3.Book("ABC", "Author3", "Publisher3",1970, 250));
        expected.add(new Task3.Book("BBC", "Author4", "Publisher4",2007, 280));

        ArrayList<Task3.Book> actual = Task3.sort_by_authorName(setup);
        assertEquals(actual, expected);
    }

    @Test
    void sort_by_publicationYear() {
        ArrayList<Task3.Book> expected = new ArrayList<>();
        expected.add(new Task3.Book("ABC", "Author3", "Publisher3",1970, 250));
        expected.add(new Task3.Book("BAC", "Author2", "Publisher2",1995, 130));
        expected.add(new Task3.Book("BBC", "Author4", "Publisher4",2007, 280));
        expected.add(new Task3.Book("AAA", "Author1", "Publisher1",2010, 200));

        ArrayList<Task3.Book> actual = Task3.sort_by_publicationYear(setup);
        assertEquals(actual, expected);
    }
}
