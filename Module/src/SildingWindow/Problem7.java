package src.SildingWindow;

import java.util.HashMap;
import java.util.Map;

public class Problem7 {

    /*
    76. Minimum Window Substring (Leetcode)

Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
    */

    public static String minWindow(String s, String t){
        if(t.length()>s.length()){
            return "";
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character,Integer> tHashMap = new HashMap<>();
        HashMap<Character,Integer> sHashMap = new HashMap<>();
        for (int i=left;i<=t.length()-1;i++){
            if(!tHashMap.containsKey(t.charAt(i))){
                tHashMap.put(t.charAt(i),1);
            }else {
                tHashMap.put(t.charAt(i),tHashMap.get(t.charAt(i))+1);
            }
//            if(!sHashMap.containsKey(s.charAt(i))){
//                sHashMap.put(s.charAt(i),1);
//            }else {
//                sHashMap.put(s.charAt(i),sHashMap.get(s.charAt(i))+1);
//            }
        }
        int start = 0;
//        if(isValidMap(sHashMap,tHashMap)){
//            minLen = t.length();
//        }
        for(int right=0;right<s.length();right++){
            if(!sHashMap.containsKey(s.charAt(right))){
                sHashMap.put(s.charAt(right),1);
            }else {
                sHashMap.put(s.charAt(right),sHashMap.get(s.charAt(right))+1);
            }
            while (isValidMap(sHashMap,tHashMap)){
                if(minLen>right-left+1){
                    minLen = right-left+1;
                    start=left;
                }
                sHashMap.put(s.charAt(left),sHashMap.get(s.charAt(left))-1);
                if(sHashMap.get(s.charAt(left))==0){
                    sHashMap.remove(s.charAt(left));
                }
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLen);
    }

    public static boolean isValidMap(HashMap<Character,Integer> shashMap,
                                     HashMap<Character,Integer> thashMap){
        for(Map.Entry<Character,Integer> entry : thashMap.entrySet()){
            if(!shashMap.containsKey(entry.getKey()) || shashMap.get(entry.getKey())<entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
        String s1 = "a";
        String t1 = "a";
        System.out.println(minWindow(s1,t1));
        String s2 = "a";
        String t2 = "b";
        System.out.println(minWindow(s2,t2));
        String s3 = "ab";
        String t3 = "a";
        System.out.println(minWindow(s3,t3));
        String s4 = "cabwefgewcwaefgcf";
        String t4 = "cae";
        System.out.println(minWindow(s4,t4));
    }

}
