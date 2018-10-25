package Tarea1;

import javafx.scene.shape.Arc;

/**
 * Clase Archer, extends Unit abstract class la cual es una unidad de tipo archer
 * Impements Interface Attacker
 * @version Octubre 2018
 * @author csepu
 *
 */

public class Archer extends Unit implements Attacker {
    public  Archer(){
        super();
        this.type="Archer";
    }
    //Override para atacar de Archer, si esta vivo ataca
    @Override
    public void attack(Unit u){

        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{u.receivedamagefromArcher(this);}}

    //Ataca mas a archer que lo normal
    @Override
    public void receivedamagefromInfantry(Infantry U){
        this.damage+=(U.getAttack()*1.2);
    }
    @Override
    public void receivedamagefromArcher(Archer U){
        this.damage+=(U.getAttack()*1.2);
    }
    @Override
    public void receivedamagefromCavalry(Cavalry U){
        this.damage+=(U.getAttack()*1.5);
    }
    @Override
    public void receivedamagefromSiege(Siege U){
        this.damage=(U.getAttack()*1.5);
    }



}
