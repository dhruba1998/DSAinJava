package src.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //Find triplet sum to zero
    public static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int target = -1 * arr[i];
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum == target){
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                    while(left<arr.length-1 && arr[left]==arr[left-1]){
                        left++;
                    }
                    while(right>i && arr[right]==arr[right+1]){
                        right--;
                    }
                }
                else if(sum<target){
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
        int[] arr1 = {-1,0,1,2,-1,-4};
        int[] arr2 = {0,1,1};
        int[] arr3 = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        System.out.println(threeSum(arr1));
        System.out.println(threeSum(arr2));
        System.out.println(threeSum(arr3));
    }

}
