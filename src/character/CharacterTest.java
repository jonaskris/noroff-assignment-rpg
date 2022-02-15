package character;

import attribute.Attributes;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    static Character character;

    @BeforeEach
    public void setup() {
        character = new Character("name", new Attributes(0, 0, 0)) {
            @Override
            protected void levelUpIncreaseAttributes() {
                // Not tested in this class
            }
        };
    }

    @Test
    public void TestCreateCharacter_LevelIsOne_ShouldPass() {
        final int expected = 1;

        assertEquals(expected, character.getLevel());
    }

    @Test
    public void TestLevelUp_LevelIsTwo_ShouldPass() {
        final int expected = 1;

        character.levelUp();

        assertEquals(expected, character.getLevel());
    }

}