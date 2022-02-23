package app.cleancode.host;

import java.util.Random;

public class Host {
    private final Random rand = new Random();

    /**
     * Start a round
     * 
     * @return a new set of doors for use with <code>initialGuess</code> and <code>finalGuess</code>
     */
    public DoorSet begin() {
        return new DoorSet(rand);
    }

    /**
     * Make an initial guess.
     * 
     * @param doors the set of doors
     * @param number the door number to guess
     * @return the number of a different door with a goat behind it
     */
    public int initialGuess(DoorSet doors, int number) {
        for (int i = 0; i < 3; i++) {
            if (i != number) {
                if (!doors.hasCar[i]) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Door set does not have two doors with goats");
    }

    /**
     * Final guess
     * 
     * @param doors the set of doors
     * @param guess the door number to guess
     * @return weather you got a car
     */
    public boolean finalGuess(DoorSet doors, int guess) {
        return doors.hasCar[guess];
    }
}
