package l11;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Longest Repeated Substring
 */
public class LrsSuffix {

    private final String text;
    private Suffix[] suffixes;

    public class Suffix implements Comparable<Suffix> {

        private final int index;

        public Suffix(int index) {
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

        public String subString(int start, int end) {
            return text.substring(index + start, index + end);
        }

    }

    public LrsSuffix(String text) {
        this.text = text;
        this.createSuffixes();
    }

    protected Suffix createSuffix(int index) {
        return new Suffix(index);
    }

    private void createSuffixes() {
        int N = this.text.length();
        this.suffixes = new Suffix[N];
        for (int i = 0; i < N; i++) {
            this.suffixes[i] = new Suffix(i);
        }
    }

    /**
     * longest common prefix
     */
    protected static String lcp(Suffix s1, Suffix s2) {
        int N = Math.min(s1.length(), s2.length());
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.subString(0, i);
        }
        return s1.subString(0, N);
    }

    protected String doLrs() {
        int N = text.length();
        Arrays.sort(this.suffixes);
        String result = "";
        for (int i = 0; i < N - 1; i++) {
            String candidate = lcp(this.suffixes[i], this.suffixes[i + 1]);
            if (candidate.length() > result.length()) result = candidate;
        }
        return result;
    }

    public static void main(String[] args) {
        String aCGTstring = Generator.randomACGTstring(500_000);
        LrsSuffix lrsSuffix = new LrsSuffix(aCGTstring);
        String lrs = lrsSuffix.doLrs();
        StdOut.println(lrs);
    }
}
