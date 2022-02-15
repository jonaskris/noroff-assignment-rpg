package attribute;

public class Attributes {
    private int strength, dexterity, intelligence;

    public Attributes(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void add(Attributes attributes) {
        this.strength += attributes.strength;
        this.dexterity += attributes.dexterity;
        this.intelligence += attributes.intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
