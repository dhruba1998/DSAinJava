package src.KadaneAlgorithm;

public class Problem6{

    /* 918. Maximum Sum Circular Subarray
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
A circular array means the end of the array connects to the beginning of the array.
Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once.
Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.*/

    public int maxSubarraySumCircular(int[] nums) {
        int currMaxSum = nums[0];
        int len = nums.length;
        int maxSum1 = nums[0];
        for(int i=1;i<len;i++){
            currMaxSum = Math.max(currMaxSum+nums[i],nums[i]);
            maxSum1 = Math.max(maxSum1,currMaxSum);
        }
        int currMinSum = nums[0];
        int minSum = nums[0];
        for(int i=1;i<len;i++){
            currMinSum = Math.min(currMinSum+nums[i],nums[i]);
            minSum = Math.min(minSum,currMinSum);
        }
        int actualSum=0;
        for (int i=0;i<len;i++){
            actualSum+=nums[i];
        }
        //Check if the whole array is itself equals to minSum, if it's true returns maxSum
        if(actualSum == minSum){
            return maxSum1;
        }
        int maxSum2 = actualSum - minSum;
        return Math.max(maxSum1,maxSum2);
    }

}
