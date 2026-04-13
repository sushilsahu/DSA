package arrays.recurssion;

import java.util.ArrayList;
import java.util.List;

public class NSumProblemAll {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15,4,6,9,0,13};
        int target = 13;
        int n = 3;
        List<List<Integer>> result = new ArrayList<>();
        result= NSum(nums,target,n);
        System.out.println(result);
    }

    private static List<List<Integer>> NSum(int[] nums, int target, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0,n ,target,nums,ans,ds);
        return ans;
    }

    private static void helper(int index, int n, int target, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        if(index == nums.length || n == 0){
            if(target == 0 && n == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // Include the current element
        ds.add(nums[index]);
        helper(index+1, n-1, target - nums[index], nums, ans, ds);
        ds.remove(ds.size()-1); // Backtrack
        // Exclude the current element
        helper(index+1, n, target, nums, ans, ds);  
    }
}
