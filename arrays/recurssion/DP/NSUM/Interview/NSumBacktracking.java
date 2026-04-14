package arrays.recurssion.DP.NSUM.Interview;

// This is clean and interview ready solution.
// T (2^n)

public class NSumBacktracking {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,4,6,9,0,13};
        int target = 13;
        int n = 4;
        int[] result = new int[n];
        result= NSum(nums,target,n);
        if(result.length ==0){
            System.out.println("No Solution founbd");
        }else{
            for (int i : result) {
                System.out.print(i+" ");
            }
        }
    }

    private static int[] NSum(int[] nums, int target, int n) {
        int[] ans = new int[n];
        boolean found = helperBacktracking(nums,target,n,0,ans,0);
        return found ? ans : new int[0];
    }

    private static boolean helperBacktracking(int[] nums, int target, int n, int index, int[] ans, int pos) {

        if(n==0){
            return target==0;
        }
        
        if(index == nums.length){
            return false;
        }

        if(n > nums.length - index){ // lees numbers to sonsider in nums array
            return false;
        }

        if(target < 0){ // add this if all numbers are positive
            return false;
        }

        // include the current element
        ans[pos] = nums[index];
        if(helperBacktracking(nums,target-nums[index],n-1,index+1,ans,pos+1)){
            return true;
        }
        //ans[ans.length-n] = 0; // backtracking, Not needed as it will be overritten.
        // “Because each position is deterministically overwritten before reuse, so explicit backtracking reset is unnecessary.”

        // exclude the current element
        if(helperBacktracking(nums,target,n,index+1,ans,pos)){
            return true;
        }
        return false;
    }

}
