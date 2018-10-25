package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarrackTest {


    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Aldeano,Asedio,Caballo;
    private Building Castillo,Castillo2,Barraca;

    @Before
    public void setUp() throws Exception {
        Barraca = new Barrack();
        Castillo2= new Castle();
        Castillo = new Castle();
        Caballo = new Cavalry();
        Asedio = new Siege();
        Infante = new Infantry();
        Arquero = new Archer();
        Aldeano = new Villager();
        type="Barrack";
        hp=200;
        damage=0;
    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Barraca.SetHp(0);
        assertFalse("Expects Unit dead",Barraca.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Barraca.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Infante.getStatus());
        Barraca.SetAttack(100);
        Barraca.attack(Aldeano);
        Barraca.attack(Castillo);
        assertEquals("Expects no damage,Barrack unit cant attack",0,Aldeano.getDamage(),0);
        assertEquals("Expects no damage,Barrack unit cant attack",0,Castillo.getDamage(),0);
    }
    //Repara la unidad
    @Test
    public void receivedamagefromVillager() {
        Aldeano.SetAttack(100);
        Aldeano.attack(Barraca);
        assertEquals("Expected repair the damage",-70,Barraca.getDamage(),0);
        Barraca.SetHp(4000);
        Aldeano.attack(Barraca);
        assertEquals("Expected final hp as hp of Barrack is 4000",4000,Barraca.getHP(),0);
    }

    @Test
    public void receivedamagefromInfantry() {
        Infante.SetAttack(100);
        Infante.attack(Barraca);
        assertEquals("Expected lower damage",70,Barraca.getDamage(),0);

    }

    @Test
    public void receivedamagefromArcher() {
        Arquero.SetAttack(100);
        Arquero.attack(Barraca);
        assertEquals("Expected equal damage from building unit",70,Barraca.getDamage(),0);

    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetAttack(100);
        Caballo.attack(Barraca);
    assertEquals("Expected equal damage from building unit",70,Barraca.getDamage(),0);

    }

    @Test
    public void receivedamagefromSiege() {
        Asedio.SetAttack(100);
        Asedio.attack(Barraca);
        assertEquals("Expected higher damage from building unit",200,Barraca.getDamage(),0);
    }

    @Test
    public void receivedamagefromCastle() {
        Castillo.SetAttack(100);
        Castillo.attack(Barraca);
        assertEquals("Expected equal damage from building unit",70,Barraca.getDamage(),0);
    }
}