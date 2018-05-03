package l11;

public class Merge {

    private static String[] aux;

    private static void sort(String[] strings, int lo, int hi) {
        if (hi - lo < 2) return;
        int mid = lo + (hi - lo) / 2;
        sort(strings, lo, mid);
        sort(strings, mid, hi);
        merge(strings, lo, mid, hi);
    }

    private static void merge(String[] strings, int lo, int mid, int hi) {
        int i = lo, j = mid, k = 0;
        while (i < mid && j < hi) {
            if (strings[i].compareTo(strings[j]) < 0)
                aux[k++] = strings[i++];
            else
                aux[k++] = strings[j++];
        }
        if (i < mid)
            for (int l = i; l < mid; l++)
                aux[k++] = strings[l];
        else
            for (int l = j; l < hi; l++)
                aux[k++] = strings[l];
        for(int l=lo;  l<hi; l++)
            strings[l] = aux[l-lo];
    }

    public static void sort(String[] strings) {
        for (String string : strings) {
            if(string == null){
                System.err.println("can't sort nulls");
                return;
            }
        }
        aux = new String[strings.length];
        sort(strings, 0, strings.length);
    }
}
