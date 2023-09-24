public class Enemy {
    private String nameOfEnemy;
    private int id, damage, health, awardMoney, defaultHealth;

    public Enemy(int id, String nameOfEnemy, int damage, int health, int awardMoney) {
        this.nameOfEnemy = nameOfEnemy;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defaultHealth = health;
        this.awardMoney = awardMoney;
    }

    public String getNameOfEnemy() {
        return this.nameOfEnemy;
    }
    public void setNameOfEnemy(String nameOfEnemy) {
        this.nameOfEnemy = nameOfEnemy;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

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
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getAwardMoney() {
        return awardMoney;
    }
    public void setAwardMoney(int awardMoney) {
        this.awardMoney = awardMoney;
    }

    public int getDefaultHealth() {
        return this.defaultHealth;
    }
    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

}
