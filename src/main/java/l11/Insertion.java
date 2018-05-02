package l11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

    public static void sort(String[] strings) {
        int N = strings.length;
        String tmp;
        for (int i = 1; i < strings.length; i++) {
            for (int j=i; j>0; j--)
                if(strings[j-1].compareTo(strings[j]) > 0) {
                   tmp = strings[j-1];
                   strings[j-1] = strings[j];
                   strings[j] = tmp;
                }
                else break;
        }
    }

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        sort(strings);
        for (String string : strings) {
            StdOut.println(string);
        }
    }
}
