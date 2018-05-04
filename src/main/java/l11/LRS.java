package l11;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Longest Repeated Substring
 */
public class LRS {

    private static class Suffix implements Comparable<Suffix> {

        private final String text;
        private final int index;

        public Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }

        private int length() {
            return text.length() - index;
        }

        private char charAt(int i) {
            return text.charAt(index + i);
        }

        @Override
        public int compareTo(Suffix that) {
            if (this == that) return 0;
            int shortest = Math.min(this.length(), that.length());
            for (int i = 0; i < shortest; i++) {
                if (this.charAt(i) > that.charAt(i)) return 1;
                if (this.charAt(i) < that.charAt(i)) return -1;
            }
            return this.length() - that.length();
        }

        @Override
        public String toString() {
            return text.substring(index);
        }
    }

    /**
     * longest common prefix
     * @param s1
     * @param s2
     */
    protected static String lcp(Suffix s1, Suffix s2) {
        int N = Math.min(s1.length(), s2.length());
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.substring(0, i);
        }
        return s1.substring(0, N);
    }

    protected static String lrsBrute(String s) {
        int N = s.length();
        String result = "";
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                String candidate = lcp(s.substring(i, N), s.substring(j, N));
                if (candidate.length() > result.length()) result = candidate;
            }
        return result;
    }

    protected static String lrsSuffixSorting(String s) {
        int N = s.length();
        Suffix[] suffixes = new Suffix[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = new Suffix(s, i);
        }
        Arrays.sort(suffixes);
        String result = "";
        for (int i = 0; i < N - 1; i++) {
            String candidate = lcp(suffixes[i], suffixes[i + 1]);
            if (candidate.length() > result.length()) result = candidate;
        }
        return result;
    }

    public static void main(String[] args) {

        String aCGTstring = Generator.randomACGTstring(100_000);
        String lrsSuffixSorting = lrsSuffixSorting(aCGTstring);
        StdOut.println(lrsSuffixSorting);
    }
}
