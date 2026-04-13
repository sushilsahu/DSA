public class CeilingOfNumber {

    public static void main(String[] args) {
        int[] nums = {4, 5,6,8,10};
        int target = 6;
        int result = binarySearch(nums,target);
        System.out.println(result);
    }

    private static int binarySearch(int[] nums, int target) {

        if(nums.length == 0) return -1;

        //if(target < nums[0]) return -1; // floor

        if(target > nums[nums.length-1]) return -1; // ceiling


        int start= 0, end = nums.length-1;
        while(start>=0 && end <= nums.length-1 && start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] > target){
                end = mid-1;
            }else if (nums[mid] < target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        //return end;  // reurns the floor
        return start; // return the ceilinhg
    }

}
