package misc;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class IntSotring {

    public static int[] randomInts(int count) {
        int[] result = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++)
            result[i] = random.nextInt();
        return result;
    }

    public static void teamSorting(int[] ints) {
        Arrays.sort(ints);
    }

    public static void main(String[] args) {
        int[] ints = randomInts(1_000_000);
        int[] sorted = Arrays.copyOf(ints, ints.length);
        for(int i=0; i<10; i++) StdOut.print(sorted[i] + " "); StdOut.println();
        long start = System.currentTimeMillis();
        teamSorting(sorted);
        long end = System.currentTimeMillis();
        for(int i=0; i<10; i++) StdOut.print(sorted[i] + " "); StdOut.println();
        for(int i=0; i<10; i++) StdOut.print(sorted[sorted.length - 1 - i] + " "); StdOut.println();
        System.out.println("team sorting took " + (end - start)/1000. + " sec");
    }
}
