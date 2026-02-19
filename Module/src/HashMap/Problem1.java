package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    
    /* 409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.*/

    public int longestPalindrome(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                map.compute(s.charAt(i), (key,value) -> (value == null) ? 1 : value + 1);
            }
            int palindromeLen = 0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(entry.getValue()%2==0){
                    palindromeLen+=entry.getValue();
                }
                else {
                    palindromeLen+=(entry.getValue()-1);
                }
            }
            if(palindromeLen == s.length()){
                return palindromeLen;
            }
            return palindromeLen + 1;
    }

}
