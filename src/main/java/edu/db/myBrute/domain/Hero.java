package edu.db.myBrute.domain;

public class Hero {
    private int heroId;
    private int strength;
    private int agility;
    private int speed;
    private int heroType;

    public Hero() {
    }

    public Hero(int heroId, int strength, int agility, int speed, int heroType) {
        this.heroId = heroId;
        this.strength = strength;
        this.agility = agility;
        this.speed = speed;
        this.heroType = heroType;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
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

    public int getHeroType() {
        return heroType;
    }

    public void setHeroType(int heroType) {
        this.heroType = heroType;
    }
}
