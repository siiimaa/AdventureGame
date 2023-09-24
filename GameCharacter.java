public abstract class GameCharacter{
    private int damage, health, ballance, id;
    private String name;

    public GameCharacter(int id, int damage, int health, int ballance, String name){
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.ballance = ballance;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    
    public int getBallance(){
        return this.ballance;
    }
    public void setBallance(int ballance){
        this.ballance = ballance;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
}