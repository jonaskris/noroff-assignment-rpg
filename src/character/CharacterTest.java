package character;

import attribute.Attributes;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    static Character character;

    @BeforeEach
    public void setup() {
        character = new Character("name", new Attributes(0, 0, 0, 0)) {
            @Override
            public void levelUp() {

            }
        };
    }

    @Test
    public void TestCreateCharacter_LevelIsOne_ShouldPass() {
        final int expected = 1;
        assertEquals(character.level, expected);
    }

}