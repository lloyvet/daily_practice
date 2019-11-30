package Leetcode;

import java.util.Arrays;

public class first_Missing_Positive {
    public static void main(String[] args) {
        int[] nums = {-2, 3, 2, 1};

        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            //前两个判断是否成为索引
            //后一个判断
          while (nums[i]>0&&nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
              // 第 3 个条件不成立的索引的部分是 i 和 nums[i]-1
                swap(nums,nums[i] - 1, i);
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < len; i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        return len + 1;
    }
    public static void swap(int[] nums,int index1,int index2){
        if(index1==index2)
            return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
