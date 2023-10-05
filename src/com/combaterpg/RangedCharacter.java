package com.combaterpg;

public class RangedCharacter extends BaseCharacter {

    // Atributo Const
    private final int RANGE = 20;


    // Construtores
    public RangedCharacter(String nome) {
        super(nome);
        setRange(RANGE);
    }
    public RangedCharacter(String name, int position){
        super(name,position);
        setRange(RANGE);
    }
    public RangedCharacter(String name, int level, int position){
        super(name,level,position);
        setRange(RANGE);
    }
}
