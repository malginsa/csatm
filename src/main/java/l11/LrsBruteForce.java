package l11;

import edu.princeton.cs.algs4.StdOut;

/**
 * Longest Repeated Substring
 */
public class LrsBruteForce {

    /**
     * longest common prefix
     */
    protected static String lcp(String s1, String s2) {
        int N = Math.min(s1.length(), s2.length());
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.substring(0, i);
        }
        return s1.substring(0, N);
    }

    protected static String lrs(String s) {
        int N = s.length();
        String result = "";
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                String candidate = lcp(s.substring(i, N), s.substring(j, N));
                if (candidate.length() > result.length()) result = candidate;
            }
        return result;
    }

    public static void main(String[] args) {
        String aCGTstring = Generator.randomACGTstring(3_000);
        String lrs = lrs(aCGTstring);
        StdOut.println(lrs);
    }
}
