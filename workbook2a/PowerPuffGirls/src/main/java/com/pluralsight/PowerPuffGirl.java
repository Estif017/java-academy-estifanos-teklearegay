package com.pluralsight;

public class PowerPuffGirl {
    // Constants
    private static final int DEFAULT_HEALTH = 10;
    private static final int DEFAULT_ATTACK_DAMAGE = 100;
    private static final int DEFAULT_POWER = 100;
    private static final int MAX_HEALTH = 100;
    private static final int MAX_POWER = 100;

    // Instance variables
    private String name;
    private int health;
    private String outfitColor;
    private int attackDamage;
    private int power;

    // Constructor
    public PowerPuffGirl(String name, String outfitColor) {
        this.name = name;
        this.outfitColor = outfitColor;
        this.health = DEFAULT_HEALTH;
        this.attackDamage = DEFAULT_ATTACK_DAMAGE;
        this.power = DEFAULT_POWER;
    }

    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public String getOutfitColor() { return outfitColor; }
    public int getAttackDamage() { return attackDamage; }
    public int getPower() { return power; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setOutfitColor(String outfitColor) { this.outfitColor = outfitColor; }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = Math.min(health, MAX_HEALTH);
        }
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = Math.max(0, attackDamage);
    }

    public void setPower(int power) {
        if (power < 0) {
            this.power = 0;
        } else {
            this.power = Math.min(power, MAX_POWER);
        }
    }

    // Behavior methods
    public void heal(int amount) {
        if (health == MAX_HEALTH) {
            System.out.println(name + " is already at full health!");
        } else {
            System.out.println(name + " drinks a potion and heals " + amount + " points.");
            setHealth(this.health + amount);
        }
    }

    public void takeDamage(int damage) {
        if (damage <= 0) return;
        setHealth(this.health - damage);
        System.out.println(name + " took " + damage + " damage! Current health: " + health);
    }

    public void attack(PowerPuffGirl enemy) {
        if (enemy == null) return;
        System.out.println(name + " attacks " + enemy.getName() + " for " + attackDamage + " damage!");
        enemy.takeDamage(attackDamage);
    }

    // For debugging
    @Override
    public String toString() {
        return String.format("PowerPuffGirl{name='%s', color='%s', health=%d, attack=%d, power=%d}",
                name, outfitColor, health, attackDamage, power);
    }
}
