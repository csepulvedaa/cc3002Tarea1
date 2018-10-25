package Tarea1;

/**
 * Crea un building de tipo Castle
 */

public class Castle extends Building implements Attackable {
    public Castle() {
        super();
        this.type = "Castle";
        this.attack=200;
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
