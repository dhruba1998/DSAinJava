package src.BinarySearch;

public class Problem14 {

    /*Find Kth Rotation
Difficulty: EasyAccuracy: 23.16%Submissions: 347K+Points: 2Average Time: 20m
Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]

Examples:

Input: arr[] = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
Input: arr = [1, 2, 3, 4, 5]
Output: 0
Explanation: The given array is not rotated.*/

    public int findKRotation(int arr[]) {
        int n=arr.length;
        // if(arr[0]<arr[n-1]) return 0;
        int low=0,high=n-1;
        int ans = -1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>arr[n-1]){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }

}
