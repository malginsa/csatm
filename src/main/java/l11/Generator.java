package l11;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Generator {

    public static String generateRandomString(int length, String alphabet) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex = StdRandom.uniform(alphabet.length());
            chars[i] = alphabet.charAt(randomIndex);
        }
        return new String(chars);
    }

    public static String[] generateRandomStrings(int length, String alphabet, int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = generateRandomString(length, alphabet);
        }
        return strings;
    }

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        int lenght = Integer.parseInt(args[1]);
        String alphabet = args[2];
        for (int i = 0; i < count; i++) {
            StdOut.println(generateRandomString(lenght, alphabet));
        }
    }
}
