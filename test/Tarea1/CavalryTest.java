package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CavalryTest { private String type;
    private double hp ,attack,damage;
    private Unit Infante,Aldeano,Caballo;
    /**
     * Initialize test case
     */
    @Before
    //Start the scenario
    public void setUp() throws Exception {
        Caballo = new Cavalry();
        Infante = new Infantry();
        Aldeano = new Villager();
        type="Infantry";
        hp=100;
        attack=50;
        damage=0;}

    @Test
    public void testGS(){
        Caballo.SetStatus(true);
        assertTrue("Estado vivo",Caballo.getStatus());
        Caballo.SetType(type);
        assertEquals("Tipo infate",Caballo.type,type);
        Caballo.SetAttack(attack);
        assertEquals("Igual ataque",Caballo.attack,attack,0);

    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Caballo.SetHp(damage);
        assertFalse("Expects Unit dead",Caballo.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Caballo.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Caballo.getStatus());
        Caballo.SetHp(0);
        Caballo.attack(Aldeano);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Aldeano.getDamage(),0);
        Caballo.SetHp(hp);
        Caballo.SetDamage(hp);
        Caballo.attack(Infante);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Infante.getDamage(),0);
    }

    @Test
    public void receivedamagefromInfantry() {

        Infante.SetAttack(30);
        Infante.attack(Caballo);
        assertEquals("Expect higher damage",36,Caballo.getDamage(),0);

    }

    @Test
    public void receivedamagefromVillager() {

        Aldeano.SetAttack(10);
        Aldeano.attack(Caballo);
        assertEquals("Expect Lower damage",5,Caballo.getDamage(),0);
    }
}