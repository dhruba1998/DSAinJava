package src.SildingWindow;

import java.util.HashMap;

public class Problem4 {

    /*
You are visiting a farm that has a single row of fruit trees arranged from left to right.
The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit.
There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].


Problem boils down to: Find the longest substring with at most 2 distinct elements
 */

    public static int totalFruit(int[] fruits){
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            if(!hashMap.containsKey(fruits[right])){
                hashMap.put(fruits[right],1);
            }else {
                hashMap.put(fruits[right], hashMap.get(fruits[right])+1);
            }
            while (hashMap.size()>2){
                hashMap.put(fruits[left], hashMap.get(fruits[left])-1);
                if(hashMap.get(fruits[left])==0){
                    hashMap.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits1 = {1,2,1};
        System.out.println(totalFruit(fruits1));
        int[] fruits2 = {0,1,2,2};
        System.out.println(totalFruit(fruits2));
        int[] fruits3 = {1,2,3,2,2};
        System.out.println(totalFruit(fruits3));
    }
}
