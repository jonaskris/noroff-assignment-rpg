package character;

import attribute.Attributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    static Ranger ranger;

    @BeforeEach
    void setup() {
        ranger = new Ranger("name");
    }

    @Test
    void TestCreateRanger_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 1, expectedBaseDexterity = 7, expectedBaseIntelligence = 1;

        final Attributes actualBaseAttributes = ranger.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }

    @Test
    void TestLevelUpRanger_BaseAttributesCorrect_ShouldPass() {
        final int expectedBaseStrength = 2, expectedBaseDexterity = 12, expectedBaseIntelligence = 2;

        ranger.levelUp();
        final Attributes actualBaseAttributes = ranger.getBaseAttributes();

        assertEquals(expectedBaseStrength, actualBaseAttributes.getStrength());
        assertEquals(expectedBaseDexterity, actualBaseAttributes.getDexterity());
        assertEquals(expectedBaseIntelligence, actualBaseAttributes.getIntelligence());
    }
}