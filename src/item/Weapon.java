package item;

public class Weapon extends Item {
    private WeaponType weaponType;
    private float damage;
    private float attackSpeed;

    public Weapon(String name, int levelRequirement, Slot slot, float damage, float attackSpeed) {
        super(name, levelRequirement, slot);
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
