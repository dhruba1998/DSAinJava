package src.SildingWindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Problem5 {

    /*
    You are given a string s and an integer k.
    You can choose any character of the string and change it to any other uppercase English character.
    You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
     */

    //Using TreeMap(Sorted hashMap) treeMap complexity O(logn)
    public static int characterReplacement(String s, int k){
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for(int right=0;right<s.length();right++){
            if(!treeMap.containsKey(s.charAt(right))){
                treeMap.put(s.charAt(right),1);
            }else {
                treeMap.put(s.charAt(right),treeMap.get(s.charAt(right))+1);
            }
            int len = right - left + 1;
            int maxCount = treeMap.values()
                    .stream().max(Comparator.naturalOrder()).get();
            int diff = len - maxCount;
            while (diff > k){
                treeMap.put(s.charAt(left),treeMap.get(s.charAt(left))-1);
                if(treeMap.get(s.charAt(left))==0){
                    treeMap.remove(s.charAt(left));
                }
                left++;
                diff--;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    //Using temp array to find the maxCount
    public static int characterReplacementUsingTempArr(String s, int k){
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        int[] arr = new int[26];
        for(int right=0;right<s.length();right++){
            arr[s.charAt(right)-65]++;
            int len = right - left + 1;
            int maxCount = maxCountValue(arr);
            int diff = len - maxCount;
            while (diff > k){
                arr[s.charAt(left)-65]--;
                left++;
                diff--;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static int maxCountValue(int[] temp){
       return Arrays.stream(temp).max().getAsInt();
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(characterReplacement(s1,k1));
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(characterReplacement(s2,k2));
        String s3 = "ABBB";
        int k3 = 2;
        System.out.println(characterReplacement(s3,k3));
        String s4 = "BAAAB";
        int k4 = 2;
        System.out.println(characterReplacement(s4,k4));
        System.out.println(characterReplacementUsingTempArr(s4,k4));
    }

}
