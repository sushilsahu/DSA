package arrays.recurssion;


public class NSumProblemFirstOccurance {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,4,6,9,0,13};
        int target = 13;
        int n = 3;
        int[] ans = NSum(nums,target,n);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    private static int[] NSum(int[] nums, int target, int n) {
        int[] ans = new int[n];
        helper(0,n ,nums,target,ans);
        return ans;
    }

    private static boolean helper(int i, int n, int[] nums, int target, int[] ans) {
       // Base case
        if(n ==0 || i==nums.length){
             if(target==0 && n==0){
                return true;
            }
            return false;
        }

        // Include the current element
        ans[ans.length-n] = nums[i];
        if(helper(i+1, n-1, nums, target - nums[i], ans)){
            return true;
        }
        ans[ans.length-n] = 0; // Backtrack
        
        // Exclude the current element
        if(helper(i+1, n, nums, target, ans)){  
            return true;
        }
        return false;
    }

}
