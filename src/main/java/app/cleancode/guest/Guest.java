package app.cleancode.guest;

import java.util.Random;
import app.cleancode.host.DoorSet;
import app.cleancode.host.Host;

public class Guest {
    public final boolean willSwitch;
    private final Random rand = new Random();
    private int numCorrect = 0;

    public Guest(boolean willSwitch) {
        this.willSwitch = willSwitch;
    }

    public boolean play(Host host) {
        DoorSet doors = host.begin();
        int initialGuess = rand.nextInt(3);
        int otherDoorWithAGoat = host.initialGuess(doors, initialGuess);
        int finalGuess = -1;
        if (willSwitch) {
            for (int i = 0; i < 3; i++) {
                if (i != initialGuess && i != otherDoorWithAGoat) {
                    finalGuess = i;
                    break;
                }
            }
        } else {
            finalGuess = initialGuess;
        }
        if (finalGuess == -1) {
            throw new RuntimeException("Somehow there are no options");
        }
        boolean correct = host.finalGuess(doors, finalGuess);
        if (correct) {
            numCorrect++;
        }
        return correct;
    }

    public int getNumCorrect() {
        return numCorrect;
    }
}
