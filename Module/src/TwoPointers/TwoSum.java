package src.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * This method finds two numbers in an array that add up to a specific target.
     * It uses a HashMap to store the numbers and their indices for efficient lookup.
     *
     * @param arr    The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that sum up to the target.
     *         Returns {-1, -1} if no such pair is found.
     */
    public static int[] twoSum(int[] arr, int target){
        // Create a HashMap to store each number and its index.
        Map<Integer,Integer> map = new HashMap<>();
        // Populate the HashMap with the array elements.
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        // Iterate through the array again to find the complement for each number.
        for(int i=0;i<arr.length;i++){
            int complement = target - arr[i];
            // Check if the complement exists in the map and it's not the current element itself.
            if(map.containsKey(complement) && map.get(complement) != i){
                // If found, return the indices of the current element and its complement.
                return new int[]{i, map.get(complement)};
            }
        }
        // If no two numbers sum up to the target, return {-1, -1}.
        return new int[]{-1,-1};
    }

    public static int[] twoSumWithOneItr(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement = target - arr[i];
            if(map.containsKey(complement) & map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 11, 7};
        int target = 9;
        int[] result = twoSum(arr, target);
        // Print the result.
        if (result[0] != -1) {
            System.out.println("Two indices are " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }

        int[] results = twoSumWithOneItr(arr, target);
        System.out.println("Using one iteration: " + results[0] + " and " + results[1]);
    }
}
