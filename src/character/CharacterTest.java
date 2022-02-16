package character;

import attribute.Attributes;
import item.ArmorType;
import item.WeaponType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    static Character character;

    @BeforeEach
    void setup() {
        character = new Character("name", new Attributes(0, 0, 0)) {
            @Override
            protected void levelUpIncreaseAttributes() {
                // Not tested in this class
            }

            @Override
            protected boolean canEquipWeaponType(WeaponType weaponType) {
                return false; // Not tested in this class
            }

            @Override
            protected boolean canEquipArmorType(ArmorType armorType) {
                return false; // Not tested in this class
            }

            @Override
            protected int extractPrimaryAttribute(Attributes attributes) {
                return 0; // Not tested in this class
            }
        };
    }

    @Test
    void TestCreateCharacter_LevelIsOne_ShouldPass() {
        final int expected = 1;

        assertEquals(expected, character.getLevel());
    }

    @Test
    void TestLevelUp_LevelIsTwo_ShouldPass() {
        final int expected = 2;

        character.levelUp();

        assertEquals(expected, character.getLevel());
    }

}