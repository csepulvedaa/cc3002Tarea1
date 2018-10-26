package Tarea1;
/**
 * Clase Monk, extends Unit abstract class la cual es una unidad de tipo Monk
 * Impements Interface Attacker
 * @version Octubre 2018
 * @author csepu
 *
 */

public class Monk extends Unit implements Attacker {
    public Monk(){
        this.type="Monk";
        this.hp=50;
    }
    public void attack(Unit U){
        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromMonk(this);}
    }
    @Override
    public void attack(Building B){

        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{System.out.println("Wololo");;}
    }
    @Override
    public void receivedamagefromInfantry(Infantry U){
        double a= this.getHP();
        this.status=false;
        this.damage=a;

    }
    @Override
    public void receivedamagefromArcher(Archer U){
        double a= this.getHP();
        this.status=false;
        this.damage=a;
    }
    @Override
    public void receivedamagefromVillager(Villager U){
        System.out.println("Wololo");
    }

    @Override
    public void receivedamagefromCavalry(Cavalry U) {
        double a= this.getHP();
        this.status=false;
        this.damage=a;
    }
    @Override
    public void receivedamagefromSiege(Siege u){
        double a= this.getHP();
        this.status=false;
        this.damage=a;
    }



}
