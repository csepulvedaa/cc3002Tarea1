package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonkTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Aldeano,Asedio,Caballo,Monje,Monje2;
    /**
     * Initialize test case
     */
    @Before
    //Start the scenario
    public void Setup() throws Exception {
        Caballo = new Cavalry();
        Infante = new Infantry();
        Arquero = new Archer();
        Monje = new Monk();
        Monje2 = new Monk();
        Aldeano = new Villager();
        Asedio = new Siege();
        type="Monk";
        hp=100;
        attack=50;
        damage=0;}

    @Test
    public void attack() {
        //iguala hp al daño, condicion de debilitar unidad
        Monje.SetHp(0);
        assertFalse("Expects Unit dead",Monje.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Monje.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Monje.getStatus());
        Monje.SetHp(0);
        Monje.attack(Aldeano);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Aldeano.getDamage(),0);
        Monje.SetHp(hp);
        Monje.SetDamage(hp);
        Monje.attack(Asedio);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Asedio.getDamage(),0);
        Monje2.attack(Monje);
        assertEquals("Expects no change in damage as monk is dead, monk 2 cant revive",hp,Monje.getDamage(),0);
        Monje.SetHp(300);
        Monje.SetDamage(150);
        Monje2.attack(Monje);
        assertEquals("Expects Monk alive",50,Monje.getDamage(),0);
    }

    @Test
    public void receivedamagefromInfantry() {
        Infante.SetAttack(30);
        Infante.attack(Monje);
        assertEquals("Expect unit dead damage=hp",Monje.getHP(),Monje.getDamage(),0);
    }

    @Test
    public void receivedamagefromArcher() {
        Arquero.SetAttack(30);
        Arquero.attack(Monje);
        assertEquals("Expect unit dead damage=hp",Monje.getHP(),Monje.getDamage(),0);
    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetAttack(30);
        Caballo.attack(Monje);
        assertEquals("Expect unit dead damage=hp",Monje.getHP(),Monje.getDamage(),0);
    }

    @Test
    public void receivedamagefromSiege() {
        Asedio.SetAttack(60);
        Asedio.attack(Monje);
        assertEquals("Expect unit dead damage=hp",Monje.getHP(),Monje.getDamage(),0);
    }

    @Test
    public void receivedamagefromMonk() {
        Monje.SetAttack(200);
        Monje2.SetHp(300);
        Monje2.SetDamage(150);
        Monje.attack(Monje2);
        assertEquals("Expect Healed monk2",50,Monje2.getDamage(),0);
    }

    @Test
    public void receivedamagefromVillager() {
        Aldeano.SetAttack(9999);
        Monje.SetDamage(150);
        Aldeano.attack(Monje);
        assertEquals("Expect no damage",150,Monje.getDamage(),0);

    }
}