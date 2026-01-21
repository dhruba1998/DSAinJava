package src.TwoPointers;

public class RemoveDuplicate {

    //Remove duplicate from sorted array and return count of unique elements
    public static int removeDuplicate(int[] arr){
        int arrLen = arr.length;
        if(arrLen == 1){
            return 1;
        }
        int left = 0;
        int right = 1;
        while(right < arrLen){
            if(arr[right]!=arr[left]){
                arr[left+1]=arr[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,2,2,4,4,4,6,7};
        int[] arr2 = {1,1,1,1,1};
        System.out.println(removeDuplicate(arr1));
        System.out.println(removeDuplicate(arr2));
    }
}
