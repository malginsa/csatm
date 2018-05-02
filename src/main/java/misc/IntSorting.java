package misc;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class IntSorting {

    public static final int COUNT = 100_000;
    private static int[] preSorted;

    public static int[] GenerateRandomInts(int count) {
        int[] ints = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++)
            ints[i] = random.nextInt();
        return ints;
    }

    private static void checkAndReport(String header, int[] ints, long start, long end) {
        StdOut.print(header + "... ");
        for (int i = 0; i < ints.length; i++)
            if (ints[i] != preSorted[i]) {
                System.out.println("A bug has been found, array isn't sorted!");
                return;
            }
        System.out.println("took " + (end - start) / 1_000_000_000. + " sec");
    }

    public static void doNativeSort(int[] ints) {
        long start = System.nanoTime();
        Arrays.sort(ints);
        Arrays.parallelSort(ints);
        long end = System.nanoTime();
        checkAndReport("Native sort (java's native) ", ints, start, end);
    }

    public static void doInsertionSort(int[] ints) {
        long start = System.nanoTime();
        int j, tmp;
        for (int i = 1; i < ints.length; i++) {
            j = i;
            while (j > 0 && ints[j] < ints[j - 1]) {
                tmp = ints[j - 1];
                ints[j - 1] = ints[j];
                ints[j] = tmp;
                j--;
            }
        }
        long end = System.nanoTime();
        checkAndReport("Insertion sort ", ints, start, end);
    }

    public static void main(String[] args) {
        int[] ints = GenerateRandomInts(COUNT);
        preSorted = Arrays.copyOf(ints, ints.length);
        Arrays.sort(preSorted);

        int[] shuffled = Arrays.copyOf(ints, ints.length);
        doNativeSort(shuffled);

        shuffled = Arrays.copyOf(ints, ints.length);
        doInsertionSort(shuffled);
    }
}
