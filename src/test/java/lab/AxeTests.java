package lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AxeTests {

    @Test
    public void whenAxeHasTenPointsDurabilityAndAttack_thenPointsWillBecomeNine() {
        Axe axe = new Axe(2, 10);

        axe.attack(new Dummy(5, 5));

        Assertions.assertEquals(9, axe.getDurabilityPoints());
    }
    @Test
    public void whenAxeHas0PointsDurability_thenExpectIllegalStateException (){
        Axe axe = new Axe(2, 0);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            axe.attack(new Dummy(5, 5));
        });
    }

    @Test
    public void get10AttackPointsOfAnAxe(){
        Axe axe = new Axe(10, 10);

        Assertions.assertEquals(10, axe.getAttackPoints());
    }
}
