package item;

import attribute.Attributes;

public class Armor extends Item {
    private ArmorType armorType;
    private Attributes attributes;

    public Armor(String name, int levelRequirement, Slot slot, ArmorType armorType, Attributes attributes) {
        super(name, levelRequirement, slot);
        this.armorType = armorType;
        this.attributes = attributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
