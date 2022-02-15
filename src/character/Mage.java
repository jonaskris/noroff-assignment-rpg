package character;

import attribute.Attributes;
import item.ArmorType;
import item.WeaponType;

public class Mage extends Character {
    public Mage(String name) {
        super(name, new Attributes(1, 1, 8));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 1, 5));
    }

    @Override
    protected boolean canEquipWeaponType(WeaponType weaponType) {
        return weaponType == WeaponType.Staff || weaponType == WeaponType.Wand;
    }

    @Override
    protected boolean canEquipArmorType(ArmorType armorType) {
        return armorType == ArmorType.Cloth;
    }
}