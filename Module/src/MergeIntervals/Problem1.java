package src.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1 {

    /* 56. Merge Intervals
    Given an array of intervals where intervals[i] = [starti, endi],
    merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping. */

    public int[][] merge(int[][] intervals) {

        // Sort the intervals based on their start time. This is a crucial step.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Check if the next interval overlaps with the current merged interval
            if (nextStart <= end) {
                // If there is an overlap, extend the end of the current merged interval
                end = Math.max(end, nextEnd);
            } else {
                // If there is no overlap, the current merged interval is complete. Add it to the list.
                mergedList.add(new int[]{start, end});
                // Start a new merged interval
                start = nextStart;
                end = nextEnd;
            }
        }

        // Add the very last merged interval to the list
        mergedList.add(new int[]{start, end});

        // Convert the list of int[] arrays into a 2D array (int[][]) and return it.
        return mergedList.toArray(new int[mergedList.size()][]);
    }

}
