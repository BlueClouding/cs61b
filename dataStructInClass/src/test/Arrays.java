package test;

public class Arrays {
    public static int[] insert(int[] arr,int item,int position) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr,0,newArr,0,position);
        newArr[position] = item;
        System.arraycopy(arr,position,newArr,position+1,arr.length - position);
        return newArr;
    }

    public static void reverse(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length / 2; i++ ) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++ ) {
            totalLength += x[i].length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i ++ ) {
            for (int j = 0; j < x[i].length; j++ ) {
                a[aIndex] = x[i][j];
                aIndex++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[][] x = new int[][]{{1,2,3,4},{34,45},{46},{},{236,6,7}};

        reverse(arr);
//        for (int number : arr) {
//            System.out.println(number);
//        }

        int[] xFlatten = flatten(x);
        for (int i = 0; i < xFlatten.length; i++ ) {
            System.out.println(xFlatten[i]);
        }

    }
}
