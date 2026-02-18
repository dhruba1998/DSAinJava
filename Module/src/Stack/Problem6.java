package src.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem6 {

    /* 739. Daily Temperatures
Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]*/

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        stack.push(new int[]{temperatures[temperatures.length-1],temperatures.length-1});
        result[temperatures.length-1]=0;
        for(int i=temperatures.length-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()[0]<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=0;
                stack.push(new int[]{temperatures[i],i});
            }
            else {
                result[i]=stack.peek()[1]-i;
                stack.push(new int[]{temperatures[i],i});
            }
        }
        return result;
    }

}
