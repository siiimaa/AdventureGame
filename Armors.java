public class Armors {
    private String nameOfArmor;
    private int armorId, armorBlock, armorPrice;

    public Armors(String nameOfArmor, int armorId, int armorBlock, int armorPrice) {
        this.nameOfArmor = nameOfArmor;
        this.armorId = armorId;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }

    public static Armors[] armors() {
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors("Light Armor", 1, 1, 10);
        armorList[1] = new Armors("Middle Armor", 2, 3, 15);
        armorList[2] = new Armors("Strong Armor", 3, 5, 20);
        return armorList;
    }

    public static Armors getArmorObjById(int armId) {
        for (Armors a : Armors.armors()) {
            if (a.getArmorId() == armId) {
                return a;
            }
        }
        return null;
    }

    public String getNameOfArmor() {
        return nameOfArmor;
    }
    public void setNameOfArmor(String nameOfArmor) {
        this.nameOfArmor = nameOfArmor;
    }

    public int getArmorId() {
        return armorId;
    }
    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public int getArmorBlock() {
        return armorBlock;
    }
    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return armorPrice;
    }
    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }

}
