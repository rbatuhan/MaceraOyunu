public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------Mağazaya hoşgeldiniz!------");

        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.print("Seçiminiz: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Yanlış bir seçim yaptınız. Tekrar deneyiniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon() {
        System.out.println("---------Silahlar---------");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() +
                    " <Para: " + weapon.getPrice() + " Hasar: " + weapon.getDamage() + ">");
        }
        System.out.println("0 - Çıkış yap");
    }
    public void buyWeapon(){

        System.out.println("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Yanlış bir seçim yaptınız. Tekrar deneyiniz: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {

                    System.out.println(selectedWeapon.getName() + " satın alındı.");
                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("---------Zırhlar---------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName() + " <Para: " + armor.getPrice() + " Zırh: " + armor.getBlock() + ">");
        }
        System.out.println("0 - Çıkış yap");
    }
    public  void buyArmor(){
        System.out.println("Bir zırh seçiniz: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Yanlış bir seçim yaptınız. Tekrar deneyiniz: ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {

                    System.out.println(selectedArmor.getName() + " satın alındı.");
                    int balance = getPlayer().getMoney() - selectedArmor.getPrice();
                    getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paranız: " + getPlayer().getMoney());
                }
            }
        }


    }
}