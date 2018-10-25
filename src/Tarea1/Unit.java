package Tarea1;

public abstract class Unit implements Attacker {
    protected String type; //tipo de unidad
    protected double attack; //ataque
    protected double hp; //hp o puntos de vida
    protected double damage;// contador de daño recibido
    protected boolean status; //Estado de la unidad
    //METODOS
    public Unit (){
        this.type="unit";
        this.attack=200;
        this.hp=200;
        this.damage=0;
        this.status=true;
    }

    public  void SetHp(double i){
        this.hp=i;
    }
    public void SetType(String Type){
        this.type=Type;
    }

    public void SetAttack(double Attack){
        this.attack=Attack;
    }
    public void SetStatus(boolean estado){
        this.status=estado;
    }

    //Getter/

    public double getDamage(){
        return this.damage;
    }
    public double getAttack(){
        return attack;
    }
    /**
     * Getter, entrega el hp de la unidad
     * @return
     */
    public double getHP(){
        return hp;
    }
    //metodo para atacar por defecto
    public void attack(Unit U) { this.damage+=U.attack;}

    public  boolean getStatus(){
        if (this.hp<=this.damage){
            this.status=false;
            return status;}
            else{
                this.status=true;
                return status;}};


    public void receivedamagefromInfantry(Infantry U)
    {
        this.damage+=U.attack;
    }
    public void receivedamagefromArcher(Archer U){
        this.damage+=U.attack;

    }
    public void receivedamagefromCavalry(Cavalry U){

        this.damage+=U.attack;
    }
    public void receivedamagefromMonk(Monk U){
        this.hp+=U.attack*0.5;}
    public void receivedamagefromVillager(Villager U){
        this.damage+=U.attack;}
    public void receivedamagefromSiege(Siege U){
        this.damage+=U.attack;}




}
