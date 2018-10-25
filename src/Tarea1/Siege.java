package Tarea1;
/**
 * Clase siege que extiende la clase Unit, la cual es una unidad de tipo siege
 * Implementa interfaz Attacker
 * @author csepu
 * @version Octubre 2018
 */
public class Siege extends Unit implements Attacker {
    public Siege(){
        super();
        this.type="Siege";}

    @Override
    public void attack(Unit U){
        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromSiege(this);}}

     //Ataca más a siege que ataque normal
    @Override
    public void receivedamagefromInfantry(Infantry U){

        this.damage+=(U.getAttack()*1.2);
    }
    @Override
    public void receivedamagefromCavalry(Cavalry U){

        this.damage+=(U.getAttack()*1.2);
    }
    public void receivedamagefromSiege(Siege U){
        this.damage+=(U.getAttack()*1.5);
    }
    //Ataca menos a siege que ataque normal
    @Override
    public void receivedamagefromArcher(Archer U){

        this.damage+=(U.getAttack()*0.8);
    }
    // Aldeano repara la unidad

    @Override
    public void receivedamagefromVillager(Villager U ){
        this.hp+=(U.getAttack()*0.5);
    }
    //Monje no hace daño a barraca
    @Override
    public void receivedamagefromMonk(Monk M ){
        System.out.println("Wololo");
    }

}




