package src.BinarySearch;

public class Problem8 {

    /* 875. Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour,
she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23*/

    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxBananas=Math.max(maxBananas,piles[i]);
        }
        int low=1,high=maxBananas;
        int minTime=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            int totalTime=0;
            for(int i=0;i<piles.length;i++){
                /*check if piles[i] is odd or even */
                totalTime+=(piles[i]%mid==0 ? piles[i]/mid : piles[i]/mid+1);
                if(totalTime>h){
                    low=mid+1;
                    break;
                }
            }
            if(totalTime<=h){
                minTime=mid;
                high=mid-1;
            }
        }
        return minTime;
    }

}
