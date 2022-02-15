package character;

import attribute.Attributes;
import item.*;

import java.util.HashMap;

public abstract class Character {
    private String name;
    private int level;
    protected Attributes baseAttributes; // Initial attributes + attributes from level
    private Attributes bonusAttributes; // Attributes gained from equipped items
    private HashMap<Slot, Item> equipment;

    public Character(String name, Attributes baseAttributes) {
        this.baseAttributes = baseAttributes;
        this.bonusAttributes = new Attributes(0, 0, 0);
        this.name = name;
        this.level = 1;
    }

    protected abstract void levelUpIncreaseAttributes();

    public void levelUp() {
        level += 1;
        levelUpIncreaseAttributes();
    }

    protected abstract boolean canEquipWeaponType(WeaponType weaponType);
    protected abstract boolean canEquipArmorType(ArmorType armorType);

    public void equip(Item item) throws InvalidWeaponException, InvalidArmorException {
        if(item instanceof Weapon) {
            Weapon weaponItem = (Weapon)item;

            if(!canEquipWeaponType(weaponItem.getWeaponType()))
                throw new InvalidWeaponException("Character can not equip this weapon type!");
            if(weaponItem.getLevelRequirement() > this.getLevel())
                throw new InvalidWeaponException("Character can not equip weapon with larger level requirement than current level!");
        } else { // Armor
            Armor armorItem = (Armor)item;
            if(!canEquipArmorType(armorItem.getArmorType()))
                throw new InvalidArmorException("Character can not equip this armor type!");
            if(armorItem.getLevelRequirement() > this.getLevel())
                throw new InvalidArmorException("Character can not equip armor with larger level requirement than current level!");
        }
        
        equipment.put(item.getSlot(), item);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Attributes getBaseAttributes() {
        return baseAttributes;
    }

    public Attributes getBonusAttributes() {
        return bonusAttributes;
    }
}
