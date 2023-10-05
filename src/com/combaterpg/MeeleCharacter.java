package com.combaterpg;

public class MeeleCharacter extends BaseCharacter {

    // Atributo Const
    private final int RANGE = 2;

    // Construtores

    public MeeleCharacter(String nome) {
        super(nome);
        setRange(RANGE);
    }
    public MeeleCharacter(String name, int position) {
        super(name, position);
        setRange(RANGE);
    }
    public MeeleCharacter(String name, int level, int position) {
        super(name,level,position);
        setRange(RANGE);
    }
}