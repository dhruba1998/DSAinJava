package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    /* 383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true*/

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
//            hashMap.compute(magazine.charAt(i), (key,value) -> (value==null) ? 1 : value+1);
            Character ch = magazine.charAt(i);
            if(hashMap.containsKey(ch)){
                hashMap.put(ch,hashMap.get(ch)+1);
            }
            else {
                hashMap.put(ch,1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(hashMap.get(ransomNote.charAt(i))>0){
                hashMap.put(ransomNote.charAt(i),hashMap.get(ransomNote.charAt(i))-1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem4().canConstruct("aa","aab"));
    }

}
