package edu.db.myBrute.domain;

public class Weapon {
    private int weaponId;
    private int strength;
    private int agility;
    private int speed;
    private int chance;
    private GameLevel level;

    public Weapon() {
    }

    public Weapon(int weaponId, int strength, int agility, int speed, int chance, GameLevel level) {
        this.weaponId = weaponId;
        this.strength = strength;
        this.agility = agility;
        this.speed = speed;
        this.chance = chance;
        this.level = level;
    }

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public GameLevel getLevel() {
        return level;
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }
}
