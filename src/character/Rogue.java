package character;

import attribute.Attributes;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name, new Attributes(2, 6, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 4, 1));
    }
}