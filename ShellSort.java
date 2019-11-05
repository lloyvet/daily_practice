package sortArr;

import java.util.Arrays;

public class shellSort {
    public static void main(String[] args) {
        int[] arr = new int[] {8,9,1,7,2,3,5,6,0};
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i - gap; j >=0; j -= gap){
                    if(arr[j]>arr[j+gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
