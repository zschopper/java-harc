package model;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kocka {
    private static Random rnd = new Random();

    public static int dobas(int kocka) {
        return dobas(1, kocka, 0);
    }

    public static int dobas(int db, int kocka) {
        return dobas(db, kocka, 0);
    }

    public static int dobas(int db, int kocka, int mod) {
        int ret = 0;
        for (int i = 0; i < db; i++) {
            ret += rnd.nextInt(1, kocka);
        }
        return ret + mod;
    }

    public static int dobas(String szoveg) {
        // d4-től egészen a 2d20+4d6-10 mintáig. Nem kezeli a hibás mintát.

        String[] reszek = szoveg.split("(?<=\\+|\\-)|(?=\\+|\\-)");
        Pattern kockaMinta = Pattern.compile("(\\d*)d(\\d+)");

        int szorzo = 1;
        int osszeg = 0;

        for (String resz : reszek) {
            Matcher matcher = kockaMinta.matcher(resz);
            if (matcher.find()) {
                String kockaDbStr = matcher.group(1);
                int kockaDb = kockaDbStr.isEmpty() ? 1 : Integer.parseInt(kockaDbStr);

                String kockaTipusStr = matcher.group(2);
                int kockaTipus = Integer.parseInt(kockaTipusStr);

                osszeg += szorzo * dobas(kockaDb, kockaTipus);
            } else if (resz.equals("+")) {
                szorzo = 1;
            } else if (resz.equals("-")) {
                szorzo = -1;
            } else {
                int mod = szorzo * Integer.parseInt(resz);
                osszeg += mod;
            }
        }

        return osszeg;

    }
}
