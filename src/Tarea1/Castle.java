package Tarea1;
/**
 * Clase Castle, extends Building abstract class la cual es una unidad de tipo Castle
 * Impements Interface Attackable
 * @version Octubre 2018
 * @author csepu
 *
 */
public class Castle extends Building implements Attackable {
    public Castle() {
        super();
        this.type = "Castle";
        this.attack=200;
        this.hp=1000;
    }
    @Override
    public void attack(Unit U){
        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromCastle(this);}
    }
    @Override
    public void attack(Building B){
        if (!this.getStatus()) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{B.receivedamagefromCastle(this);}
    }

//Atacan menos  a castillo que lo normal de un building //
@Override
    public void receivedamagefromInfantry(Infantry U){
        this.damage+=U.getAttack()*0.3;
}
@Override
    public void receivedamagefromArcher(Archer U){
        this.damage+=U.getAttack()*0.1;
}
@Override
    public void receivedamagefromCavalry(Cavalry U){
        this.damage+=U.getAttack()*0.3;
}
@Override
    public void receivedamagefromCastle(Castle B ){
        this.damage+=B.getAttack()*0.1;
}
}
