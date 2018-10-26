package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CastleTest {

    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Aldeano,Asedio,Caballo;
    private Building Castillo,Castillo2;

    @Before
    public void setUp() throws Exception {
        Caballo = new Cavalry();
        Castillo2= new Castle();
        Castillo = new Castle();
        Asedio = new Siege();
        Infante = new Infantry();
        Arquero = new Archer();
        Aldeano = new Villager();
        type="Castle";
        hp=100;
        attack=200;
        damage=0;
    }
    @Test
    public void testGS(){
        Castillo.SetStatus(true);
        assertTrue("Estado vivo",Castillo.getStatus());
        Castillo.SetType(type);
        assertEquals("Tipo Monje",Castillo.type,type);
    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Castillo.SetHp(0);
        assertFalse("Expects Unit dead",Castillo.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Castillo.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Infante.getStatus());
        Castillo.SetHp(0);
        Castillo.attack(Aldeano);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Aldeano.getDamage(),0);

    }

    @Test
    public void receivedamagefromInfantry() {
        Infante.SetAttack(100);
        Infante.attack(Castillo);
        assertEquals("Expected lower damage",30,Castillo.getDamage(),0);
    }

    @Test
    public void receivedamagefromArcher() {
        Infante.SetAttack(100);
        Infante.attack(Castillo);
        assertEquals("Expected lower damage",30,Castillo.getDamage(),0);
    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetAttack(100);
        Caballo.attack(Castillo);
        assertEquals("Expected lower damage",30,Castillo.getDamage(),0);
    }

    @Test
    public void receivedamagefromCastle() {
        Castillo.SetAttack(100);
        Castillo.attack(Castillo2);
        assertEquals("Expected lower damage",10,Castillo2.getDamage(),0);
    }

    @Test
    public void receivedamagefromVillager() {
        Aldeano.SetAttack(100);
        Aldeano.attack(Castillo);
        assertEquals("Expected lower damage",-30,Castillo.getDamage(),0);
        Castillo.SetHp(hp);
        Castillo.SetDamage(hp);
        Aldeano.attack(Castillo);
        assertEquals("Expects no change in damage as castle is dead, Villager cant revive",hp,Castillo.getDamage(),0);

    }

    @Test
    public void receivedamagefromSiege() {
        Asedio.SetAttack(100);
        Asedio.attack(Castillo);
        assertEquals("Expected higher damage",200,Castillo.getDamage(),0);
    }
}