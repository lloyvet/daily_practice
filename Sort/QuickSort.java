package sortArr;

import java.util.Arrays;

public class quicSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,59};
        QuickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
    public static void QuickSort(int[] arr,int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(right + left) / 2];
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l>=r)
                break;
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l]==pivot)
                r -= 1;
            if(arr[r]==pivot)
                l += 1;
        }
        if(l==r){
            l += 1;
            r -= 1;
        }
        if(left<r)
            QuickSort(arr,left,r);
        if(right>l)
            QuickSort(arr,l,right);
    }
}
