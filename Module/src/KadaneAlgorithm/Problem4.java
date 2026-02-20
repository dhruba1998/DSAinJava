package src.KadaneAlgorithm;

public class Problem4 {

    /* 1186. Maximum Subarray Sum with One Deletion
    Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion.
    In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.

Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.*/

    public static int maximumSum(int[] arr) {
        int noDeleteMaxSum = arr[0], oneDeleteMaxSum = 0;
        int maxSum = arr[0];
        int len = arr.length;
        for(int i=1;i<len;i++){
            int preNoDeleteMaxSum = noDeleteMaxSum;
            /* noDeleteMaxSum+arr[i] -> taking all elements including the current arr[i]
            * arr[i] -> ignoring the previous part, consider starting of subarray from current arr[i]*/
            noDeleteMaxSum = Math.max(noDeleteMaxSum+arr[i],arr[i]);
            /* oneDeleteMaxSum -> any one element is deleted previously
            * preNoDeleteMaxSum -> It holds all the elements from 0 to i-1 and don't include the current arr[i]*/
            oneDeleteMaxSum = Math.max(oneDeleteMaxSum+arr[i],preNoDeleteMaxSum);
            /* Finally, compare and update the final result maxSum */
            maxSum = Math.max(maxSum,Math.max(noDeleteMaxSum,oneDeleteMaxSum));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,-2,0,3};
        System.out.println(maximumSum(arr1));
        int[] arr2={-7,6,1,2,1,4,-1};
        System.out.println(maximumSum(arr2));
    }

}
