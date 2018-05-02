package l11;

import edu.princeton.cs.algs4.StdOut;

public class TestEquality {

    private static String AZ_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        String[] shuffled = Generator.generateRandomStrings(10, AZ_ALPHABET, 30_000);

        String[] sortedByInsertion = createDublicate(shuffled);
        Insertion.sort(sortedByInsertion);

        String[] sortedByMerge = createDublicate(shuffled);
        Merge.sort(sortedByMerge);

        checkEquality(sortedByInsertion, sortedByMerge);
    }

    private static void checkEquality(String[] sortedByInsertion, String[] sortedByMerge) {
        for (int i = 0; i < sortedByInsertion.length; i++) {
            if (!sortedByInsertion[i].equals(sortedByMerge[i])) {
                StdOut.println("error detected");
                return;
            }
        }
        StdOut.println("arrays are equal");
    }

    private static String[] createDublicate(String[] origin) {
        String[] dublicated = new String[origin.length];
        for (int i = 0; i < dublicated.length; i++) {
            dublicated[i] = origin[i];
        }
        return dublicated;
    }
}
