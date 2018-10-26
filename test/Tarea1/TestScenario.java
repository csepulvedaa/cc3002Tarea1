package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestScenario {

    private double hp ,attack,damage;
    private Unit Infante, Arquero,Aldeano,Asedio,Caballo,Infante2,Monje,Caball2,Aldeano2;
    private Building Castillo,Barraca;

    @Before
    public void setUp() throws Exception {
        Aldeano2= new Villager();
        Monje = new Monk();
        Caballo = new Cavalry();
        Barraca= new Barrack();
        Castillo = new Castle();
        Asedio = new Siege();
        Infante = new Infantry();
        Infante2 = new Infantry();
        Arquero = new Archer();
        Aldeano = new Villager();
        Caball2 = new Cavalry();
        hp=1000;
        attack=100;
        damage=0;
    }
    @Test
    public void receivedamagefromInfantry() {
        Infante.SetHp(hp);
        Infante.SetAttack(attack);
        Castillo.SetAttack(attack);
        Caballo.SetAttack(attack);
        Caballo.attack(Infante2);
        Infante.attack(Infante2);
        assertEquals("Expect normal damage", attack * 2, Infante2.getDamage(), 0);
        Castillo.attack(Infante);
        assertEquals("Expects normal castle damage",attack*1.2,Infante.getDamage(),0);

    }

    @Test
    public void receivedamagefromArcher() {
        Arquero.SetHp(hp);
        Aldeano.SetAttack(attack);
        Castillo.SetAttack(attack);
        Aldeano.attack(Arquero);
        assertEquals("Expect normal damage", attack, Arquero.getDamage(), 0);
        Castillo.attack(Arquero);
        assertEquals("Expects normal castle damage",220,Arquero.getDamage(),0);

    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetHp(hp);
        Arquero.SetAttack(attack);
        Caball2.SetAttack(attack);
        Asedio.SetAttack(attack);
        Arquero.attack(Caballo);
        Caball2.attack(Caballo);
        Asedio.attack(Caballo);
        assertEquals("Expect normal damage", attack * 3, Caballo.getDamage(), 0);


    }
    @Test
    public void receivedamagefromVillager() {
        Caballo.SetHp(hp);
        Aldeano2.SetAttack(attack);
        Aldeano2.attack(Aldeano);
        assertEquals("Expect normal damage", attack , Aldeano.getDamage(), 0);

    }

}