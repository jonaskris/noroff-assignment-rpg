package item;

import character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    static Warrior warrior;

    @BeforeEach
    void setup() {
        warrior = new Warrior("name");
    }

    @Test
    void TestEquipWeapon_WeaponTooHighLevel_ShouldThrowException() {
        Weapon weapon = new Weapon("Common Axe", 1, 7, 1.1f);
    }
}