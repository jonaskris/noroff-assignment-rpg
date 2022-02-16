package character;

import attribute.Attributes;
import item.*;

import java.text.DecimalFormat;
import java.util.HashMap;

public abstract class Character {
    private String name;
    private int level;
    protected Attributes baseAttributes;    // Initial attributes + attributes gained from levels
    private Attributes bonusAttributes;     // Attributes gained from equipped items
    private HashMap<Slot, Item> equipment = new HashMap<>();

    public Character(String name, Attributes baseAttributes) {
        this.baseAttributes = baseAttributes;
        this.bonusAttributes = new Attributes(0, 0, 0);
        this.name = name;
        this.level = 1;
    }

    private void updateBonusAttributes() {
        bonusAttributes = equipment.entrySet()
                .stream()
                .filter(element -> element.getValue() instanceof Armor)
                .map(element -> ((Armor)element.getValue()).getAttributes())
                .reduce(new Attributes(0, 0, 0), (acc, curr) -> {acc.add(curr); return acc; });
    }

    protected abstract void levelUpIncreaseAttributes();

    public void levelUp() {
        level += 1;
        levelUpIncreaseAttributes();
    }

    protected abstract boolean canEquipWeaponType(WeaponType weaponType);
    protected abstract boolean canEquipArmorType(ArmorType armorType);

    public boolean equip(Item item) throws InvalidWeaponException, InvalidArmorException {
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
        if(item instanceof Armor)
            updateBonusAttributes();
        return true;
    }

    protected abstract int extractPrimaryAttribute(Attributes attributes);

    public float getDamagePerSecond() {
        Attributes totalAttributes = new Attributes(baseAttributes);
        totalAttributes.add(bonusAttributes);

        int totalPrimaryAttribute = extractPrimaryAttribute(totalAttributes);

        Weapon weapon = (Weapon)equipment.get(Slot.Weapon);
        float weaponDamagePerSecond = 1.0f;
        if(weapon != null)
            weaponDamagePerSecond = weapon.getDamagePerSecond();

        return weaponDamagePerSecond * (1.0f + totalPrimaryAttribute / 100.0f);
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

    @Override
    public String toString() {
        Attributes totalAttributes = new Attributes(baseAttributes);
        totalAttributes.add(bonusAttributes);

        final StringBuilder sb = new StringBuilder("Character Sheet\n");
        sb.append("Name: '").append(name).append("'\n");
        sb.append("Level: ").append(level).append("\n");
        sb.append("Attributes:\n");
        sb.append("\tStrength: ").append(totalAttributes.getStrength()).append("\n");
        sb.append("\tDexterity: ").append(totalAttributes.getDexterity()).append("\n");
        sb.append("\tIntelligence: ").append(totalAttributes.getIntelligence()).append("\n");
        DecimalFormat format = new DecimalFormat("0.00");
        sb.append("DPS: ").append(format.format(getDamagePerSecond())).append("\n");
        return sb.toString();
    }
}
