public class Rules extends SafeLocation {

    public Rules(Player player) {
        super(player, "Rules");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("####################\tRules\t####################  \n");
        System.out.println("Rule number 1 : " +
                           "In order to finish the game, you must destroy all the enemies in the war zone " +
                           "and get the region-specific reward. " +
                           "\nRegional awards : \nCave\t=> Food \nForest\t=> Wood \nRiver\t=> Water.\n" +
                           "You can't re-enter the section where you won the prize.\n");

        System.out.println("Rule number 2 : Your life is restored when you return Safe House.\n");

        System.out.println("Rule number 3 : When you destroy all of your enemies in the Mine Zone, " +
                           "you can earn a certain reward (such as armor, weapons, or money). " +
                           "You may not win anything either. " +
                           "You can reach this area as much as you want.\n");

        System.out.println("Rule number 4 : You will receive a cash reward for every enemy you kill.\n");

        System.out.println("You can buy the items you need in the Tool Store.\n" +
                           "You can access the items in your inventory from My Inventory.");

        System.out.println();
        return true;
    }
}
