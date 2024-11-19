package exercise.p02_ExtendedDatabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.naming.OperationNotSupportedException;


public class DatabaseTests {

    @Test
    public void test_ConstructorWhenPersonsAreGreaterThan16() {
        Person[] people = new Person[17];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(people);
        });
    }
    @Test
    public void test_ConstructorWhenPersonsAreLessThan1() {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database();
        });
    }

    @Test
    public void test_Constructor_With_Correct_Person_Array() throws OperationNotSupportedException {
        Person[] expected = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(expected);
        Person[] actual = database.getElements();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenAddingNewPersonToDatabase_thenAddItToLastElement() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        database.add(new Person(8, "Hristo"));

        Person[] expected = database.getElements();
        Assertions.assertArrayEquals(expected, database.getElements());
    }

    @Test
    public void whenAddingNewNullPersonToDatabase_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });

    }

    @Test
    public void whenRemovingPersonFromDatabase_thenRemovesLastPerson() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        database.remove();

        Person[] expected = database.getElements();
        Assertions.assertArrayEquals(expected, database.getElements());
    }

    @Test
    public void whenRemovingPersonFromDatabaseWhereArrayIsOutOfBound_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
            database.remove();
            database.remove();
        });
    }

    @Test
    public void whenFindingPersonById1_thenReturnPersonWithId1() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        Person person = database.findById(1);

        Assertions.assertEquals(person, database.getElements()[1]);
    }

    @Test
    public void whenFindingPersonById1WhenThereAreMoreThan1WithThisId_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Person[] elements = {new Person(1, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findById(1);
        });
    }

    @Test
    public void whenFindingPersonByNameVladimir_thenReturnPersonWithNameVladimir() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);

        Person person = database.findByUsername("Vladimir");

        Assertions.assertEquals(person, database.getElements()[0]);
    }

    @Test
    public void whenFindingPersonByNameNull_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Kaloqn")};
        Database database = new Database(elements);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername(null);
        });
    }

    @Test
    public void whenFindingPersonByNameButThereAreMoreThan1PersonWithSameName_thenThrowOperationNotSupported() throws OperationNotSupportedException {
        Person[] elements = {new Person(5, "Vladimir"), new Person(1, "Vladimir")};
        Database database = new Database(elements);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername("Vladimir");
        });
    }
}
