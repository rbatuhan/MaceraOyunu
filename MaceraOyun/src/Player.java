import java.util.Scanner;

public class Player {
    private  int damage;
    private  int health;
    private int orjinalHealth;
    private  int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name=name;
        this.inventory = new Inventory();

    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler");
        System.out.println("<<<<<===========================================>>>>>");

        for (GameChar gameChar : charList) {
            System.out.println( "ID : " + gameChar.getId() +
                    "\t Karakter : " + gameChar.getName() +
                    "\t\t Hasar: " + gameChar.getDamage() +
                    "\t\t Sağlık: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());
        }
        System.out.println("<<<<<===========================================>>>>>");
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectChar = input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Oyuncu Bilgileri");
        System.out.println(" ");
        System.out.print(" Silahınız : " + this.getInventory().getWeapon().getName() +
                "\t\t Zırhınız : " + this.getInventory().getArmor().getName() +
                "\t\t Blok : " + this.getInventory().getArmor().getBlock() +
                "\t\t Hasar: " + this.getTotalDamage() +
                "\t\t Sağlık: " + this.getHealth() +
                "\t\t Para: " + this.getMoney());
        System.out.println(" ");
    }
    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage(); }
    public int getDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        if (health<0) {
            health = 0;
        }
        this.health=health;
    }
    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getCharName(){
        return this.charName;
    }
    public void setCharName(String charName){
        this.charName=charName;
    }
    public Inventory getInventory() {return inventory;}
    public void setInventory(Inventory inventory) {this.inventory = inventory;}

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }



}