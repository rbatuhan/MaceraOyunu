public class River extends BattleLoc{

    public River(Player player) {
        super(player, "Nehir", new Bear(), "Water", 2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Nehirdesiniz!");
        return super.onLocation();
    }
}