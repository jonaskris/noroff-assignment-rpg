package attribute;

public class Attributes {
    private int strength, dexterity, intelligence, vitality;

    public Attributes(int strength, int dexterity, int intelligence, int vitality) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    public void add(Attributes attributes) {
        this.strength += attributes.strength;
        this.dexterity += attributes.dexterity;
        this.intelligence += attributes.intelligence;
        this.vitality += attributes.vitality;
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

    public int getVitality() {
        return vitality;
    }
}
