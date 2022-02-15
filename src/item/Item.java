package item;

public abstract class Item {
    private String name;
    private int levelRequirement;
    private Slot slot;

    public Item(String name, int levelRequirement, Slot slot) {
        this.name = name;
        this.levelRequirement = levelRequirement;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public Slot getSlot() {
        return slot;
    }
}
