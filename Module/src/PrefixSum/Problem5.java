package src.PrefixSum;

import java.util.HashMap;

public class Problem5 {

    /* 525. Contiguous Array
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.*/

    public int findMaxLength(int[] nums) {
        int zeroCount=0,oneCount=0;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            else {
                oneCount++;
            }
            int diff = oneCount - zeroCount;
            if(diff==0){
                maxLen = Math.max(maxLen,i+1);
                continue;
            }
            if (map.containsKey(diff)) {
                int idx = map.get(diff);
                maxLen = Math.max(maxLen, i - idx);
            }
            else {
                map.put(diff,i);
            }
        }
        return maxLen;
    }

}
