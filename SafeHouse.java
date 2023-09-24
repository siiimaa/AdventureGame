public class SafeHouse extends SafeLocation{

    public SafeHouse(Player play){
        super(play, "Safe House.");
    }

    @Override
    public boolean onLocation(){
        System.out.println();
        System.out.println("You are in a safe house.");
        System.out.println("Your life is restored");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println();
        return true;
    }
    
}