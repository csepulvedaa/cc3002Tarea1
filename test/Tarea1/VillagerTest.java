package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VillagerTest {

    private String type;
    private double hp ,attack,damage;
    private Unit Infante, Arquero,Asedio,Caballo,Aldeano;

    @Before
    public void setUp() throws Exception {
        Aldeano = new Villager();
        Caballo = new Cavalry();
        Infante = new Infantry();
        Arquero = new Archer();
        Asedio = new Siege();
        type="Villager";
        hp=100;
        attack=50;
        damage=0;
    }
    @Test
    public void testGetSet(){
        Aldeano.SetStatus(true);
        assertTrue("Estado vivo",Aldeano.getStatus());
        Aldeano.SetType(type);
        assertEquals("Tipo infate",Aldeano.type,type);
        Aldeano.SetAttack(attack);
        assertEquals("Igual ataque",Aldeano.attack,attack,0);

    }
    @Test
    public void testStatus(){
        //iguala hp al daño, condicion de debilitar unidad
        Aldeano.SetHp(damage);
        assertFalse("Expects Unit dead",Aldeano.getStatus());
        //Setea HP>DAMAGE, Unidad esta vivas
        Aldeano.SetHp(hp);
        assertTrue("Expects Unit Alive (hp>damage)",Aldeano.getStatus());
        Aldeano.SetHp(0);
        Aldeano.attack(Infante);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Infante.getDamage(),0);
        Aldeano.SetHp(hp);
        Aldeano.SetDamage(hp);
        Aldeano.attack(Infante);
        assertEquals("Expects no damage,Fainted unit cant attack",0,Infante.getDamage(),0);
    }

    @Test
    public void receivedamagefromInfantry() {
        Infante.SetAttack(30);
        Infante.attack(Aldeano);
        assertEquals("Expect higher damage",45,Aldeano.getDamage(),0);

    }

    @Test
    public void receivedamagefromArcher() {
        Arquero.SetAttack(30);
        Arquero.attack(Aldeano);
        assertEquals("Expect higher damage",45,Aldeano.getDamage(),0);

    }

    @Test
    public void receivedamagefromCavalry() {
        Caballo.SetAttack(30);
        Caballo.attack(Aldeano);
        assertEquals("Expect higher damage",45,Aldeano.getDamage(),0);

    }

    @Test
    public void receivedamagefromSiege() {

        Asedio.SetAttack(30);
        Asedio.attack(Aldeano);
        assertEquals("Expect higher damage",45,Aldeano.getDamage(),0);
    }
}