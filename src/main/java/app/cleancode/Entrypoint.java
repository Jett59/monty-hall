package app.cleancode;

import app.cleancode.guest.Guest;
import app.cleancode.host.Host;

public class Entrypoint {
    private static int attempts = 100000000;

    public static void main(String[] args) {
        Host host = new Host();
        Guest switcher = new Guest(true);
        Guest nonSwitcher = new Guest(false);
        for (int i = 0; i < attempts; i++) {
            switcher.play(host);
        }
        for (int i = 0; i < attempts; i++) {
            nonSwitcher.play(host);
        }
        double switchCorrectFraction = (double) switcher.getNumCorrect() / attempts;
        double nonSwitchCorrectFraction = (double) nonSwitcher.getNumCorrect() / attempts;
        System.out.printf("Switching got %.3f%%\nNot switching got %.3f%%\n",
                switchCorrectFraction * 100, nonSwitchCorrectFraction * 100);
    }
}
