package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfantryTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Aldeano,Asedio;
    /**
     * Initialize test case
     */
    @Before
    //Start the scenario
    public void setUp() throws Exception {
        Infante = new Infantry();
        Arquero = new Archer();
        Aldeano = new Villager();
        Asedio = new Siege();
        type="Infantry";
        hp=100;
        attack=50;
        damage=0;}
    @Test
    public void testGS(){
        Infante.SetStatus(true);
        assertTrue("Estado vivo",Infante.getStatus());
        Infante.SetType(type);
        assertEquals("Tipo infate",Infante.type,type);
        Infante.SetAttack(attack);
        assertEquals("Igual ataque",Infante.attack,attack,0);
    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Infante.SetHp(0);
        assertFalse("Expects Unit dead",Infante.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Infante.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Infante.getStatus());
        Infante.SetHp(0);
        Infante.attack(Aldeano);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Aldeano.getDamage(),0);
        Infante.SetHp(hp);
        Infante.SetDamage(hp);
        Infante.attack(Asedio);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Asedio.getDamage(),0);
    }
    @Test

    public void testrecievedamagefromSiege() {
        Asedio.SetAttack(30);
        Asedio.attack(Infante);
        assertEquals("Expect higher damage",45.0,Infante.getDamage(),0);
    }
    @Test
    public void testrecievedamagefromArcher() {
        Arquero.SetAttack(30);
        Arquero.attack(Infante);
        assertEquals("Expect higher damage",36,Infante.getDamage(),0);


    }

    @org.junit.Test
    public void recievedamagefromVillager() {
        Aldeano.SetAttack(10);
        Aldeano.attack(Infante);
        assertEquals("Expect Lower damage",8,Infante.getDamage(),0);


    }
}