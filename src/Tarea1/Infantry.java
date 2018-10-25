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


    //Ataque por 1.2
    @Override
    /**
     * Override del método recievedamage from Siege
     * Siege multiplica el daño x1.5
     */
    public void recievedamagefromSiege(Unit U){
        double atck=U.getAttack();
        this.SetDamage(atck);
    }
    public void recievedamagefromArcher(Unit U){

        this.SetDamage(U.getAttack()); }
    //Ataque por 0.8

    @Override
    /**
     * Override para el villager damage= ataque villager* 0.8
     *
     */
    public void recievedamagefromVillager(Unit U){
        double atck=U.getAttack();
        this.SetDamage(atck);}
    @Override
    /**
     * Override para el monje, recibe hp = ataque monje * 0.8
     */
    public void recievedamagefromMonk(Unit U){
        double atck=U.getAttack();
        this.SetHp(atck*0.5);}
}