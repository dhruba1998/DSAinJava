package src.KadaneAlgorithm;

public class Problem3 {

    /*152. Maximum Product Subarray
    Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

    public int maxProduct(int[] nums) {
        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0];
        int maxProduct = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            int v1 = nums[i];
            int v2 = currentMaxProduct * nums[i];
            int v3 = currentMinProduct * nums[i];
            currentMaxProduct = Math.max(v1,Math.max(v2,v3));
            currentMinProduct = Math.min(v1,Math.min(v2,v3));
            maxProduct = Math.max(maxProduct,Math.max(currentMaxProduct,currentMinProduct));
        }
        return maxProduct;
    }
}
