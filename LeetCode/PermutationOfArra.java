package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_of_arrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        permutatiom(res,new ArrayList<>(), arr, new boolean[arr.length]);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    public static void permutatiom(List<List<Integer>> res,List<Integer> cur,int[] nums,boolean[] visited){
            if(cur.size()==nums.length){
                res.add(new ArrayList(cur));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(visited[i])
                    continue;
                cur.add(nums[i]);
                visited[i] = true;
                permutatiom(res,cur,nums,visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
    }
}
