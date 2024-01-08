import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.print("Lütfen bir karakter seçiniz : ");
        player.selectChar();


        Location location = null;
        while (true) {

            player.printInfo();
            System.out.println("<<<<<===========================================>>>>>");
            System.out.println("<<<================ Bölgeler =====================>>>");
            System.out.println("1 - Güvenli Ev --> Canınız yenilenir. Burası güvenli yer.");
            System.out.println("2 - Mağaza --> Silah ve zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara --> Mağaraya gir, dikkatli ol canavar çıkabilir.");
            System.out.println("4 - Orman --> Ormana gir, dikkatli ol canavar çıkabilir.");
            System.out.println("5 - Nehir --> Nehire gir, dikkatli ol canavar çıkabilir.");
            System.out.println("6 - Maden --> Madene gir, dikkatli ol canavar çıkabilir.");
            System.out.println("0 - Çıkış yap --> Oyunu sonlandırır.");
            System.out.print("Lütfe gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();


            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    if (player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()){
                        System.out.println("Tebrikler! Oyunu kazandınız!");
                        return;
                    }
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().isFood() == false) {
                        location = new Cave(player);
                        break;
                    } else {
                        System.out.println("Mağaraya daha önce girdiniz ve ödülünüzü aldınız!");
                        continue;
                    }
                case 4:
                    if (player.getInventory().isFirewood() == false) {
                        location = new Forest(player);
                        break;
                    } else {
                        System.out.println("Ormana daha önce girdiniz ve ödülünüzü aldınız!");
                        continue;
                    }
                case 5:
                    if (player.getInventory().isWater() == false) {
                        location = new River(player);
                        break;
                    } else {
                        System.out.println("Nehire daha önce girdiniz ve ödülünüzü aldınız!");
                        continue;
                    }
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge seçiniz !");
            }

            if (location == null){
                System.out.println("Game Over !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over !");
                break;
            }

        }

    }

}