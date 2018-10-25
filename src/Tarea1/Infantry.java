package Tarea1;

public class Infantry extends Unit implements Attacker {
    /**
     * Crea una unidad de tipo Infantry, establece los mismos valores por defecto que la clase unit
     * Llamada super y modifica el tipo a infantry
     */
    public Infantry() {
        super();
        this.type="Infantry";
    }
    //Override del metodo atacar para ser atacado por Infantry
    //Si la unidad no esta muerta, ataca
    @Override
    public void attack(Unit U){
        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //Si la unidad no esta debilitada ataca
        else{U.receivedamagefromInfantry(this);}
    }

    //Recibe mas daño al ser atacado por alguna de estas clases
    @Override
    public void receivedamagefromSiege(Siege U){
        this.damage=+(U.getAttack()*1.5);
    }
    @Override
    public void receivedamagefromArcher(Archer U){

        this.damage=+(U.getAttack()*1.2); }
     //Ataque por 0.8

    @Override

    public void receivedamagefromVillager(Villager U){
        this.damage=+(U.getAttack()*0.8);}


}