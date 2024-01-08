public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}