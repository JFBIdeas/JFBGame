package jfb.domain.entity;

import java.util.List;

public abstract class Entity {
    String name;
    int health;
    List<Weapons> weapons;
    Integer[][] location;

    public Entity() {
    }

    public Entity(String name, int health, List<Weapons> weapons, Integer[][] location) {
        this.name = name;
        this.health = health;
        this.weapons = weapons;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Weapons> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapons> weapons) {
        this.weapons = weapons;
    }

    public Integer[][] getLocation() {
        return location;
    }

    public void setLocation(Integer[][] location) {
        this.location = location;
    }
}
