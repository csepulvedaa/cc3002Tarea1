package Tarea1;

public interface Attacker extends Attackable{
    public void attack(Unit u);
    public void receivedamagefromInfantry(Infantry U);
    public void receivedamagefromArcher(Archer U);
    public void receivedamagefromCavalry(Cavalry U);
    public void receivedamagefromMonk(Monk U);
    public void receivedamagefromVillager(Villager U);
    public void receivedamagefromSiege(Siege U);
    public void receivedamagefromCastle(Castle U);

}
