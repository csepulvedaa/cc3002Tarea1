package Tarea1;

public class Monk extends Unit implements Attacker {
    public Monk(){
        this.type="Monk";
    }
    public void attack(Unit U){
        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromMonk(this);}
    }
    @Override
    public void attack(Building B){

        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{System.out.println("Wololo");;}
    }
    @Override
    public void receivedamagefromInfantry(Infantry U){
        this.damage=this.hp;
        this.status=false;
    }
    @Override
    public void receivedamagefromArcher(Archer U){
        this.damage=this.hp;
        this.status=false;

    }

    @Override
    public void receivedamagefromCavalry(Cavalry U) {
        this.damage=this.hp;
        this.status=false;
    }
    @Override
    public void receivedamagefromSiege(Siege u){
        this.damage=this.hp;
        this.status=false;
    }



}
