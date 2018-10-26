package Tarea1;

import org.junit.Before;
import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import static org.junit.Assert.*;

public class SiegeTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante,Arquero,Caballo,Asedio,Aldeano;
    private Building Castillo;

    @Before
    public void setUp() throws Exception {
        Arquero = new Archer();
        Infante = new Infantry();
        Aldeano = new Villager();
        Asedio = new Siege();
        Caballo = new Cavalry();
        Castillo = new Castle();
        type="Siege";
        hp=300;
        attack=100;
        damage=0;
    }
    @Test
    public void testGS(){
        Asedio.SetStatus(true);
        assertTrue("Estado vivo",Asedio.getStatus());
        Asedio.SetType(type);
        assertEquals("Tipo infate",Asedio.type,type);
        Asedio.SetAttack(attack);
        assertEquals("Igual ataque",Asedio.attack,attack,0);
    }
    @Test
    public void teststatus(){
        Asedio.SetHp(0);
        assertFalse("Expects Unit dead",Asedio.getStatus());
        Asedio.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Asedio.getStatus());
        Asedio.SetHp(0);
        Asedio.attack(Aldeano);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Aldeano.getDamage(),0);

    }
    @Test
    public void testdamagefromInfantry(){
        Infante.SetAttack(100);
        Infante.attack(Asedio);
        assertEquals("Expect higer damage",120,Asedio.getDamage(),0);
    }
    @Test
    public void testdamagefromArcher(){
        Arquero.SetAttack(100);
        Arquero.attack(Asedio);
        assertEquals("Expect lower damage",80,Asedio.getDamage(),0);
    }
    @Test
    public void testdamagefromCavalry(){
        Caballo.SetAttack(100);
        Caballo.attack(Asedio);
        assertEquals("Expects higher damage",120,Asedio.getDamage(),0);
    }
    @Test
    public void testdamagefromSiege(){
        Asedio.SetAttack(100);
        Asedio.attack(Asedio);
        assertEquals("Expected higher damage",150,Asedio.getDamage(),0);
    }
    @Test
    public void testdamagefromCastle(){
        Castillo.SetAttack(100);
        Castillo.attack(Asedio);
        assertEquals("Expected Lower damage",50,Asedio.getDamage(),0);
    }
    @Test
    public void testdamagefromVillager(){
        Aldeano.SetAttack(100);
        Aldeano.attack(Asedio);
        assertEquals("Expected lower damage",-50,Asedio.getDamage(),0);
        Asedio.SetHp(hp);
        Asedio.SetDamage(hp);
        Aldeano.attack(Asedio);
        assertEquals("Expects no change in damage as castle is dead, Villager cant revive",hp,Asedio.getDamage(),0);
    }



}