package Tarea1;
/**
 * Clase Villager, extends Unit abstract class la cual es una unidad de tipo Villager
 * Impements Interface Attacker
 * @version Octubre 2018
 * @author csepu
 *
 */

public class Villager extends Unit implements Attacker {
    public Villager() {
        super();
        this.type = "Villager";
    }
    @Override
    public void attack(Unit U){
        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromVillager(this);}
    }
    //Villager es atacado mas de lo normal por todas las unidades excepto villager
    @Override
    public void receivedamagefromInfantry(Infantry U){
        this.damage+=(U.getAttack()*1.5);
    }
    @Override
    public void receivedamagefromArcher(Archer U){
        this.damage+=(U.getAttack()*1.5);
    }
    @Override
    public void receivedamagefromCavalry(Cavalry U){
        this.damage+=(U.getAttack()*1.5);
    }
    @Override
    public void receivedamagefromSiege(Siege U){
        this.damage+=(U.getAttack()*1.5);
    }




    }

