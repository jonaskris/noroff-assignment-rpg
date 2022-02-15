package character;

import attribute.Attributes;
import item.ArmorType;
import item.WeaponType;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name, new Attributes(2, 6, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 4, 1));
    }

    @Override
    protected boolean canEquipWeaponType(WeaponType weaponType) {
        return weaponType == WeaponType.Dagger || weaponType == WeaponType.Sword;
    }

    @Override
    protected boolean canEquipArmorType(ArmorType armorType) {
        return armorType == ArmorType.Mail || armorType == ArmorType.Leather;
    }
}