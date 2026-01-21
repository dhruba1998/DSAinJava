package src.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosestTarget {

    public static int threeSumClosest(int[] arr, int target){
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum==target){
                    return sum;
                }
                int currentAbsDiff = Math.abs(sum-target);
                if(currentAbsDiff<minAbsDiff){
                    minAbsDiff = currentAbsDiff;
                    result = sum;
                }
                if(sum < target){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1={-1,2,1,-4};
        int[] arr2={0,0,0};
        System.out.println(threeSumClosest(arr1,1));
        System.out.println(threeSumClosest(arr2,0));
    }

}
