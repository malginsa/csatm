package l11;

/**
 * LRS
 */
public class LRS {

    /**
     * lcp
     */
    protected static String lcp(String s1, String s2) {
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
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        Merge.sort(suffixes);
        String result = "";
        for(int i=0;i<N-1;i++) {
            String candidate = lcp(suffixes[i], suffixes[i + 1]);
            if (candidate.length() > result.length()) result = candidate;
        }
        return result;
    }
}
