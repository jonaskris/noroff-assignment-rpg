package attribute;

public class Attributes {
    private int strength, dexterity, intelligence;

    public Attributes(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // Copy constructor
    public Attributes(Attributes other) {
        this.strength = other.strength;
        this.dexterity = other.dexterity;
        this.intelligence = other.intelligence;
    }

    public void add(Attributes other) {
        this.strength += other.strength;
        this.dexterity += other.dexterity;
        this.intelligence += other.intelligence;
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
