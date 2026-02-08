package src.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem5 {

    /* Meeting Rooms II(GFG) --- NOT FULLY SOLVED
    Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting.
    Return the minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.

Examples:

Input: start[] = [1, 10, 7], end[] = [4, 15, 10]
Output: 1
Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.
Input: start[] = [2, 9, 6], end[] = [4, 12, 10]
Output: 2
Explanation: 1st and 2nd meetings at one room but for 3rd meeting one another room required.*/

    public static void main(String[] args) {
        int[] start = new int[]{25,0,14,24,18,3,17};
        int[] end = new int[]{29,25,24,26,25,23,18};
        Problem5 problem5 = new Problem5();
        problem5.minMeetingRooms(start,end);
    }

    public int minMeetingRooms(int[] start, int[] end) {
        int[][] list = new int[start.length][];
        for(int i=0;i<start.length;i++){
            list[i]=new int[]{start[i],end[i]};
        }
        Arrays.sort(list, Comparator.comparingInt(a->a[0]));
        int maxCount = 1, count=1;
        int start1=list[0][0];
        int end1=list[0][1];
        for(int i=1;i<start.length;i++){
            int start2=list[i][0];
            int end2=list[i][1];
            if(end1>start2){
                count++;
                maxCount=Math.max(maxCount,count);
            }
            else {
                start1=start2;
                end1=end2;
                count=1;
            }
        }
        return maxCount;
    }

}
