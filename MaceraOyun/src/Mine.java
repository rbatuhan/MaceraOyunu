import java.util.Random;

public class Mine extends BattleLoc{


    public Mine(Player player) {
        super(player, "Maden", new Snake(), "Diamond", 5);

    }

    @Override
    public boolean onLocation() {
        System.out.println("Madendesiniz!");
        return super.onLocation();
    }
}