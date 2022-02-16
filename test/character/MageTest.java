package character;

import attribute.Attributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    static Mage mage;

    @BeforeEach
    void setup() {
        mage = new Mage("name");
    }

    @Test
    void TestCreateMage_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 1, expectedBaseDexterity = 1, expectedBaseIntelligence = 8;

        final Attributes actualBaseAttributes = mage.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }

    @Test
    void TestLevelUpMage_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 2, expectedBaseDexterity = 2, expectedBaseIntelligence = 13;

        mage.levelUp();
        final Attributes actualBaseAttributes = mage.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }
}