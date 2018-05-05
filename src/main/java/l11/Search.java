package l11;

public class Search {

    public static int sequential (String key, String[] list)
    {
        for (int i=0; i<list.length; i++)
            if (list[i].equals(key))
                return i;
        return -1;
    }

    public static int binaryRecursevly(String key, String[] strings) {
        return binaryRecursevly(key, strings, 0, strings.length);
    }

    private static int binaryRecursevly(String key, String[] strings,
                                              int lo, int hi) {
        if (hi - lo < 2)
            if (key.compareTo(strings[lo]) == 0) return lo;
            else return -1;
        int mid = (hi - lo) / 2 + lo;
        if (key.compareTo(strings[mid]) >= 0)
            return binaryRecursevly(key, strings, mid, hi);
        else
            return binaryRecursevly(key, strings, lo, mid);
    }

    public static int binaryIterative(String key, String[] strings) {
        int lo = 0;
        int hi = strings.length;
        while (hi - lo > 1) {
            int mid = (hi - lo) / 2 + lo;
            if (key.compareTo(strings[mid]) >= 0) lo = mid;
            else hi = mid;
        }
        if (key.compareTo(strings[lo]) == 0) return lo;
        else return  -1;
    }
}
