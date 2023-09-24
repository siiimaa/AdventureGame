import java.util.Scanner;

public class Player {
    Scanner inp = new Scanner(System.in);

    private int damage, health, ballance, originalHealth;
    private String name, charName;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        System.out.println("-------------------------");
        GameCharacter[] charList = { new Samurai(), new Archer(), new TheKnight() };
        for (GameCharacter gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() +
                    "\t Character : " + gameChar.getName() +
                    "\t\t Damage : " + gameChar.getDamage() +
                    "\t\t Health : " + gameChar.getHealth() +
                    "\t\t Ballance : " + gameChar.getBallance());
        }
        System.out.println("-------------------------");

        System.out.print("Please enter your select : ");
        int selectedChar = inp.nextInt();
        System.out.println();

        switch (selectedChar) {
            case 1:
                initPlayer(new Samurai());
                System.out.println("You selected Samurai.");
                System.out.println();
                break;

            case 2:
                initPlayer(new Archer());
                System.out.println("You selected Archer.");
                System.out.println();
                break;

            case 3:
                initPlayer(new TheKnight());
                System.out.println("You selected The Knight.");
                System.out.println();
                break;

            default:
                initPlayer(new Samurai());
                System.out.println("You selected Samurai.");
                System.out.println();
                break;
        }
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setBallance(gameCharacter.getBallance());
        this.setCharName(gameCharacter.getName());
    }

    public void printPlayerInfo() {
        System.out.println("Your Weapon : " + this.getInventory().getWeapon().getNameOfWeapon() +
                "\nYour Armor : " + this.getInventory().getArmors().getNameOfArmor() +
                "\nYour Protection : " + this.getInventory().getArmors().getArmorBlock() +
                "\nYour Damage : " + this.getTotalDamage() +
                "\nYour Health : " + this.getHealth() +
                "\nYour Ballance : " + this.getBallance());
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getWeapon().getWeaponDamage();
    }

    // get/set
    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        } 
        this.health = health;
    }

    public int getBallance() {
        return this.ballance;
    }
    public void setBallance(int ballance) {
        this.ballance = ballance;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return this.charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return this.originalHealth;
    }
    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

}