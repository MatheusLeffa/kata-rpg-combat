package com.combaterpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Factions {

    // Atributos
    private final Map<BaseCharacter, List<String>> factionMembers = new HashMap<>();
    private final List<String> factionList = new ArrayList<>();


    // Metodos publicos
    public void joinFaction(BaseCharacter character, String faction) {
        character.getFaction().add(faction);
        createFaction(faction);
        addFactionMember(character, faction);
    }

    public void leaveFaction(BaseCharacter character, String faction) {
        if (!character.getFaction().contains(faction)) {
            System.out.println("Não foi localizado a facção " + faction + " atribuido ao personagem " + character.getName() + ".");
        } else {
            character.getFaction().remove(faction);
            factionMembers.get(character).remove(faction);
            if (factionMembers.get(character).size() == 0) {
                factionMembers.remove(character);
            }
        }
    }


    // Metodos privados
    private void createFaction(String faction) {
        if (!factionList.contains(faction)) {
            factionList.add(faction);
        }
    }

    private void addFactionMember(BaseCharacter character, String faction) {
        if (!factionMembers.containsKey(character)) {
            factionMembers.put(character, new ArrayList<>());
        }
        factionMembers.get(character).add(faction);
    }


    // Print methods
    public void printFactionList() {
        System.out.println("Faction List: " + factionList);
    }

    public void printFactionMembers() {
        String printMembers = factionMembers.keySet().stream()
                .map(key -> key.getName() + "=" + factionMembers.get(key))
                .collect(Collectors.joining(", ","{", "}"));
        System.out.println("Faction Integrantes: " + printMembers);;
    }
}
