package com.combaterpg;

public class Thing {

    // Atributos
    private String name;
    private int health = 1000;
    private boolean alive = true;
    private int position = 1;


    // Constructor
    public Thing(String name) {
        this.name = name;
    }

    public Thing(String name, int position) {
        this.name = name;
        setPosition(position);
    }

    public Thing(String name, int health, int position) {
        this.name = name;
        this.health = health;
        setPosition(position);
    }


    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
    }


    // Setter
    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPosition(int position) {
        if (position > 0) {
            this.position = position;
        } else {
            throw new RuntimeException("Deve ser informado valores maiores que 0, na posição do objeto: " + this.name);
        }
    }


    // Methods
    public String isAliveStr() {
        if (this.alive) {
            return (this.name + " ainda está vivo, com " + this.health + " de vida.");
        }
        if (this instanceof BaseCharacter) {
            return (this.name + " foi morto!");
        }
        return (this.name + " foi destruida!");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseCharacter x) {
            return this.name.equals(x.getName());
        }
        return false;
    }

    public int distance(Thing target) {
        return Math.max(Math.abs(this.position - target.position), 0);
    }
}
