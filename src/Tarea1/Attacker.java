package Tarea1;

public interface Attacker {
    public void recievedamagefromInfantry(Unit U);
    public void recievedamagefromArcher(Unit U);
    public void recievedamagefromCavalry(Unit U);
    public void recievedamagefromMonk(Unit U);
    public void recievedamagefromVillager(Unit U);
    public void recievedamagefromSiege(Unit U);

}
