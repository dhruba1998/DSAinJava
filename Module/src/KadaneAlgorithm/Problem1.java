package src.KadaneAlgorithm;

public class Problem1 {

    /*53. Maximum Subarray
   Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.*/


    public int maxSubArray(int[] nums) {
        int currentMaxSum = nums[0];
        int maxSum = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            int v1 = currentMaxSum + nums[i];
            int v2 = nums[i];
            currentMaxSum = Math.max(v1,v2);
            maxSum = Math.max(maxSum,currentMaxSum);
        }
        return maxSum;
    }

}
