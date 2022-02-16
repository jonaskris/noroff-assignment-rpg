package item;

import attribute.Attributes;
import character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    static Warrior warrior;

    @BeforeEach
    void setup() {
        warrior = new Warrior("name");
    }

    @Test
    void TestEquipWeapon_ValidWeapon_ShouldPass() {
        final boolean expectedReturnValue = true;
        Weapon weapon = new Weapon("Common Axe", 1, WeaponType.Axe, 7, 1.1f);

        final boolean actualReturnValue = assertDoesNotThrow(() -> warrior.equip(weapon));

        assertEquals(expectedReturnValue, actualReturnValue);
    }

    @Test
    void TestEquipWeapon_WeaponTooHighLevel_ShouldThrowException() {
        final String expectedExceptionMessage = "Character can not equip weapon with larger level requirement than current level!";
        Weapon weapon = new Weapon("Common Axe", 2, WeaponType.Axe, 7, 1.1f);

        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class, () -> warrior.equip(weapon));

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void TestEquipWeapon_WeaponTypeInvalid_ShouldThrowException() {
        final String expectedExceptionMessage = "Character can not equip this weapon type!";
        Weapon weapon = new Weapon("Common Bow", 1, WeaponType.Bow, 12, 0.8f);

        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class, () -> warrior.equip(weapon));

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void TestEquipArmor_ValidArmor_ShouldPass() {
        final boolean expectedReturnValue = true;
        Armor armor = new Armor("Common Plate Body Armor", 1, Slot.Body, ArmorType.Plate, new Attributes(1, 0, 0));

        final boolean actualReturnValue = assertDoesNotThrow(() -> warrior.equip(armor));

        assertEquals(expectedReturnValue, actualReturnValue);
    }

    @Test
    void TestEquipArmor_ArmorTooHighLevel_ShouldThrowException() {
        final String expectedExceptionMessage = "Character can not equip armor with larger level requirement than current level!";
        Armor armor = new Armor("Common Plate Body Armor", 2, Slot.Body, ArmorType.Plate, new Attributes(1, 0, 0));

        InvalidArmorException exception = assertThrows(InvalidArmorException.class, () -> warrior.equip(armor));

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void TestEquipArmor_ArmorTypeInvalid_ShouldThrowException() {
        final String expectedExceptionMessage = "Character can not equip this armor type!";
        Armor armor = new Armor("Common Cloth Head Armor", 1, Slot.Head, ArmorType.Cloth, new Attributes(0, 0, 5));

        InvalidArmorException exception = assertThrows(InvalidArmorException.class, () -> warrior.equip(armor));

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void TestDamagePerSecond_NoEquippedWeapon_ShouldPass() {
        final float expectedDamagePerSecond = 1.0f + (5.0f / 100.0f);

        final float actualDamagePerSecond = warrior.getDamagePerSecond();

        assertEquals(expectedDamagePerSecond, actualDamagePerSecond);
    }

    @Test
    void TestDamagePerSecond_ValidEquippedWeapon_ShouldPass() {
        final float expectedDamagePerSecond = (7.0f * 1.1f) * (1.0f + (5.0f / 100.0f));
        Weapon weapon = new Weapon("Common Axe", 1, WeaponType.Axe, 7, 1.1f);

        assertDoesNotThrow(() -> warrior.equip(weapon));
        final float actualDamagePerSecond = warrior.getDamagePerSecond();

        assertEquals(expectedDamagePerSecond, actualDamagePerSecond);
    }

    @Test
    void TestDamagePerSecond_ValidEquippedWeaponAndArmor_ShouldPass() {
        final float expectedDamagePerSecond = (7.0f * 1.1f) * (1.0f + ((5.0f + 1.0f) / 100.0f));
        Weapon weapon = new Weapon("Common Axe", 1, WeaponType.Axe, 7, 1.1f);
        Armor armor = new Armor("Common Plate Body Armor", 1, Slot.Body, ArmorType.Plate, new Attributes(1, 0, 0));

        assertDoesNotThrow(() -> warrior.equip(weapon));
        assertDoesNotThrow(() -> warrior.equip(armor));
        final float actualDamagePerSecond = warrior.getDamagePerSecond();

        assertEquals(expectedDamagePerSecond, actualDamagePerSecond);
    }
}