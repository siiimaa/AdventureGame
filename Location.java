import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String nameOfLocation;

    protected Scanner inp = new Scanner(System.in);

    public abstract boolean onLocation();

    public Location(Player player, String nameOfLocation){
        this.player = player;
        this.nameOfLocation = nameOfLocation;
    }

    public Player getPlayer (){
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }

    public String getNameOfLocation(){
        return nameOfLocation;
    }
    public void setNameOfLocation(String nameOfLocation){
        this.nameOfLocation = nameOfLocation;
    }
}