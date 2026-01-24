package src.SildingWindow;

public class MaxSumSubarray {

    // 2 Pointers with fixed window size
    public static int maxSumSubarray(int[] arr, int k){
        int low = 0;
        int high = k-1;
        int currentSum = 0;
        int maxSum = 0;
        if(k>arr.length){
            return -1;
        }
        for(int i=low;i<=high;i++){
            currentSum+=arr[i];
        }
        maxSum = Math.max(currentSum, maxSum);
        for(int i = 1;i<=arr.length-k;i++){
            currentSum = currentSum - arr[i-1] + arr[++high];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        System.out.println(maxSumSubarray(arr,2));
    }
}
