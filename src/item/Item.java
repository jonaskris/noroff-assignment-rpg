package item;

public abstract class Item {
    private String name;
    private int levelRequirement;
    private Slot slot;

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
