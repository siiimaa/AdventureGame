import java.util.Scanner;

public class Game {
    Scanner inp = new Scanner(System.in);

    public void start() {
        System.out.println("\nWelcome to the adventure game!\n");
        System.out.print("Please enter your name : ");
        String playerName = inp.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName() + "!");
        System.out.println("Please select a character to start the game : ");
        player.selectChar();

        Location location = null;

        while (true) {
            player.printPlayerInfo();
            if (!player.getInventory().getFood().equals("Food") ||
                    !player.getInventory().getFireWood().equals("Firewood") ||
                    !player.getInventory().getWater().equals("Water")) {

                System.out.println("-------------------------\n");
                System.out.println("Loations : \n\n1\tRules. \n2\tSafe house. \n3\tTool Store. \n4\tInventory." +
                        "\n5\tCave. \n6\tForest. \n7\tThe River. \n8\tMine. \n0\tLeave.\n");
                System.out.print("Please select location : ");
                int selectLoc = inp.nextInt();

                switch (selectLoc) {
                    case 0:
                        location = null;
                        break;

                    case 1:
                        location = new Rules(player);
                        break;

                    case 2:
                        location = new SafeHouse(player);
                        break;

                    case 3:
                        location = new ToolStore(player);
                        break;

                    case 4:
                        location = new MyInventory(player);
                        break;

                    case 5:
                        if (!player.getInventory().getFood().equals("Food")) {
                            location = new Cave(player);
                        } else {
                            System.out.println("You have already passed this level. You are redirected to Safe House");
                            location = new SafeHouse(player);
                        }
                        break;

                    case 6:
                        if (!player.getInventory().getFireWood().equals("Firewood")) {
                            location = new Forest(player);
                        } else {
                            System.out.println("You have already passed this level. You are redirected to Safe House");
                            location = new SafeHouse(player);
                        }
                        break;

                    case 7:
                        if (!player.getInventory().getWater().equals("Water")) {
                            location = new TheRiver(player);
                        } else {
                            System.out.println("You have already passed this level. You are redirected to Safe House");
                            location = new SafeHouse(player);
                        }
                        break;

                    case 8:
                        location = new Mine(player);
                        break;

                    default:
                        System.out.println("Incorrect value! Try again : ");
                        location = new SafeHouse(player);
                        break;
                }
            } else {
                System.out.println("You Win!");
                break;
            }
            if (location == null) {
                System.out.println("Game Over. See You Again!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }

        }
    }

}