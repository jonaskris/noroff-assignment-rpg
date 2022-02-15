package character;

import attribute.Attributes;

public class Mage extends Character {
    public Mage(String name) {
        super(name, new Attributes(1, 1, 8));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 1, 5));
    }
}