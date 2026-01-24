package src.SildingWindow;

public class Problem6 {

    /* 1004. Max Consecutive Ones III(Leetcode)
    Given a binary array nums and an integer k,
    return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     */

    public static int longestOnes(int[] arr,int k){
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        int countZero = 0;
        for(int right=0;right<arr.length;right++){
            if(arr[right]==0){
                countZero++;
            }
            while(countZero>k){
                if(arr[left]==0){
                    countZero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println(longestOnes(arr1,k1));
        int[] arr2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        System.out.println(longestOnes(arr2,k2));
    }

}
