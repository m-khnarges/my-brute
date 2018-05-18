package edu.db.myBrute.domain;

public class GameLevel {
    private int levelId;
    private int minimum;
    private int maximum;
    private int strength;
    private int agility;
    private int speed;

    public GameLevel() {
    }

    public GameLevel(int levelId, int minimum, int maximum, int strength, int agility, int speed) {
        this.levelId = levelId;
        this.minimum = minimum;
        this.maximum = maximum;
        this.strength = strength;
        this.agility = agility;
        this.speed = speed;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
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
}
