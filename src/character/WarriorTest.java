package character;

import attribute.Attributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    static Warrior warrior;

    @BeforeEach
    void setup() {
        warrior = new Warrior("name");
    }

    @Test
    void TestCreateWarrior_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 5, expectedBaseDexterity = 2, expectedBaseIntelligence = 1;

        final Attributes actualBaseAttributes = warrior.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }

    @Test
    void TestLevelUpWarrior_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 8, expectedBaseDexterity = 4, expectedBaseIntelligence = 2;

        warrior.levelUp();
        final Attributes actualBaseAttributes = warrior.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }
}