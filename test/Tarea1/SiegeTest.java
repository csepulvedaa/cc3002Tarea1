package Tarea1;

import org.junit.Before;
import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import static org.junit.Assert.*;

public class SiegeTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante,Arquero,Caballo,Asedio,Aldeano,Monje;

    @Before
    public void setUp() throws Exception {
        Arquero = new Archer();
        Infante = new Infantry();
        Aldeano = new Villager();
        Asedio = new Siege();
        Caballo = new Cavalry();
        type="Siege";
        hp=300;
        attack=100;
        damage=0;
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
    public void testdamagefromVillager(){
        Aldeano.SetAttack(100);
        Asedio.SetHp(100);
        Aldeano.attack(Asedio);
        assertEquals("Expect higher hp 100*0.5 + 100 ",150,Asedio.getHP(),0);
    }



}