package test;

public class Sort {


    public static void sort(String[] strings) {
        //find the smallest item
        //move it to the front
        //selection sort the rest part

        sort(strings, 0);

    }

    private static void sort(String[] strings, int start) {
        if (start == strings.length) {
            return;
        }
        int smallestIndex = findSamllest(strings, start);
        swap(strings, start, smallestIndex);
        sort(strings, start+1);
    }

    public static int findSamllest(String[] strings, int start) {
        int smallestIndex = start;
        for (int i = start; i < strings.length; i++ ) {
            int cmp = strings[i].compareTo(strings[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] strings, int a, int b) {
        String temp = strings[b];
        strings[b] = strings[a];
        strings[a] = temp;
    }
}
