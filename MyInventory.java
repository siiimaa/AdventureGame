public class MyInventory extends SafeLocation {
    private String food;
    private String fireWood;
    private String water;

    public MyInventory(Player play){
        super(play, "My Inventory.");
    }

    @Override
    public boolean onLocation(){
        this.food = this.getPlayer().getInventory().getFood();
        this.fireWood = this.getPlayer().getInventory().getFireWood();
        this.water = this.getPlayer().getInventory().getWater();
        System.out.println();
        System.out.println("You are in the inventory.");
        System.out.println("############Your stuff############");
        System.out.println("Your Armor : " + this.getPlayer().getInventory().getArmors().getNameOfArmor());
        System.out.println("Your Weapon : " + this.getPlayer().getInventory().getWeapon().getNameOfWeapon());
        System.out.println("Your Winnings : " + this.food);
        System.out.println("\t\t" + this.fireWood);
        System.out.println("\t\t" + this.water);
                           
        return true;
    }

}

