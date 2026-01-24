package src.SildingWindow;

public class Problem2 {

    /*
    * Given an array of positive integers nums and an integer k,
    * find the length of the longest subarray whose sum is less than or equal to k
    * Input: nums = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8
    * Output: 4
    * Explanation: [4, 2, 1, 1]
    */
    public static int longestSumSubArray(int[] nums, int target){
        int left = 0;
        int currSum = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            currSum+=nums[right];
            while (currSum>target){
                currSum-=nums[left++];
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        if(maxLen<0){
            return 0;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        System.out.println(longestSumSubArray(nums,k));
    }


}
