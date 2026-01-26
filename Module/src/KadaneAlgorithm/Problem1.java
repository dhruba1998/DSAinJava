package src.KadaneAlgorithm;

import java.util.Arrays;
import java.util.List;

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

    public static int[] maxSubArrayUsingSlidingWindow(int[] nums){
        int currSum = nums[0], maxSum = nums[0];
        int maxL = 0, maxR = 0;
        int l=0;
        int len = nums.length;
        for(int r=1;r<len;r++){
            int v1 = nums[r];
            int v2 = currSum + nums[r];
            if(v1 > v2){
                currSum = nums[r];
                l = r;
            }
            else {
                currSum+=nums[r];
            }
            if(currSum>maxSum){
                maxSum = currSum;
                maxL = l;
                maxR = r;
            }
        }
        return new int[] {maxL,maxR};
    }

    public static void main(String[] args) {
        int[] arr1 = {-2,3,4,-6,1,7};
        int[] result1 = maxSubArrayUsingSlidingWindow(arr1);
        System.out.println(result1[0]+" "+result1[1]);
    }

}
