package edu.db.myBrute.domain;

import java.util.List;

public class GameUser {
    private String username;
    private String password;
    private int experience;
    private GameLevel level;
    private int healthPoint;
    private Hero hero;
    private List<Weapon> weapons;

    public GameUser() {
    }

    public GameUser(String username, String password, int experience, GameLevel level, Hero hero, List<Weapon> weapons) {
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.level = level;
        this.hero = hero;
        this.weapons = weapons;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public GameLevel getLevel() {
        return level;
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
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
}
