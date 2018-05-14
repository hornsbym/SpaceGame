package com.example.hornsby.spacegame;

public class Ship {
    private int health = 0;
    private int attack = 1;
    private int hori = 3;

    public int getHori() {
        return hori;
    }

    public void setHori(int hori) {
        this.hori = hori;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
