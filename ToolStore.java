public class ToolStore extends SafeLocation {

    public ToolStore(Player play) {
        super(play, "Tool Store.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the tool store.");
        System.out.println();
        boolean showMenu = true;
        while(showMenu){
                System.out.println("Operations : \n1\tWeapons. \n2\tArmors. \n0\tLeave.");
            System.out.println();
            System.out.print("Please select an operation : ");
            int selectOperaton = inp.nextInt();
            while (selectOperaton < 0 || selectOperaton > 2) {
                System.out.println("Invalid selection. Please try again : ");
                selectOperaton = inp.nextInt();
            }

            switch (selectOperaton) {
                case 0:
                    System.out.println("See you again!");
                    showMenu = false;
                    return true;

                case 1:
                    printWeapons();
                    buyWeapons();
                    break;

                case 2:
                    printArmors();
                    buyArmors();
                    break;
                
            }
        }
        return true;
    }

    public void printWeapons() {
        System.out.println();
        System.out.println("Weapons : ");
        System.out.println();
        for (Weapons weap : Weapons.weapons()) {
            System.out.println(weap.getWeaponId() + "\t" + weap.getNameOfWeapon() + "\tDamage : " +
                    weap.getWeaponDamage() + "\tPrice : " +
                    weap.getWeaponPrice());
        }
        System.out.println("0\tLeave.");
    }

    public void buyWeapons(){
        System.out.print("Choose a weapon : ");
        int weaponChooseId = inp.nextInt();
        while (weaponChooseId < 0 || weaponChooseId > Weapons.weapons().length) {
            System.out.print("Invalid selection. Please try again : ");
            weaponChooseId = inp.nextInt();
        }

        if(weaponChooseId != 0){
            Weapons selectedWeapon = Weapons.getWeaponObjById(weaponChooseId);

        if(selectedWeapon != null){
                if(selectedWeapon.getWeaponPrice() > this.getPlayer().getBallance()){
                    System.out.println("You don't have enough money!");
                    System.out.println("Your ballance : " + this.getPlayer().getBallance());
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("You bought a " + selectedWeapon.getNameOfWeapon());
                    this.getPlayer().setBallance(this.getPlayer().getBallance() - selectedWeapon.getWeaponPrice());
                    System.out.println("Your ballance : " + this.getPlayer().getBallance());
                    System.out.println();
                    System.out.println("The previous weapon : " + this.getPlayer().getInventory().getWeapon().getNameOfWeapon());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your weapon : " + this.getPlayer().getInventory().getWeapon().getNameOfWeapon());
                    System.out.println();
                
                }
            }
        }
    }

    public void printArmors() {
        System.out.println();
        System.out.println("Armors : ");
        System.out.println();
        for (Armors arm : Armors.armors()){
            System.out.println(arm.getArmorId() + "\t" + arm.getNameOfArmor() + "\tBlock : " + 
                                arm.getArmorBlock() + "\tPrice : " + 
                                arm.getArmorPrice());
        }
        System.out.println("0\tLeave.");
    }

    public void buyArmors(){
        System.out.print("Choose an armour : ");
        int armorChooseId = inp.nextInt();
        while(armorChooseId < 0 || armorChooseId > Armors.armors().length){
            System.out.print("Invalid selection. Please try again : ");
            armorChooseId = inp.nextInt();
        }

        if(armorChooseId != 0){
            Armors selectedArmor = Armors.getArmorObjById(armorChooseId);
            if(selectedArmor.getArmorPrice() > this.getPlayer().getBallance()){
                System.out.println("You don't have enough money!");
                System.out.println("Your ballance : " + this.getPlayer().getBallance());
                System.out.println();
            }else{
                System.out.println();
                System.out.println("You bought a " + selectedArmor.getNameOfArmor());
                this.getPlayer().setBallance(this.getPlayer().getBallance() - selectedArmor.getArmorPrice());
                System.out.println("Your ballance : " + this.getPlayer().getBallance());
                System.out.println();
                System.out.println("The previous armor : " + this.getPlayer().getInventory().getArmors().getNameOfArmor());
                this.getPlayer().getInventory().setArmors(selectedArmor);
                System.out.println("Your armor : " + this.getPlayer().getInventory().getArmors().getNameOfArmor());
                System.out.println();
            }
        }
    }
}