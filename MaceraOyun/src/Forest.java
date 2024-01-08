public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Firewood", 3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Ormandasınız!");
        return super.onLocation();
    }
}