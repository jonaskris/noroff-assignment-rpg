package attribute;

public class Attributes {
    int strength, dexterity, intelligence, vitality;

    public Attributes(int strength, int dexterity, int intelligence, int vitality) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    public void add(int strength, int dexterity, int intelligence, int vitality) {
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
        this.vitality += vitality;
    }
}
