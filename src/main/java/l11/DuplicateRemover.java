package l11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class DuplicateRemover {
    public static void main(String[] args) {
        String[] strings = Generator.generateRandomStrings(3, "abc", 100);
//        String[] strings = StdIn.readAllStrings();
        Arrays.sort(strings);
        StdOut.println(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].compareTo(strings[i-1]) != 0)
                StdOut.println(strings[i]);
        }
    }
}
