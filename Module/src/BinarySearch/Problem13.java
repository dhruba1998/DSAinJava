package src.BinarySearch;

public class Problem13 {

    /* Find position of an element in a sorted array of infinite numbers (https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/)
Given a sorted array arr[] of infinite numbers.
The task is to search for an element k in the array.

Examples:

Input: arr[] = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170], k = 10
Output: 4
Explanation: 10 is at index 4 in array.

Input: arr[] = [2, 5, 7, 9], k = 3
Output: -1
Explanation: 3 is not present in array.*/

    private int getVal(int idx){
        /* Assume below is infinite size of array */
        int[] arr = new int[]{1,3,5,7,8,10,14,17,19,21,25,27,30,45,67};
        return arr[idx];
    }

    public int searchInInfiniteArray(int target){
        /* There is a helper function which accepts single integer(the index)
        and returns the value of that index eg: get(int idx) and the array will not be directly accessible*/

        int low=0,high=1;
        while(getVal(high)<target){
            low=high;
            high*=2;
        }
        /* If we are here that means we found the range*/
        while(low<=high){
            int mid=(low+high)/2;
            if(getVal(mid)==target){
                return mid;
            }
            else if(getVal(mid)<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

}
