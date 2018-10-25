package Tarea1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfantryTest {
    private String type;
    private double hp ,attack,damage;
    private Unit Infante;
    /**
     * Initialize test case
     */
@Before
    //Start the scenario
    public void Setup(){
    Infante = new Infantry();
    type="Infantry";
    hp=300;
    attack=50;
    damage=0;}
@Test
public void testStatus(){
    //iguala hp al daño, condicion de debilitar unidad
    Infante.SetHp(0);
    assertFalse("Expects Unit dead",Infante.getStatus());
    //Setea HP>DAMAGE, Unidad esta viva
    Infante.SetHp(hp);
    assertTrue("Expects Unit Alive (hp>damage)",Infante.getStatus());
}
}