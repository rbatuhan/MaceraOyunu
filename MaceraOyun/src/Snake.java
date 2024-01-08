import java.util.Random;

public class Snake extends Obstacle {

    private Weapon weapon;
    private Armor armor;
    public Snake() {
        super(4, "Yılan", 0, 12, 0);
        setDamage(4);
    }

    @Override
    public void setDamage(int damage) {
        Random r = new Random();
        int i = r.nextInt(damage) + 3;
        super.setDamage(i);
    }

    @Override
    public String toString() {
        return "Yılan";
    }

    public WarDiamond getWarDiamond() {
        if (weapon != null) {
            return weapon;
        } else if (armor != null) {
            return armor;
        }
        return null;
    }

    public void setWarDiamond(WarDiamond warDiamond) {
        if (warDiamond instanceof Weapon) {
            this.weapon = (Weapon) warDiamond;
        } else if (warDiamond instanceof Armor) {
            this.armor = (Armor) warDiamond;
        }
    }


    public WarDiamond randomWarDiamond() {
        Random r = new Random();

        int i = r.nextInt(101);

        if (i <= 15) {
            Random r2 = new Random();
            int j = r2.nextInt(101);
            //silah
            if (j < 20) {
                return Weapon.getWeaponById(3);
            } else if (j < 50) {
                return Weapon.getWeaponById(2);
            } else if (j >= 50) {
                return Weapon.getWeaponById(1);
            }
        } else if (i >15 && i <= 30) {
            Random r2 = new Random();
            int j = r2.nextInt(101);
            //zırh
            if (j < 20) {
                return Armor.getArmorById(3);
            } else if (j < 50) {
                return Armor.getArmorById(2);
            } else if (j >= 50) {
                return Armor.getArmorById(1);
            }
        } else if (i > 30 && i <= 55) {
            Random r2 = new Random();
            int j = r2.nextInt(101);

            if (j < 20) {
                this.setAward(10);
                System.out.println("10 para kazandınız!");
            } else if (j < 50) {
                this.setAward(5);
                System.out.println("5 para kazandınız!");
            } else if (j >= 50) {
                this.setAward(1);
                System.out.println("1 para kazandınız!");
            }
        }
        else {
            System.out.println("Yılan'dan bir şey çıkmadı!");
        }
        return null;
    }
}