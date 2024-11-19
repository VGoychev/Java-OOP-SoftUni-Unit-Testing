package exercise.p02_ExtendedDatabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTests {

    @Test
    public void test_Constructor() {
        Person person = new Person(5, "Vladimir");
        Person expected = new Person(5, "Vladimir");

        Assertions.assertEquals(expected.getId(), person.getId());
        Assertions.assertEquals(expected.getUsername(), person.getUsername());
    }
}
