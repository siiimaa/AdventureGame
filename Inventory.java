public class Inventory {
    private Weapons weapon;
    private Armors armor;
    private String food;
    private String fireWood;
    private String water;

    public Inventory(){
        this.weapon = new Weapons("Thump", -1, 0, 0);
        this.armor = new Armors("Null", -1, 0, 0);  
        this.food = " ";
        this.fireWood = " ";
        this.water = " ";
            
    }

    public Weapons getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapons weapon){
        this.weapon = weapon;
    }

    public Armors getArmors(){
        return armor;
    }
    public void setArmors(Armors armor){
        this.armor = armor;
    }

    public String getFood(){
        return this.food;
    }
    public void setFood(String food){
        this.food = food;
    }

    public String getFireWood(){
        return this.fireWood;
    }
    public void setFirewood(String fireWood){
        this.fireWood = fireWood;
    }

    public String getWater(){
        return this.water;
    }
    public void setWater(String water){
        this.water = water;
    }
}
