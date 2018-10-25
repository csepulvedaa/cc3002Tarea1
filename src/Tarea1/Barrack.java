package Tarea1;

public class Barrack extends Building implements Attackable{
    public Barrack() {
        super();
        this.type = "Barrack";
        this.hp=500;
    }
    @Override
    //Repara mas de lo normal
    public void receivedamagefromVillager(Villager U){
        this.hp+=U.getAttack()*0.7;
    }
}
