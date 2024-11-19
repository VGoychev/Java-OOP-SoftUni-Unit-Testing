package lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroTests {

    @Test
    public void whenHeroAttacksDummyWith5Health_HeroKillsDummyAndCollectsExperience() {
        Hero hero = new Hero("Vladimir");
        Axe axe = hero.getWeapon();
        Dummy dummy = new Dummy(5, 10);
        Assertions.assertEquals("Vladimir", hero.getName());
        Assertions.assertEquals(axe, hero.getWeapon());
        hero.attack(dummy);
        Assertions.assertTrue(dummy.isDead());
        Assertions.assertEquals(10, hero.getExperience());
    }

    @Test
    public void testHeroDoesNotGainExperienceIfDummyIsNotDead(){
        Hero hero = new Hero("Vladimir");
        Dummy dummy = new Dummy(20, 10);
        hero.attack(dummy);
        Assertions.assertFalse(dummy.isDead());
        Assertions.assertEquals(0, hero.getExperience());
    }
}
