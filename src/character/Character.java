package character;

import attribute.Attributes;

public abstract class Character {
    String name;
    int level;
    Attributes baseAttributes; // Initial attributes + attributes from level
    Attributes bonusAttributes; // attribute.Attributes gained from equipped items

    public Character(String name, Attributes baseAttributes) {
        this.baseAttributes = baseAttributes;
        this.bonusAttributes = new Attributes(0, 0, 0, 0);
        this.name = name;
        this.level = 1;
    }

    public abstract void levelUp();
}
