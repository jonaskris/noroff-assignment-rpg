package character;

import attribute.Attributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    static Rogue rogue;

    @BeforeEach
    void setup() {
        rogue = new Rogue("name");
    }

    @Test
    void TestCreateRogue_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 2, expectedBaseDexterity = 6, expectedBaseIntelligence = 1;

        final Attributes actualBaseAttributes = rogue.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }

    @Test
    void TestLevelUpRogue_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 3, expectedBaseDexterity = 10, expectedBaseIntelligence = 2;

        rogue.levelUp();
        final Attributes actualBaseAttributes = rogue.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }
}