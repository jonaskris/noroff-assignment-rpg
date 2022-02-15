package character;

import attribute.Attributes;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name, new Attributes(1, 7, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 5, 1));
    }
}