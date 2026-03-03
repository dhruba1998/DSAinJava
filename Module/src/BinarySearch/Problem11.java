package src.BinarySearch;

import java.util.Arrays;

public class Problem11 {

    /* Aggressive Cows (https://www.geeksforgeeks.org/problems/aggressive-cows/1)
You are given an array with unique elements of stalls[],
which denote the positions of stalls.
You are also given an integer k which denotes the number of aggressive cows.
The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples:
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows in this case is 3, which is the largest among all possible ways.

Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.

Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance between any two cows is as large as possible.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.*/

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int low=1,high=stalls[n-1]-stalls[0];
        int result=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(areAllCowsPlaced(stalls,k,mid)){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }

    public boolean areAllCowsPlaced(int[] stalls,int k,int guess){
        int cows=1;
        int prevPos=stalls[0];
        for(int i=1;i<stalls.length;i++){
            int dist = stalls[i]-prevPos;
            if(dist<guess){
                continue;
            }
            cows++;
            if(cows==k){
                return true;
            }
            prevPos=stalls[i];
        }
        return false;
    }
}