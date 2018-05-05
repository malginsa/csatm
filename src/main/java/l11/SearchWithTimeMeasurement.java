package l11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SearchWithTimeMeasurement {

    public static void main(String[] args) {

        String[] words = Generator.generateRandomStrings(
                10, "abcdefgheijklmnopqrstuvwxyz", 10_000);
        int count = words.length;
        double start = System.currentTimeMillis() / 1000.;
        for (int i=0; i<10*count; i++)
        {
            String key = words[StdRandom.uniform(count)];
            if (Search.sequential(key, words) == -1)
                StdOut.println(key);
        }
        double finish = System.currentTimeMillis() / 1000.;
        StdOut.println(Math.round(finish-start) + " seconds");
    }
}
