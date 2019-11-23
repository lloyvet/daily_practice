package sortArr;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] arr = {3,7,4,6,8};
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            int temp;
            for(int j = i+1; j < arr.length ;j++){
                if(arr[min]<arr[j])
                    min = j;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
