package src.BinarySearch;

public class Problem7 {

    /* 33. Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1*/

    public int search(int[] nums, int target) {
        // 4,5,6,7,0,1,2 for this arr 4,5,6,7 are part of part2 and 0,1,2 part are of part1
        // 1,2,3,4 for this arr 1,2,3,4 all are part of part1
        int n=nums.length;
        int low=0,high=n-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target>nums[n-1]){
                //searching in part2
                if(nums[mid]<nums[n-1]){
                    // mid is currently in part1, move it to part2
                    high=mid-1;
                }
                else{
                    //we are in currect part(part2) and need to find the parget
                    if(nums[mid]<target){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
            else{
                // searching in part1
                if(nums[mid]>nums[n-1]){
                    // mid is in part2, move it to part1
                    low=mid+1;
                }
                else{
                    // we are in correct part(part1), need to find target
                    if(nums[mid]<target){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
        }
        return -1;
    }

}
