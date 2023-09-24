import java.util.Random;

public abstract class BattleLocation extends Location {
    private Enemy enemy;
    private String award;
    private int maxEnemy;

    public BattleLocation(Player player, String name, Enemy enemy, String award, int maxEnemy) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemy = maxEnemy;
    }

    @Override
    public boolean onLocation() {
        int enemyCount = this.randomNumberOfEnemies();
        
        System.out.println("\nYou are in the " + this.getNameOfLocation() + " now.");
        System.out.println("Be careful! You may encounter " + enemyCount +
                " " + this.getEnemy().getNameOfEnemy() + ".\n");

        System.out.println("\nIf you want to fight, press <F>. If you want to escape, press <E>.");
        String select = inp.nextLine().toUpperCase();

///////////// F veya E girene kadar tekrar değer isteyecek
        while(!(select.equals("E")) && !(select.equals("F"))){
            System.out.println("\nIf you want to fight, press <F>. If you want to escape, press <E>.");
            select = inp.nextLine().toUpperCase();

            if(!(select.equals("E")) && !(select.equals("F"))){
                System.out.println("incorrect value. try again");
            }
        }


        if (select.equals("F") && combat(enemyCount)) {
                System.out.println();
                System.out.println("You have defeated all the enemies in the " + this.getNameOfLocation());
                System.out.println();
                return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You dead!");
            return false;
        }
        return true;
    }

    public boolean combat(int enemyCount) {
        Random rand = new Random();
        for (int i = 1; i <= enemyCount; i++) {
            this.getEnemy().setHealth(this.getEnemy().getDefaultHealth());
            playerStat();
            enemyStat(i);
            // ilk kimin vuracağı belirleniyor
            boolean playerHits = rand.nextBoolean();
            // ilk oyuncu vuruyor
            if (playerHits) {
                while ((this.getPlayer().getHealth() > 0) && (this.getEnemy().getHealth() > 0)) {
                    System.out.println("<F>ight or <E>scape");
                    String selectCombat = inp.nextLine().toUpperCase();
///////////// F veya E girene kadar tekrar değer isteyecek
                    while (!selectCombat.equals("F") && !selectCombat.equals("E")) {
                        System.out.println("<F>ight or <E>scape");
                        selectCombat = inp.nextLine().toUpperCase();
                        
                        if (!selectCombat.equals("F") && !selectCombat.equals("E")) {
                            System.out.println("Incorrect value! Please try again.");
                        }
                    }

                    if (selectCombat.equals("F")) {
                        System.out.println("#####You shot!#####");
                        this.getEnemy().setHealth(this.enemy.getHealth() - this.getPlayer().getTotalDamage());
                        if (this.getEnemy().getHealth() > 0) {
                            System.out.println("#####The monster hit you!#####");
                            int monsterDamage = this.getEnemy().getDamage() -
                                    this.getPlayer().getInventory().getArmors().getArmorBlock();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }

                // ilk canavar vuruyor
            } else {
                while ((this.getPlayer().getHealth() > 0) && (this.getEnemy().getHealth() > 0)) {
                    System.out.println("<F>ight or <E>scape");
                    String selectCombat = inp.nextLine().toUpperCase();
///////////////F veya E girene kadar tekrar değer isteyecek
                    while (!selectCombat.equals("F") && !selectCombat.equals("E")) {
                        System.out.println("<F>ight or <E>scape");
                        selectCombat = inp.nextLine().toUpperCase();
                        
                        if (!selectCombat.equals("F") && !selectCombat.equals("E")) {
                            System.out.println("Incorrect value! Please try again.");
                        }
                    }
                    if (this.getEnemy().getHealth() > 0) {
                        System.out.println("#####The monster hit you!#####");
                        int monsterDamage = this.getEnemy().getDamage() -
                                this.getPlayer().getInventory().getArmors().getArmorBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    }
                    if (selectCombat.equals("F")) {
                        System.out.println("#####You shot!#####");
                        this.getEnemy().setHealth(this.enemy.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                    } else {
                        return false;
                    }
                }
            }
        
            if (this.getEnemy().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You Win!!!");
                System.out.println("You have won " + this.getEnemy().getAwardMoney() + " coin.");
                this.getPlayer().setBallance(this.getPlayer().getBallance() + this.getEnemy().getAwardMoney());
                System.out.println("Your ballance : " + this.getPlayer().getBallance());
            } else {
                return false;
            }
        } 
        if(getNameOfLocation() == "Mine"){
            snakeAwards();
        }else{
            locationAwards();
        }

        return true;
    }

    // kazandığımız eşyalar
    public boolean locationAwards() {
        if (this.getPlayer().getHealth() != 0 && this.getEnemy().getHealth() == 0) {
            if (this.getNameOfLocation().equals("Cave")) {
                System.out.println("You have received a reward : " + this.getAward());
                this.getPlayer().getInventory().setFood(this.award);
            } else if (this.getNameOfLocation().equals("Forest")) {
                System.out.println("You have received a reward : " + this.getAward());
                this.getPlayer().getInventory().setFirewood(this.award);
            } else if (this.getNameOfLocation().equals("The River")) {
                System.out.println("You have received a reward : " + this.getAward());
                this.getPlayer().getInventory().setWater(this.award);
            } else {
                return false;
            }
        }
        return false;
    }

/////son bölümde (mağra) yılanla olan savaşlardan sonra kazanılan eşyalar
    public void snakeAwards(){
        int randomAward1 = (int)(Math.random() * 101);
        int randomAward2 = (int)(Math.random() * 101);
        int randomAward3 = (int)(Math.random() * 101);

        if(randomAward1 <= 15){
            if(randomAward2 <= 50){
                if(randomAward3 > 60){
                    if(this.getPlayer().getInventory().getWeapon().getWeaponId() == 3){
                    System.out.println("//" + this.getPlayer().getInventory().getWeapon().getNameOfWeapon() + "//");
                    System.out.println("You already have this weapon.");
                    }else{
                        this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(3));
                        System.out.println("You won a Musket!");
                    }
                }else if(randomAward3 <= 60){
                    if(this.getPlayer().getInventory().getWeapon().getWeaponId() == 2){
                    System.out.println("//" + this.getPlayer().getInventory().getWeapon().getNameOfWeapon() + "//");
                    System.out.println("You already have this weapon.");
                    }else{
                        if(this.getPlayer().getInventory().getWeapon().getWeaponDamage() < 3){
                        this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(2));
                        System.out.println("You won a Sword!");
                        }else{
                            System.out.println("//" + this.getPlayer().getInventory().getWeapon().getNameOfWeapon() + "//");
                            System.out.println("Your weapon is more powerful! You don't need this weapon.");
                        }
                    }
                }
            }else{
                if(this.getPlayer().getInventory().getWeapon().getWeaponDamage() < 1){
                    this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(1));
                    System.out.println("You won a Gun!");
                }else{
                    System.out.println("//" + this.getPlayer().getInventory().getWeapon().getNameOfWeapon() + "//");
                    System.out.println("Your weapon is more powerful. You don't need this weapon.");
                }
            }
        }else if(randomAward1 > 15 && randomAward1 <= 30){
            if(randomAward2 <= 50){
                if(randomAward3 > 60){
                    if(this.getPlayer().getInventory().getArmors().getArmorId() == 3){
                        System.out.println("//" + this.getPlayer().getInventory().getArmors().getNameOfArmor() + "//");
                        System.out.println("You already have this armor.");
                    }else{
                        this.getPlayer().getInventory().setArmors(Armors.getArmorObjById(3));;
                        System.out.println("You won a Strong Armor!");
                    }
                    
                }else if(randomAward3 <= 60){
                    if(this.getPlayer().getInventory().getArmors().getArmorBlock() < 3){
                        this.getPlayer().getInventory().setArmors(Armors.getArmorObjById(2));
                        System.out.println("You won a Middle Armor!");
                    }else if(this.getPlayer().getInventory().getArmors().getArmorId() == 2){
                        System.out.println("//" + this.getPlayer().getInventory().getArmors().getNameOfArmor() + "//");
                        System.out.println("You already have this armor.");
                    }else{
                        System.out.println("//" + this.getPlayer().getInventory().getArmors().getNameOfArmor() + "//");
                        System.out.println("Your armor is more powerfull! You don't need this armor.");
                    }
                }
            }else{
                if(this.getPlayer().getInventory().getArmors().getArmorId() == 1){
                    System.out.println("//" + this.getPlayer().getInventory().getArmors().getNameOfArmor() + "//");
                    System.out.println("You already have this armor.");
                }else if(this.getPlayer().getInventory().getArmors().getArmorBlock() < 1){
                    this.getPlayer().getInventory().setArmors(Armors.getArmorObjById(1));
                        System.out.println("You won a Light Armor!");
                }else{
                    System.out.println("//" + this.getPlayer().getInventory().getArmors().getNameOfArmor() + "//");
                    System.out.println("Your armor is more powerfull! You don't need this armor.");
                }
            }
        }else if(randomAward1 > 30 && randomAward1 <= 55){
            if(randomAward2 <= 50){
                if(randomAward3 > 60){
                    this.getPlayer().setBallance(this.getPlayer().getBallance() + 10);
                    System.out.println("You won 10 coin!");
                }else if(randomAward3 <= 60){
                    this.getPlayer().setBallance(this.getPlayer().getBallance() + 5);
                    System.out.println("You won 5 coin!");
                }
            }else if(randomAward2 > 50){
                this.getPlayer().setBallance(this.getPlayer().getBallance() + 1);
                System.out.println("You won 1 coin!");
            }
        }else if(randomAward1 > 55){
            System.out.println("You did not win a prize.");
        }
    }
/////vuruştan sonnra oyuncunun ve düşmanın kalan canını gösteren metot
    public void afterHit() {
        System.out.println("\n-------------------");
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println("Monsters Health : " + this.getEnemy().getHealth());
        System.out.println("-------------------\n");
    }

    public void playerStat() {
        System.out.println("\n-----------------------");
        System.out.println("Player values ");
        System.out.println("-----------------------");
        System.out.println("Your weapon : " + this.getPlayer().getInventory().getWeapon().getNameOfWeapon());
        System.out.println("Your armor : " + this.getPlayer().getInventory().getArmors().getNameOfArmor());
        System.out.println("Your block : " + this.getPlayer().getInventory().getArmors().getArmorBlock());
        System.out.println("Your damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Your health : " + this.getPlayer().getHealth());
        System.out.println("Your ballance : " + this.getPlayer().getBallance());

    }

    public void enemyStat(int i) {
        System.out.println("\n-----------------------");
        System.out.println("Your " + i + ". opponent's values");
        System.out.println("-----------------------");
        System.out.println("Damage : " + this.getEnemy().getDamage());
        System.out.println("Health : " + this.getEnemy().getHealth());
        System.out.println("Prize money : " + this.getEnemy().getAwardMoney());
    }

    public int randomNumberOfEnemies() {
        Random r = new Random();
        return r.nextInt(this.getMaxEnemy()) + 1;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }
}