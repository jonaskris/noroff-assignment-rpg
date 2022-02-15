package character;

import attribute.Attributes;

public abstract class Character {
    private String name;
    private int level;
    protected Attributes baseAttributes; // Initial attributes + attributes from level
    private Attributes bonusAttributes; // Attributes gained from equipped items

    public Character(String name, Attributes baseAttributes) {
        this.baseAttributes = baseAttributes;
        this.bonusAttributes = new Attributes(0, 0, 0);
        this.name = name;
        this.level = 1;
    }

    protected abstract void levelUpIncreaseAttributes();

    public void levelUp() {
        level += 1;
        levelUpIncreaseAttributes();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Attributes getBaseAttributes() {
        return baseAttributes;
    }

    public Attributes getBonusAttributes() {
        return bonusAttributes;
    }
}
