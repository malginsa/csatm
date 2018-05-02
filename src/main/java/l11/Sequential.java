package l11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Sequential {

    public static int search (String key, String[] list)
    {
        for (int i=0; i<list.length; i++)
            if (list[i].equals(key))
                return i;
        return -1;
    }

    public static void main(String[] args) {

        String[] words = StdIn.readAllStrings();
        int count = words.length;
        double start = System.currentTimeMillis() / 1000.;
        for (int i=0; i<10*count; i++)
        {
            String key = words[StdRandom.uniform(count)];
            if (search(key, words) == -1)
                StdOut.println(key);
        }
        double finish = System.currentTimeMillis() / 1000.;
        StdOut.println(Math.round(finish-start) + " seconds");
    }
}
