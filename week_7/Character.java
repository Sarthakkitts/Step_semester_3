public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Start at full health
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            return; // Ignore negative damage
        }
        int newHealth = health - amount;
        health = Math.max(0, newHealth); // Clamp at 0
    }

    public void heal(int amount) {
        if (amount < 0) {
            return; // Ignore negative healing
        }
        int newHealth = health + amount;
        health = Math.min(maxHealth, newHealth); // Clamp at maxHealth
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
