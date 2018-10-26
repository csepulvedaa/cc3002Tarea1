package Tarea1;
/**
 * Intefaz base para la interacción entre distintos tipos de entidad Attackable
 * Cada método hace referencia a recibir daño de una Unidad O Building
 * Esta interfaz es implementada por el tipo abstracto Building
 * @author csepu
 * @version Octubre 2018
 */
public interface Attackable {
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
