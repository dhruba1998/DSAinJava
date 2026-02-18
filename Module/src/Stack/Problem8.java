package src.Stack;

import java.util.*;

record Pair<K,V>(K key,V value){}
public class Problem8 {

    /* 1209. Remove All Adjacent Duplicates in String II
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.


Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"*/


    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character,Integer>> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek().key().equals(s.charAt(i)) && stack.peek().value().equals(k-1)){
                stack.pop();
            }
            else if(!stack.isEmpty() && stack.peek().key().equals(s.charAt(i))){
                Pair<Character,Integer> pair = new Pair<>(s.charAt(i), stack.peek().value()+1);
                stack.pop();
                stack.push(pair);
            }
            else {
                stack.push(new Pair<>(s.charAt(i),1));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            Character ch = stack.peek().key();
            int count = stack.peek().value();
            while (count!=0){
                stringBuilder.append(ch);
                count--;
            }
            stack.pop();
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem8().removeDuplicates("abcd",2));
    }

}
