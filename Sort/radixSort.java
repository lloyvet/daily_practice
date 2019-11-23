package sortArr;

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] arr = {23,6,189,45,9,287,56,1,798,34,65,652,5};
        radixS(arr);
        System.out.println(Arrays.toString(arr));
    }
    public  static void radixS(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>max)
                max = arr[i];
        }
        //得到最大数的位数
        int maxLength = (max +"").length();
        //防止溢出大小定义为数组大小
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中实际存放多少数据
        int[] bucketCount = new int[10];
        for(int i = 0, n = 1; i < maxLength; i++,n *= 10){
            for (int j = 0; j <arr.length; j++){
                int digitofElement = arr[j] / n %10;
                //存放到相应的桶中
                bucket[digitofElement][bucketCount[digitofElement]] = arr[j];
                bucketCount[digitofElement] ++;
            }
            int index = 0;
            for (int k = 0; k < bucketCount.length; k++){
                if(bucketCount[k]!=0) {
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }

                }
                bucketCount[k] = 0;
            }
        }
    }
}
