package Tarea1;
/**
 * Clase cavalry que extiende la clase Unit, la cual es una unidad de tipo cavalry
 * Implementa interfaz Attacker
 * @author csepu
 * @version Octubre 2018
 */

public class Cavalry extends Unit implements Attacker {
    public Cavalry(){
        super();
        this.type="Cavalry";
        this.hp=200;
    }
    @Override
    public void attack(Unit u){

        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{u.receivedamagefromCavalry(this);}
    }
    @Override
    public void attack(Building B){

        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{B.receivedamagefromCavalry(this);}
    }

    //Ataca mas a un cavalry que lo normal
    @Override
    public void receivedamagefromInfantry(Infantry U){
    this.damage+=U.getAttack()*1.2;
    }
    //Ataca menos a un cavalry que lo normal
    @Override
    public void receivedamagefromVillager(Villager U) {
    this.damage+=U.getAttack()*0.5;
    }


}
