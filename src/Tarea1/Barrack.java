package Tarea1;
/**
 * Clase Barrack , extends Building abstract class la cual es una unidad de tipo  Barrack
 * Impements Interface Attackable
 * @version Octubre 2018
 * @author csepu
 *
 */

public class Barrack extends Building implements Attackable{
    public Barrack() {
        super();
        this.type = "Barrack";
        this.hp=500;
    }
    @Override
    //Repara mas de lo normal
    public void receivedamagefromVillager(Villager U){

        if (this.getHP() != this.getMaxhp()) {
            this.damage-=U.getAttack()* 0.7;

        } else {
            this.damage+=U.getAttack()*0;
        }
    }
}
