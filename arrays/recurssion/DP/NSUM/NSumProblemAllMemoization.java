package arrays.recurssion.DP;

import java.util.ArrayList;
import java.util.List;

// Given an array of integers nums, an integer target, and an integer n, return all unique combinations of n numbers in nums that add up to target. Each combination should be a list of integers, and the result should be a list of these combinations. If there are no combinations that add up to target, return an empty list.
// This solution is implemented using memoization to optimize the recursive calls by storing previously computed results in a 3D boolean array. The helper function checks both including and excluding the current element and updates the dp array accordingly to avoid redundant calculations. The function also ensures that only unique combinations are added to the result list by using a set to track the combinations that have already been added.
// But Not 100% correct
// Try not to use This approach.
public class NSumProblemAllMemoization {


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
        boolean[][][] dp = new boolean[nums.length+1][n+1][target+1];// Create a 3D boolean array to store results of subproblems
        helper(0,n ,target,nums,ans,ds,dp);
        return ans;
    }

    private static void helper(int index, int n, int target, int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[][][] dp) {
         if(target < 0){ // If target becomes negative, no need to continue
            return;
        }
         if(index == nums.length || n == 0){
              if(target == 0 && n == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(dp[index][n][target] == true){ // If we have already computed this state
            return;
        }
        dp[index][n][target] = true; // Mark this state as true in dp   
        if(index == nums.length || n == 0){
            if(target == 0 && n == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // Include the current element
        ds.add(nums[index]);
        helper(index+1, n-1, target - nums[index], nums, ans, ds, dp);
        ds.remove(ds.size()-1); // Backtrack
        // Exclude the current element
        helper(index+1, n, target, nums, ans, ds, dp);  
    }
}
