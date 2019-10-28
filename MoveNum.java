package Oj;

import java.util.Arrays;
import java.util.Scanner;

public class MoveNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }
        int move = input.nextInt();
        while (move > 0){
            int temp = arr[arr.length-1];
            for(int i = arr.length - 1; i >0; i--)
            {
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
            n--;
        }
       for(int ar : arr){
           System.out.print(ar + " ");
       }

    }
}
