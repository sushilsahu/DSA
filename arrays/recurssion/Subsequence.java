package arrays.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Subsequence {

    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums= {1,3,2};
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        //subsequence(nums, 0,list);
        //System.out.println(ans);
        
        
        // subsequenceSum(nums, 0,0,list);
        // Collections.sort(list);
        // System.out.println(list);


        // subsequenceKSum(nums,0,0,list,2);
        // System.out.println(ans);
        
    }

    private static void subsequence(int[] nums, int i, List<Integer> list) {

        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[i]);
        subsequence(nums,i+1,list);
        list.remove(list.size()-1);
        subsequence(nums,i+1,list);
    }

    private static void subsequenceSum(int[] nums, int i, int sum,List<Integer> list) {

        if(i==nums.length){
            list.add(sum);
            return ;
        }

        sum = sum+nums[i];
        subsequenceSum(nums,i+1,sum,list);
        sum = sum -nums[i];
        subsequenceSum(nums,i+1,sum,list);
    }

    private static void subsequenceKSum(int[] nums, int i, int sum,List<Integer> list,int k) {

        if(i==nums.length){
            if(sum==k){
                ans.add(new ArrayList<>(list));
            }
            return ;
        }

        list.add(nums[i]);
        sum +=nums[i];
        subsequenceKSum(nums,i+1,sum,list,k);
        list.remove(list.size()-1);
        sum -=nums[i];
        subsequenceKSum(nums,i+1,sum,list,k);
    }
    
}
