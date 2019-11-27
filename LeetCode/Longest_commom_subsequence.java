package Leetcode;

public class Longest_commom_subsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
    public static int longestCommonSubsequence(String text1,String text2){
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        char[] textArr1 = text1.toCharArray();
        char[] textArr2 = text2.toCharArray();
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <=length2; j++){
                if(textArr1[i-1] == textArr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
