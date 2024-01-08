import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {

        int obsNumber = this.randomObstacleNumber();

        System.out.println("Şuan buradasınız: " + getName());
        System.out.println("Dikkatli ol! Bu bölgede " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.println("<<<<<===========================================>>>>>");
        System.out.println("<S>avaş veya <K>aç: ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println("Savaş bitti!");
            System.out.println("<<<<<===========================================>>>>>");

            System.out.println(this.getName() + " tüm düşmanları yendiniz!");
            regionReward();
            return true;
        }

        if (getPlayer().getHealth() <= 0) {
            System.out.println(" -----Öldün!----- ");
            return false;
        }
        return true;
    }

    public void regionReward() {

        if (this instanceof Cave) {
            getPlayer().getInventory().setFood(true);
            System.out.println("Yemek (Food) ödülü envanterinize eklendi!");
        } else if (this instanceof Forest) {
            getPlayer().getInventory().setFirewood(true);
            System.out.println("Odun (Firewood) ödülü envanterinize eklendi!");
        } else if (this instanceof River) {
            getPlayer().getInventory().setWater(true);
            System.out.println("Su (Water) ödülü envanterinize eklendi!");
        }
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            boolean isSnake = getObstacle().getName().equals("Yılan");
            if (isSnake) {
                this.setObstacle(new Snake());
            }
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            boolean firstMove = Math.random() * 100 <= 50;
            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0) {


                if (firstMove) {

                    System.out.println("Vuruş sırası sizde!");
                    System.out.println("<V>ur veya <K>aç: ");
                    String selectCombat = input.nextLine().toUpperCase();

                    if (selectCombat.equals("V")) {
                        System.out.println("Siz vurdunuz!");
                        getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
                        afterHit();
                    } else {
                        return false;
                    }
                } else {

                    if (getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Vuruş sırası rakipte!");
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        getPlayer().setHealth(getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
                firstMove = !firstMove;
            }

            if (getObstacle().getHealth() < getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz!");

                if (isSnake) {
                    Snake snake = (Snake) getObstacle();
                    snake.setWarDiamond(snake.randomWarDiamond());
                    if (snake.getWarDiamond() instanceof Weapon){
                        getPlayer().getInventory().setWeapon((Weapon) snake.getWarDiamond());
                    } else if (snake.getWarDiamond() instanceof Armor){
                        getPlayer().getInventory().setArmor((Armor) snake.getWarDiamond());
                    }
                    System.out.println(snake.getWarDiamond()!= null ? snake.getWarDiamond()+ " Kazandınız!" : "");
                }
                getPlayer().setMoney(getPlayer().getMoney() + getObstacle().getAward());


                System.out.println(isSnake ? "" : getObstacle().getAward() + " Para Kazandınız!");
                System.out.println("Güncel Paranız: " + getPlayer().getMoney());
                System.out.println("=======================================");
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Oyuncu Sağlık \t: " + getPlayer().getHealth());
        System.out.println(getObstacle().getName() + " Sağlık \t: " + getObstacle().getHealth());
        System.out.println("=======================================");
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri\n");
        System.out.println("----------------");
        System.out.println("Sağlık \t: " + getPlayer().getHealth());
        System.out.println("Silah \t: " + getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar \t: " + getPlayer().getTotalDamage());
        System.out.println("Zırh \t: " + getPlayer().getInventory().getArmor().getName());
        System.out.println("Blok \t: " + getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para \t: " + getPlayer().getMoney());
        System.out.println("=======================================");
    }

    public void obstacleStats(int i) {
        System.out.println(i + " . " + getObstacle().getName() + " Değerleri\n");
        System.out.println("----------------");
        System.out.println("Sağlık \t: " + getObstacle().getHealth());
        System.out.println("Hasar \t: " + getObstacle().getDamage());
        System.out.println("Ödül \t: " + getObstacle().getAward());
        System.out.println("=======================================");
    }


}