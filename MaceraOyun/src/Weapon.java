public class Weapon implements WarDiamond{
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponsList= new Weapon[3];
        weaponsList[0] = new Weapon(1, "Tabanca", 2, 5);
        weaponsList[1] = new Weapon(2, "Kılıç", 3, 35);
        weaponsList[2] = new Weapon(3, "Tüfek", 7, 45);
        return weaponsList;
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override       //WarDiamond interface olduğu için bu metodu override etmek zorundayız.
    public Object getWarDiamond() {
        return this;
    }

    @Override
    public String toString() {
        return "Silah" + " = " + name + " ";
    }
}