package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    /* 1189. Maximum Number of Balloons
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0*/

    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> have = new HashMap<>();
        for(int i=0;i<text.length();i++){
            have.compute(text.charAt(i), (key,value) -> (value==null) ? 1 : value+1);
        }
        String str = "balloon";
        Map<Character,Integer> need = new HashMap<>();
        for(int i=0;i<str.length();i++){
            need.compute(str.charAt(i),(key,value) -> (value==null) ? 1 : value+1);
        }
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> entry : need.entrySet()){
            int haveCount = have.get(entry.getKey());
            int needCount = need.get(entry.getKey());
            result=Math.min(result,haveCount/needCount);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem3().maxNumberOfBalloons("nlaebolko"));
    }

}
