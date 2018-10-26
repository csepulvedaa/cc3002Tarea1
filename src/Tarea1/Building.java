package Tarea1;

/**Clase constructora base para crear cualquier tipo de Building
 * Se definen los metodos para construir una unidad por defecto
 * @author csepu
 * @version Octubre 2018
 */
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
    /**
     * Asigna el hp que tendra un Building
     * @param i Hp  Building
     */
    void SetHp(double i){
        this.hp=i;
    }
    /**
     * Asigna el tipo que tendra un Building
     * @param Type Tipo del Building
     */
    public void SetType(String Type){
        this.type=Type;
    }
    /**
     * Asigna el Ataque que tendra un Building
     * @param Attack Ataque del Building
     */
    void SetAttack(double Attack){
        this.attack=Attack;
    }
    /**
     * Asigna el Daño que tendrá la unidad
     * @param damage Daño de la unidad
     */
    void SetDamage(double damage){
        this.damage=damage;
    }
    /**
     * Asigna el Estado que tendrá la unidad
     * @param estado   Estado de la unidad
     */
    void SetStatus(boolean estado){
        this.status=estado;
    }

    //Getter/
    /**
     * Entrega el daño recibido
     * @return Daño recibodo
     */
    protected double getDamage(){
        return this.damage;
    }
    /**
     * Entrega el Ataque de la unidad
     * @return Ataque de la unidad
     */
    protected double getAttack(){
        return attack;
    }
    /**
     * Getter, entrega el hp del Building
     * @return
     */
    double getHP(){
        return hp;
    }

    /**Getter
     * entrega el hp maximo del building
     * @return Hp maximo
     */
    double getMaxhp(){
        return maxhp;
    }

    /**
     * Metodo para definir si una Unidad esta viva
     * @return Estado de la unidad
     */
    boolean getStatus(){

        if (this.hp<=this.damage){
            this.status=false;
            return status;}
        else  {
            this.status=true;
            return status;
    }}
    /**
     * Metodo para Recibir daño por defecto de unidad de tipo Infantry
     * @param U: Unidad de tipo Infantry
     */
    public void receivedamagefromInfantry(Infantry U)
    {
        this.damage+=U.attack*0.7;
    }
    /**
     * Metodo para recibir daño por defecto de unidad de tipo Archer
     * @param U: Unidad de tipo Archer
     */
    public void receivedamagefromArcher(Archer U){
        this.damage+=U.attack*0.7;

    }
    /**
     * Metodo para recibir daño por defecto unidad de tipo Cavalry
     * @param U: Unidad de tipo Cavalry
     */
    public void receivedamagefromCavalry(Cavalry U){

        this.damage+=U.attack*0.7;
    }
    /**
     * * Metodo para recibir daño por defecto unidad de tipo Villager
     * @param U: Unidad de tipo Villager
     */
    public void receivedamagefromVillager(Villager U){
        if (this.hp<=this.damage){
            System.out.println("Unidad muerta, no puede ser revivida Hp"+this.hp+"Daño "+this.damage);
        }
        else{
            this.damage-=U.attack*0.3;}

    }
    /**
     * * Metodo para recibir daño por defecto unidad de tipo Siege
     * @param U : Unidad de tipo Siege
     */

    public void receivedamagefromSiege(Siege U){
        this.damage+=U.attack*2;
    }

    /**
     * * Metodo para recibir daño por defecto Building de tipo Castle
     * @param B : Building de tipo Castle
     */
    public void receivedamagefromCastle(Castle B){
        this.damage=+B.attack*0.7;
    }

    /**
     * Metodos para atacar por defecto, que heredan todas las clases de Building
     * Los building no pueden atacar se imprime un mensaje
     * @param U: Unidad que recibe daño
     */
    public  void attack(Unit U){
        System.out.println("Unidad del tipo "+this.type+" cant attack");
    }
    public  void attack(Building B){
        System.out.println("Unidad del tipo "+this.type+" cant attack");
    }
}
