package Tarea1;

public abstract class Building implements Attackable{
    protected String type; //tipo de unidad
    protected double attack; //ataque
    protected double hp; //hp o puntos de vida
    protected double damage;// contador de daño recibido
    protected boolean status; //Estado de la unidad
    public Building (){
        this.type="Building";
        this.attack=0;
        this.hp=200;
        this.damage=0;
        this.status=true;
    }
    void SetHp(double i){
        this.hp=i;
    }
    public void SetType(String Type){
        this.type=Type;
    }

    void SetAttack(double Attack){
        this.attack=Attack;
    }
    void SetStatus(boolean estado){
        this.status=estado;
    }

    //Getter/

    private double getDamage(){
        return this.damage;
    }
    private double getAttack(){
        return attack;
    }
    /**
     * Getter, entrega el hp de la unidad
     * @return
     */
    double getHP(){
        return hp;
    }

    boolean getStatus(){
        return status;
    };

    public void receivedamagefromInfantry(Infantry U)
    {
        this.damage+=U.attack*0.7;
    }
    public void receivedamagefromArcher(Archer U){
        this.damage+=U.attack*0.7;

    }
    public void receivedamagefromCavalry(Cavalry U){

        this.damage+=U.attack*0.7;
    }

    public void receivedamagefromVillager(Villager U){
        this.hp+=U.attack*0.7;
    }
    public void receivedamagefromSiege(Siege U){
        this.damage+=U.attack;
    }

    public void receivedamagefromCastle(Castle U){}


}
