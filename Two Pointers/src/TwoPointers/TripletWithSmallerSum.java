package src.TwoPointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

    public static int tripletWithSmallerSum(int[] arr, int sum){
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length - 1;
            while(left<right){
                int currentSum = arr[i]+arr[left]+arr[right];
                if(currentSum>=sum){
                    right--;
                }
                else {
                    count+=(right-left);
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 0, 1, 3};
        int[] arr2 = {5, 1, 3, 4, 7};//1,3,4,5,7
        System.out.println(tripletWithSmallerSum(arr1,2));
        System.out.println(tripletWithSmallerSum(arr2,12));
    }
}
