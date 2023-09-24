public class Snake extends Enemy {
    public Snake (){
        super(4, "Snake", generateRandomDamage(), 12, 0);
        
    }

    private static int generateRandomDamage(){
        int damageOfSnake = (int)(Math.random() * 4) + 3;
        return damageOfSnake;
    }

}
