package arrays.recurssion.DP;

// Given an array of integers nums, an integer target, and an integer n, return the first n numbers in nums that add up to target. If there are multiple combinations, return the one that appears first in the array. If there is no combination that adds up to target, return an empty array.
// This solution is implemented using memoization to optimize the recursive calls by storing previously computed results in a 3D boolean array. The helper function checks both including and excluding the current element and updates the dp array accordingly to avoid redundant calculations.
// But Not 100% correct
// Try not to use This approach.
public class NSumProblemFirstOccuranceMemoization {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,4,6,9,0,13};
        int target = 13;
        int n = 4;
        int[] ans = NSum(nums,target,n);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    private static int[] NSum(int[] nums, int target, int n) {
        int[] ans = new int[n];
        boolean[][][] dp = new boolean[nums.length+1][n+1][target+1];// Create a 3D boolean array to store results of subproblems
        helper(0,n ,nums,target,ans,dp);
        return dp[0][n][target] == true ? ans : new int[0] ;
    }

    private static boolean helper(int i, int n, int[] nums, int target, int[] ans, boolean [][][] dp) {
       // Base case
        if(target < 0){ // If target becomes negative, no need to continue
            return false;
        }

        if (n == 0) { // If we have selected n elements, check if target is 0
            return target == 0;
        }
        if (i == nums.length) { // If we have reached the end of the array
            return false;
        }

        if(dp[i][n][target] == true){ // If we have already computed this state
            return dp[i][n][target] == true;
        }

        // Include the current element
        ans[ans.length-n] = nums[i];
        if(helper(i+1, n-1, nums, target - nums[i], ans, dp)){
            dp[i][n][target] = true; // Mark this state as true in dp
            return true;
        }
        ans[ans.length-n] = 0; // Backtrack
        
        // Exclude the current element
        if(helper(i+1, n, nums, target, ans, dp)){  
            dp[i][n][target] = true;
            return true;
        }
        dp[i][n][target] = false; // Mark this state as false in dp
        return false;
    }

}
