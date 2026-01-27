package src.PrefixSum;

import java.util.HashMap;

public class Problem1 {

    /* 560. Subarray Sum Equals K
Given an array of integers nums and an integer k,
return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2 */


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hashMap.containsKey(sum-k)){
                count+=hashMap.get(sum-k);

            }
            if(hashMap.containsKey(sum)){
                hashMap.put(sum,hashMap.get(sum)+1);
            }
            else {
                hashMap.put(sum,1);
            }
        }
        return count;
    }

}
