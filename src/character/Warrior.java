package character;

import attribute.Attributes;
import item.ArmorType;
import item.WeaponType;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, new Attributes(5, 2, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(3, 2, 1));
    }

    @Override
    protected boolean canEquipWeaponType(WeaponType weaponType) {
        return weaponType == WeaponType.Axe || weaponType == WeaponType.Hammer || weaponType == WeaponType.Sword;
    }

    @Override
    protected boolean canEquipArmorType(ArmorType armorType) {
        return armorType == ArmorType.Mail || armorType == ArmorType.Plate;
    }

    @Override
    protected int extractPrimaryAttribute(Attributes attributes) {
        return attributes.getStrength();
    }
}
