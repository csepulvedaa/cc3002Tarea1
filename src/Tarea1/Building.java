package Tarea1;

public abstract class Building implements Attackable{
    protected String type; //tipo de unidad
    protected double attack; //ataque
    protected double hp; //hp o puntos de vida
    protected double damage;// contador de daño recibido
    protected boolean status; //Estado de la unidad
    protected double maxhp;//hpmaximo
    public Building (){
        this.type="Building";
        this.attack=0;
        this.damage=0;
        this.status=true;
        this.maxhp=4000;
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
    void SetDamage(double damage){
        this.damage=damage;
    }
    void SetStatus(boolean estado){
        this.status=estado;
    }

    //Getter/

    protected double getDamage(){
        return this.damage;
    }
    protected double getAttack(){
        return attack;
    }
    /**
     * Getter, entrega el hp de la unidad
     * @return
     */
    double getHP(){
        return hp;
    }
    double getMaxhp(){
        return maxhp;
    }

    boolean getStatus(){

        if (this.hp<=this.damage){
            this.status=false;
            return status;}
        else  {
            this.status=true;
            return status;
    }}

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
        if (this.hp<=this.damage){
            System.out.println("Unidad muerta, no puede ser revivida Hp"+this.hp+"Daño "+this.damage);
        }
        else{
            this.damage-=U.attack*0.3;}

    }

    public void receivedamagefromSiege(Siege U){
        this.damage+=U.attack*2;
    }

    public void receivedamagefromCastle(Castle B){
        this.damage=+B.attack*0.7;
    }


    public  void attack(Unit U){
        System.out.println("Unidad del tipo "+this.type+" cant attack");
    }
    public  void attack(Building B){
        System.out.println("Unidad del tipo "+this.type+" cant attack");
    }
}
