package Oj;

import java.util.Scanner;

public class Longest_string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] ar = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (('0' <= ar[i] && ar[i] <= '9')) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
        int num = 0;
        for (int i = 0; i < ar.length; i++) {
            if (('0' <= ar[i] && ar[i] <= '9')) {
                num++;
            } else {
                num = 0;
            }
            if (num == max) {
                start = i - max;
                break;
            }
        }
        System.out.println(start);
        for(int i = start+1; i < start + max+1; i++){
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
