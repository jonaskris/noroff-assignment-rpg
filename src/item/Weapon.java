package item;

public class Weapon extends Item {
    private WeaponType weaponType;
    private float damage;
    private float attackSpeed;

    public Weapon(String name, int levelRequirement, WeaponType weaponType, float damage, float attackSpeed) {
        super(name, levelRequirement, Slot.Weapon);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public float getDamagePerSecond() { return damage * attackSpeed; }

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
