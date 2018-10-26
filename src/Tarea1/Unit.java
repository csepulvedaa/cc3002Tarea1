package Tarea1;

/**Clase constructora base para crear cualquier tipo de Unit
 * Se definen los metodos para construir una unidad por defecto
 * @author csepu
 * @version Octubre 2018
 */

public abstract class Unit implements Attacker {
    protected String type; //tipo de unidad
    protected double attack; //ataque
    protected double hp; //hp o puntos de vida
    protected double damage;// contador de daño recibido
    protected boolean status; //Estado de la unidad
    protected double maxhp;// Valor maximo del estado de la unidad
    //METODOS
    public Unit (){
        this.type="unit";
        this.attack=200;
        this.damage=0;
        this.status=true;
        this.maxhp=this.hp*2;
    }

    /**
     * Asigna el hp que tendra una unidad
     * @param i Hp  la unidad
     */
    void SetHp(double i){
        this.hp=i;
    }

    /**
     * Asigna el tipo que tendra una unidad
     * @param Type Tipo de la unidad
     */
    public void SetType(String Type){
        this.type=Type;
    }

    /**
     * Asigna el Ataque que tendra la unidad
     * @param Attack Ataque de la unidad
     */
    void SetAttack(double Attack){
        this.attack=Attack;
    }

    /**
     * Asigna el Estado que tendrá la unidad
     * @param estado   Estado de la unidad
     */
    void SetStatus(boolean estado){
        this.status=estado;
    }

    /**
     * Asigna el Daño que tendrá la unidad
     * @param damage Daño de la unidad
     */
    void SetDamage(double damage){
        this.damage=damage;
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
     * Getter, entrega el hp de la unidad
     * @return Hp de la unidad
     */
    protected double getHP(){
        return hp;
    }

    /**
     * Metodos para atacar por defecto, que heredan todas las clases de unit
     * Si recibe un daño especial por cada determinada unidad se le sobrescribe en la clase correspondiente
     * (Override)
     * @param U: Unidad que recibe daño
     */
    public void attack(Unit U) {
        this.damage+=U.attack;
    }
    /**
     * Metodos para atacar por defecto, que heredan todas las clases de unit
     * Si recibe un daño especial por cada determinada unidad se le sobrescribe en la clase correspondiente
     * (Override)
     * @param B Building que recibe daño
     */
    public void attack(Building B){
        this.damage+=B.attack;
    }

    /**
     * Metodo para definir si una Unidad esta viva
     * @return Estado de la unidad
     */
    protected boolean getStatus(){
        if ((this.hp<=this.damage) || (this.status=false)){
            this.status=false;
            return status;}
        else{
            this.status=true;
            return status;}

    }

    /**
     * Metodo para Recibir daño por defecto de unidad de tipo Infantry
     * @param U: Unidad de tipo Infantry
     */
    public void receivedamagefromInfantry(Infantry U)
    {
        this.damage+=U.attack;
    }

    /**
     * Metodo para recibir daño por defecto de unidad de tipo Archer
     * @param U: Unidad de tipo Archer
     */
    public void receivedamagefromArcher(Archer U){
        this.damage+=U.attack;

    }

    /**
     * Metodo para recibir daño por defecto unidad de tipo Cavalry
     * @param U: Unidad de tipo Cavalry
     */
    public void receivedamagefromCavalry(Cavalry U){

        this.damage+=U.attack;
    }

    /**
     * * Metodo para recibir curacion por defecto unidad de tipo Monk
     * @param U: Unidad de tipo Monk
     */
    public void receivedamagefromMonk(Monk U){
        if (this.hp<=this.damage){
            System.out.println("Unidad muerta, no puede ser revivida Hp"+this.hp+"Daño "+this.damage);
        }
        else{
        this.damage-=U.attack*0.5;}
    }

    /**
     * * Metodo para recibir daño por defecto unidad de tipo Villager
     * @param U: Unidad de tipo Villager
     */
    public void receivedamagefromVillager(Villager U){
        this.damage+=U.attack;
    }

    /**
     * * Metodo para recibir daño por defecto unidad de tipo Siege
     * @param U : Unidad de tipo Siege
     */
    public void receivedamagefromSiege(Siege U){
        this.damage+=U.attack;
    }

    /**
     * * Metodo para recibir daño por defecto Building de tipo Castle
     * @param B : Building de tipo Castle
     */
    public void receivedamagefromCastle(Castle B){
        this.damage+=B.attack*1.2;
    }






}
