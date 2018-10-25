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
    public void SetDamage(double hit){
        this.damage=hit;
    }
    //Getter/
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
    //metodo para atacar, debo revisar por que uso el ataque
    //mayor a 20
    public void attack(Unit U) {
        if (this.getStatus()==false) {
            System.out.println("Unidad Debilitada,no puede atacar");}
        //si el ataque es menor a 20 no se hace nada(?), por que
        else{this.damage+=U.attack;}}

    public  boolean getStatus(){
        if (this.hp<=this.damage){
            this.status=false;
            return status;}
            else{
                this.status=true;
                return status;}};


    public void recievedamagefromInfantry(Unit U){
        this.damage+=U.attack;
    }
    public void recievedamagefromArcher(Unit U){
        this.damage+=U.attack;

    }
    public void recievedamagefromCavalry(Unit U){

        this.damage+=U.attack;
    }
    public void recievedamagefromMonk(Unit U){
        this.damage+=U.attack;}
    public void recievedamagefromVillager(Unit U){
        this.damage+=U.attack;}
    public void recievedamagefromSiege(Unit U){
        this.damage+=U.attack;}




}
