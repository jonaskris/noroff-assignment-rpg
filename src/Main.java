import attribute.Attributes;
import character.Warrior;
import item.*;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        for(int i = 0; i < 20; i++)
            warrior.levelUp();

        Weapon weapon = new Weapon("Legendary Swift Axe", 15, WeaponType.Axe, 45, 1.4f);
        Armor head = new Armor("Fierce Pot With Handle", 9, Slot.Head, ArmorType.Plate, new Attributes(5, 0, 0));
        Armor body = new Armor("Sturdy Chestplate", 8, Slot.Body, ArmorType.Plate, new Attributes(8, 2, 1));
        Armor legs = new Armor("Mythic Mail Leggings", 13, Slot.Legs, ArmorType.Mail, new Attributes(4, 4, 2));

        try {
            warrior.equip(weapon);
            warrior.equip(head);
            warrior.equip(body);
            warrior.equip(legs);
        } catch(Exception e) {
            System.out.println("Failed to equip items. Exception message: " + e.getMessage());
        }

        System.out.println(warrior);

    }
}
