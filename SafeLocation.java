public abstract class SafeLocation extends Location {

    public SafeLocation(Player play, String nameOfLocation){
        super(play, nameOfLocation);
    }

    @Override
    public boolean onLocation(){
        return true;
    }
    
}