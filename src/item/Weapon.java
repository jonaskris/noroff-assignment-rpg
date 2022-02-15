package item;

public class Weapon extends Item {
    private WeaponType weaponType;
    private float damage;
    private float attackSpeed;

    public Weapon(String name, int levelRequirement, float damage, float attackSpeed) {
        super(name, levelRequirement, Slot.Weapon);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public float getDamage() {
        return damage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}
