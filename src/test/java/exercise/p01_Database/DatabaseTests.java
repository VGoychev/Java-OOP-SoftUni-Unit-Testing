package exercise.p01_Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    @Test
    public void test_Constructor_Should_Throw_When_Elements_Greater_Than_16 () {
        Integer[] integers = new Integer[17];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
           Database database =  new Database(integers);
        });
    }

    @Test
    public void test_Constructor_Should_Throw_When_Elements_Are_Less_Than_1 () {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database =  new Database();
        });
    }

    @Test
    public void test_Constructor_With_Correct_Elements () throws OperationNotSupportedException {
        Integer[] expected = {1, 2, 3, 4, 5};
        Database database = new Database(expected);

        Integer[] actual = database.getElements();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenAddingAnElementWhichIs3_thenAddItToTheNextFreeCell () throws OperationNotSupportedException {
        Integer[] integers = {1, 2, 3, 4, 5};
        Database database = new Database(integers);

        database.add(3);
        Assertions.assertEquals(database.getElements()[5], 3);

    }

    @Test
    public void whenAddingAnElementWhichIsNull_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Integer[] integers = {1, 2, 3, 4, 5};
        Database database = new Database(integers);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
           database.add(null);
        });
    }

    @Test
    public void whenRemovingAnElementFromTheDatabase_thenRemoveTheLastElement() throws OperationNotSupportedException {
        Integer[] integers = {1, 2, 3, 4, 5};
        Database database = new Database(integers);
        database.remove();
        Integer[] expected = {1, 2, 3, 4};
        Integer[] actual = database.getElements();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void whenRemovingANullElementFromTheDatabase_thenThrowOperationNotSupportedException() throws OperationNotSupportedException {
        Integer[] integers = new Integer[1];
        Database database = new Database(integers);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
            database.remove();
        });
    }

}
