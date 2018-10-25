package Tarea1;

public interface Attackable {
    public void receivedamagefromInfantry(Infantry U);
    public void receivedamagefromArcher(Archer U);
    public void receivedamagefromCavalry(Cavalry U);
    public void receivedamagefromVillager(Villager U);
    public void receivedamagefromSiege(Siege U);
    public void receivedamagefromCastle(Castle U);

}
