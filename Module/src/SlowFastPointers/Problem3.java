package src.SlowFastPointers;

public class Problem3 {
    /* 202. Happy Number
    Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
Example 2:

Input: n = 2
Output: false */

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast!=1){
            slow = getSumOfSqrOfDigits(slow);
            fast = getSumOfSqrOfDigits(fast);
            fast = getSumOfSqrOfDigits(fast);
            if(slow == fast && slow!=1){
                return false;
            }
        }
        return true;
    }

    public static int getSumOfSqrOfDigits(int num){
        int sum = 0;
        while(num>0){
            int d = num%10;
            sum+=(d*d);
            num/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(10));
    }

}
