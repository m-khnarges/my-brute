package edu.db.myBrute.domain;

import java.util.ArrayList;
import java.util.List;

public class GameUser {
    private String username;
    private int experience;
    private int levelId;
    private int healthPoint;
    private int leftFights;
    private Hero hero;
    private List<Weapon> weapons;

    public GameUser() {
        hero = new Hero();
        weapons = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getLeftFights() {
        return leftFights;
    }

    public void setLeftFights(int leftFights) {
        this.leftFights = leftFights;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
}
