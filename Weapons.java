public class Weapons {
    private String nameOfWeapon;
    private int weaponId, weaponDamage, weaponPrice;
    
    public Weapons(String nameOfWeapon, int weaponId, int weaponDamage, int weaponPrice){
        this.nameOfWeapon = nameOfWeapon;
        this.weaponId = weaponId;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    } 

    public static Weapons[] weapons(){
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons("Gun",1, 2, 15);
        weaponList[1] = new Weapons("Sword",2, 3, 20);
        weaponList[2] = new Weapons("Musket",3, 7, 25);
        return weaponList;
    }

    public static Weapons getWeaponObjById(int weapId){
        for(Weapons w : Weapons.weapons()){
            if(w.getWeaponId() == weapId){
                return w;
            }
        }
        return null;
    }
    
    public String getNameOfWeapon(){
        return this.nameOfWeapon;
    }
    public void setNameOfWeapon(String nameOfWeapon){
        this.nameOfWeapon = nameOfWeapon;
    }

    public int getWeaponId (){
        return weaponId;
    }
    public void setWeaponId(int weaponId){
        this.weaponId = weaponId;
    }

    public int getWeaponDamage(){
        return this.weaponDamage;
    }
    public void setWeaponDamage(int weaponDamage){
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice(){
        return weaponPrice;
    }
    public void setWeaponPrice(int weaponPrice){
        this.weaponPrice = weaponPrice;
    }
}