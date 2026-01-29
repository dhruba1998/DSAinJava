package src.SildingWindow;

import java.util.HashMap;

public class Problem8 {

    /* 3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,right=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                while(map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>0){
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    if(map.get(s.charAt(left))==0){
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
                map.put(s.charAt(right),1);
            }
            else{
                map.put(s.charAt(right),1);
            }
            maxLen = Math.max(maxLen,map.size());
            right++;
        }
        return maxLen;
    }

}
