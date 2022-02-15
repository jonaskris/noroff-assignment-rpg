package character;

import attribute.Attributes;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, new Attributes(5, 2, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(3, 2, 1));
    }
}
