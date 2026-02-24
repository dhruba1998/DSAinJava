package src.BinarySearch;

public class Problem4 {

    /* Number of occurrence (https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1)
Given a sorted array, arr[] and a number target,
you need to find the number of occurrences of target in arr[].

Examples :
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.*/

    int countFreq(int[] arr, int target) {
        int leftIdx=-1,rightIdx=-1;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                leftIdx=mid;
                high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        low=0;
        high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                rightIdx=mid;
                low=mid+1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return leftIdx ==-1 ? 0 : rightIdx-leftIdx+1;
    }

}
