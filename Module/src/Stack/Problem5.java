package src.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem5 {

    /* 503. Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array,
which means you could search circularly to find its next greater number.
If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]*/

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=nums.length-2;i>=0;i--){
            stack.push(nums[i]);
        }
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
                stack.push(nums[i]);
            }
            else {
                result[i]=stack.peek();
                stack.push(nums[i]);
            }
        }
        return result;
    }
}
