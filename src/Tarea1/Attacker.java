package Tarea1;

public interface Attacker {
    public void receivedamagefromInfantry(Infantry U);
    public void receivedamagefromArcher(Archer U);
    public void receivedamagefromCavalry(Cavalry U);
    public void receivedamagefromMonk(Monk U);
    public void receivedamagefromVillager(Villager U);
    public void receivedamagefromSiege(Siege U);

}
