package character;

import attribute.Attributes;
import item.ArmorType;
import item.WeaponType;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name, new Attributes(1, 7, 1));
    }

    @Override
    protected void levelUpIncreaseAttributes() {
        this.baseAttributes.add(new Attributes(1, 5, 1));
    }

    @Override
    protected boolean canEquipWeaponType(WeaponType weaponType) {
        return weaponType == WeaponType.Bow;
    }

    @Override
    protected boolean canEquipArmorType(ArmorType armorType) {
        return armorType == ArmorType.Mail || armorType == ArmorType.Leather;
    }
}