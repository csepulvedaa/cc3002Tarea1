package Tarea1;
/**
 * Intefaz base para la interacción entre distintos tipos de entidad Attacker
 * Cada método hace referencia a recibir daño de una Unidad O Building
 * Esta interfaz es implementada por el tipo abstracto Unit
 * @author csepu
 * @version Octubre 2018
 */

public interface Attacker extends Attackable{
    /**
     * Metodo para atacar cualquier unidad, se recibe el daño segun la unidad recibida
     * @param u: unidad de destino
     */
    public void attack(Unit u);
    /**
     * Asigna el daño recibido de  una unidad del tipo Infantry
     * @param U: Unidad de tipo Infantry
     */
    public void receivedamagefromInfantry(Infantry U);
    /**
     * Asigna el daño recibido de  una unidad del tipo Archer
     * @param U: Unidad de tipo Archer
     */
    public void receivedamagefromArcher(Archer U);
    /**
     * Asigna el daño recibido de  una unidad del tipo Infantry
     * @param U: Unidad de tipo Cavalry
     */
    public void receivedamagefromCavalry(Cavalry U);
    /**
     * Asigna el daño quitado de  una unidad del tipo Monk
     * @param U: Unidad de tipo Monk
     */
    public void receivedamagefromMonk(Monk U);
    /**
     * Asigna el daño recibido de  una unidad del tipo Villager
     * @param U: Unidad de tipo Villager
     */
    public void receivedamagefromVillager(Villager U);

    /**
     * Asigna el daño recibido de una unidad del tipo Siege
     * @param U : Unidad de tipo Siege
     */
    public void receivedamagefromSiege(Siege U);
    /**
     * Asigna el daño recibido a un Building de tipo Castle
     * @param B : Building de tipo Castle
     */
    public void receivedamagefromCastle(Castle B);

}
