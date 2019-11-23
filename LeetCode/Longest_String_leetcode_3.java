package Leetcode;

import java.util.HashMap;

public class Longest_subString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int subscript = 0;
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                subscriptax = Math.max(map.get(s.charAt(j)), subscript);//找到前一位置处的相同字符
            }
            ans = Math.max(ans, j - subscript + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
