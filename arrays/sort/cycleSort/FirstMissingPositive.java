package arrays.sort.cycleSort;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);

    }

    public static int firstMissingPositive(int[] nums) {
        int i=0, n=nums.length;

        while(i<n){
            int correctIndex = nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }


        System.out.println(Arrays.toString(nums));
        for(i=0; i<n; i++){
            
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[j]=nums[i];
        nums[i]=temp;
    }

}
