package src.SildingWindow;

public class Test {

    public static void main(String[] args) {

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int[] arr = {30,40,50,10,50};
        int target = 80;
        for(int right=0;right<arr.length;right++){
            currSum+=arr[right];
            while (currSum>target){
                minLen = Math.min(minLen,right-left+1);
                currSum-=arr[left++];
            }

        }
        System.out.println(minLen);
    }

}
