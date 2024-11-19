package lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyTests {

    @Test
    public void whenDummyHas10HealthAndTakesAttackFromAxeWith2Power_thenDummiesHealthWillBecome8Points () {

        Dummy dummy = new Dummy(10, 10);
        dummy.takeAttack(2);
        Assertions.assertEquals(8, dummy.getHealth());
    }

    @Test
    public void whenDummyHas1HealthAndTakes2AttackPoints_thenDummyDies(){
        Dummy dummy = new Dummy(1, 10);
        Assertions.assertThrows(IllegalStateException.class, () -> {
           dummy.giveExperience();
        });
        dummy.takeAttack(2);
        Assertions.assertTrue(dummy.isDead());
        Assertions.assertEquals(10, dummy.giveExperience());
        Assertions.assertThrows(IllegalStateException.class, () -> {
            dummy.takeAttack(2);
        });
    }

}
