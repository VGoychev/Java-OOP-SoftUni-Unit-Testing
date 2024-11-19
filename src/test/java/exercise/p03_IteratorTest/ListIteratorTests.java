package exercise.p03_IteratorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator iterator;
    private String[] elements;
    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        elements = new String[]{"Vladimir", "Stoqn", "Kaloqn"};

        iterator = new ListIterator(elements);
    }
    @Test
    public void test_Constructor_WithNoElements_Should_Throw_OperationNotSupportedException() {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            ListIterator listIterator = new ListIterator(null);
        });

    }

    @Test
    public void test_Has_Next_And_Move() {
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(iterator.move());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(iterator.move());
    }
    @Test
    public void test_Has_No_Next() {
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(iterator.move());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(iterator.move());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertFalse(iterator.move());
    }

    @Test
    public void test_Print_Empty_List() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();

        Assertions.assertThrows(IllegalStateException.class, () -> {
           listIterator.print();
        });
    }

    @Test
    public void test_Print_Correct_List(){
        Assertions.assertEquals(elements[0], iterator.print());
    }
}
