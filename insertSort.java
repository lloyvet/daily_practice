package sortArr;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = {3,5,6,4,2,9};
        int j;
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
