package src.SildingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class Problem3 {

    /*You are given a string s consisting only lowercase alphabets and an integer k.
     Your task is to find the length of the longest substring that contains exactly k distinct characters.
     Note : If no such substring exists, return -1.
     Input: s = "aabacbebebe", k = 3
     Output: 7
     Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
    */
    public static int longestKSubstr(String s,int k){
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int right=0;right<s.length();right++){
            if(!hashMap.containsKey(s.charAt(right))){
                hashMap.put(s.charAt(right),1);
            }else {
                hashMap.put(s.charAt(right),hashMap.get(s.charAt(right))+1);
            }
            while(hashMap.size()>k){
                hashMap.put(s.charAt(left),hashMap.get(s.charAt(left))-1);
                if(hashMap.get(s.charAt(left))==0){
                    hashMap.remove(s.charAt(left));
                }
                left++;
            }
            if(hashMap.size()==k){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        if(maxLen<0){
            return -1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "aabacbebebe";
        int k1 = 3;
        System.out.println(longestKSubstr(s1,k1));

        String s2 = "aaaa";
        int k2 = 2;
        System.out.println(longestKSubstr(s2,k2));
    }

}
