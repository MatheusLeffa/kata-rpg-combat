package tests;

import com.combaterpg.BaseCharacter;
import com.combaterpg.Factions;
import com.combaterpg.MeeleCharacter;
import com.combaterpg.Thing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCharacter {

    int testValue = (int) Math.round((Math.random()*100));

    // Attack Tests
    @RepeatedTest(5)
    @DisplayName("Attack - dealDamage 1x")
    void attack_1x() {
        BaseCharacter matt = new MeeleCharacter("Matt", 5,4);
        BaseCharacter chay = new MeeleCharacter("chay", 5,4);

        matt.attack(chay, testValue);
        assertEquals(1000- testValue,chay.getHealth());
    }

    @RepeatedTest(5)
    @DisplayName("Attack - dealDamage 0.5x")
    void attack_0_5x() {
        BaseCharacter matt = new MeeleCharacter("Matt", 5,5);
        BaseCharacter chay = new MeeleCharacter("chay", 10,4);

        matt.attack(chay, testValue);
        assertEquals(Math.round(1000-(testValue *0.5)),chay.getHealth());
    }

    @RepeatedTest(5)
    @DisplayName("Attack - dealDamage 1.5x")
    void attack_1_5x() {
        BaseCharacter matt = new MeeleCharacter("Matt", 10,5);
        BaseCharacter chay = new MeeleCharacter("chay", 5,5);

        matt.attack(chay, testValue);
        assertEquals(Math.round(1000-(testValue *1.5)),chay.getHealth());
    }


    // Attack Exceptions
    @Test
    @DisplayName("Attack Exception - Attack Yourself")
    void attackYourself_Exception() {
        BaseCharacter matt = new MeeleCharacter("Matt");

        matt.attack(matt, testValue);
    }

    @Test
    @DisplayName("Attack Exception - Out of Range")
    void OutOfRange_Exception() {
        BaseCharacter matt = new MeeleCharacter("Matt",5);
        BaseCharacter matt2 = new MeeleCharacter("Matt2",50);

        matt.attack(matt2, testValue);
    }

    @Test
    @DisplayName("Attack Exception - Negative Damage")
    void negativeDamage_Exception() {
        BaseCharacter matt = new MeeleCharacter("Matt");
        BaseCharacter matt2 = new MeeleCharacter("Matt2");

        matt.attack(matt2, -50);
    }

    @Test
    @DisplayName("Attack Exception - Already Dead")
    void alreadyDead_Exception() {
        BaseCharacter matt = new MeeleCharacter("Matt");
        BaseCharacter matt2 = new MeeleCharacter("Matt2");
        matt2.setAlive(false);

        matt.attack(matt2, testValue);
    }


    // Heal Test
    @Test
    @DisplayName("Heal - Heal others Test")
    void healOthersTest(){
        Factions factions = new Factions();
        BaseCharacter matt = new MeeleCharacter("Matt");
        BaseCharacter chay = new MeeleCharacter("Chay");
        BaseCharacter rafa = new MeeleCharacter("Rafa");

        factions.joinFaction(matt, "Test");
        factions.joinFaction(chay, "Test");

        rafa.attack(chay, 500);
        matt.heal(chay,500);

        assertEquals(1000,chay.getHealth());
    }

    @Test
    @DisplayName("Heal - Heal yourself Test")
    void healYourselfTest(){
        BaseCharacter matt = new MeeleCharacter("Matt");
        BaseCharacter chay = new MeeleCharacter("Chay");


        chay.attack(matt, 500);
        matt.heal(matt,500);

        assertEquals(1000,matt.getHealth());
    }


    // Factions Test
    @Test
    @DisplayName("Faction - Faction Join & Leave Test")
    void factionJoinLeave(){
        Factions factions = new Factions();
        BaseCharacter matt = new MeeleCharacter("Matt");
        BaseCharacter chay = new MeeleCharacter("Chay");

        System.out.println("-> Inicio:");
        System.out.println("------------------------------");

        matt.printFaction();
        factions.printFactionList();
        factions.printFactionMembers();
        System.out.println("------------------------------");

        factions.joinFaction(chay, "TestFaction");
        factions.joinFaction(matt, "TestFaction");
        factions.joinFaction(matt, "AlunoFaction");

        System.out.println("-> Após Matt se juntar com as facções:");
        System.out.println("------------------------------");

        matt.printFaction();
        factions.printFactionList();
        factions.printFactionMembers();
        System.out.println("------------------------------");

        factions.leaveFaction(matt,"TestFaction");

        System.out.println("-> Após Matt deixar a facção -> TestFaction:");
        System.out.println("------------------------------");

        matt.printFaction();
        factions.printFactionMembers();
        factions.printFactionList();
        System.out.println("------------------------------");

        factions.leaveFaction(matt,"AlunoFaction");

        System.out.println("-> Após Matt deixar a facção -> AlunoFaction:");
        System.out.println("------------------------------");

        matt.printFaction();
        factions.printFactionMembers();
        factions.printFactionList();
    }


    // Props Test
    @Test
    @DisplayName("Things - Damage Things")
    void thingsDamage() {
        Thing casa = new Thing("Coisa", 5000,1);
        BaseCharacter matt = new MeeleCharacter("matt");

        matt.attack(casa, 500);
        assertEquals(4500,casa.getHealth());

    }
}