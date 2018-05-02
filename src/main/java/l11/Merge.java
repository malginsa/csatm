package l11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

    public static void sort(String[] strings) {
        String[] result = sort(strings, 0, strings.length);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = result[i];
        }
    }

    private static String[] sort(String[] strings, int lo, int hi) {
        if (hi-lo < 2)
            return new String[]{strings[lo]};
        int mid = lo + (hi - lo) / 2;
        String[] part1 = sort(strings, lo, mid);
        String[] part2 = sort(strings, mid, hi);
        return merge(part1, part2);
    }

    private static String[] merge(String[] part1, String[] part2) {
        String[] aux = new String[part1.length + part2.length];
        int i = 0, j = 0, k = 0;
        while (i < part1.length && j < part2.length) {
            if (part1[i].compareTo(part2[j]) < 0)
                aux[k++] = part1[i++];
            else
                aux[k++] = part2[j++];
        }
        if (i < part1.length)
            for(int l=i; l<part1.length; l++)
                aux[k++] = part1[l];
        else
            for(int l=j; l<part2.length; l++)
                aux[k++] = part2[l];
        return aux;
    }

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
//        String[] strings = {"4", "1", "2", "5", "4", "6", "3", "4"};
        sort(strings);
        for (String string : strings) {
            StdOut.println(string);
        }
    }
}
