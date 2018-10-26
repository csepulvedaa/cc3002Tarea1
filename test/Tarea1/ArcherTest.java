package Tarea1;

import javafx.scene.shape.Arc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArcherTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Arquero2,Asedio,Caballo;
    /**
     * Initialize test case
     */
    @Before
    //Start the scenario
    public void setUp() throws Exception {
        Caballo = new Cavalry();
        Infante = new Infantry();
        Arquero = new Archer();
        Arquero2 = new Archer();
        Asedio = new Siege();
        type="Archer";
        hp=100;
        attack=50;
        damage=0;}

    @Test
    public void testGetSet(){
        Arquero.SetStatus(true);
        assertTrue("Estado vivo",Arquero.getStatus());
        Arquero.SetType(type);
        assertEquals("Tipo infate",Arquero.type,type);
        Arquero.SetAttack(attack);
        assertEquals("Igual ataque",Arquero.attack,attack,0);

    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Arquero.SetHp(damage);
        assertFalse("Expects Unit dead",Arquero.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Arquero.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Arquero.getStatus());
        Arquero.SetHp(0);
        Arquero.attack(Infante);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Infante.getDamage(),0);
        Arquero.SetHp(hp);
        Arquero.SetDamage(hp);
        Arquero.attack(Infante);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Infante.getDamage(),0);
    }
    @Test
    public void receivedamagefromInfantry() {
        Infante.SetAttack(30);
        Infante.attack(Arquero);
        assertEquals("Expect higher damage",36,Arquero.getDamage(),0);
    }

    @Test
    public void receivedamagefromArcher() {
        Arquero.SetAttack(30);
        Arquero.attack(Arquero2);
        assertEquals("Expect higher damage",36,Arquero2.getDamage(),0);

    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetAttack(30);
        Caballo.attack(Arquero);
        assertEquals("Expect higher damage",45,Arquero.getDamage(),0);

    }

    @Test
    public void receivedamagefromSiege() {
        Asedio.SetAttack(30);
        Asedio.attack(Arquero);
        assertEquals("Expect higher damage",45,Arquero.getDamage(),0);

    }
}