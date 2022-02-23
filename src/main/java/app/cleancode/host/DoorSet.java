package app.cleancode.host;

import java.util.Random;

public class DoorSet {
    final boolean[] hasCar;

    public DoorSet(Random rand) {
        hasCar = new boolean[3];
        hasCar[rand.nextInt(hasCar.length)] = true;
    }

}
