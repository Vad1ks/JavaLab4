import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    TreeMap<Integer,Task1.Abonent> setup;
    @BeforeEach
    void setUp() {
        setup = new TreeMap<Integer, Task1.Abonent>();
        setup.put(1, new Task1.Abonent("Sosnovenko", "Vadym", "Volodymyrovych", "Kyiv"));
        setup.put(2,new Task1.Abonent("Ivanov", "Ivan", "Ivanovych","Kharkiv"));
        setup.put(3,new Task1.Abonent("Diia", "Nadia", "Andriivna", "Kyiv"));
        setup.put(4,new Task1.Abonent("Petrov","Anton","Antonych", "Lviv"));
    }

    @Test
    void sort_by_name() {
        ArrayList<Task1.Abonent> expected = new ArrayList<>();
        expected.add(new Task1.Abonent("Petrov","Anton","Antonych", "Lviv"));
        expected.add(new Task1.Abonent("Ivanov", "Ivan", "Ivanovych","Kharkiv"));
        expected.add(new Task1.Abonent("Diia", "Nadia", "Andriivna", "Kyiv"));
        expected.add(new Task1.Abonent("Sosnovenko", "Vadym", "Volodymyrovych", "Kyiv"));

        ArrayList<Task1.Abonent> actual = Task1.sort_by_name(setup);
        assertEquals(actual, expected);
    }

    @Test
    void sort_by_surname() {
        ArrayList<Task1.Abonent> expected = new ArrayList<>();
        expected.add(new Task1.Abonent("Diia", "Nadia", "Andriivna", "Kyiv"));
        expected.add(new Task1.Abonent("Ivanov", "Ivan", "Ivanovych","Kharkiv"));
        expected.add(new Task1.Abonent("Petrov","Anton","Antonych", "Lviv"));
        expected.add(new Task1.Abonent("Sosnovenko", "Vadym", "Volodymyrovych", "Kyiv"));

        ArrayList<Task1.Abonent> actual = Task1.sort_by_surname(setup);
        assertEquals(actual, expected);
    }
}