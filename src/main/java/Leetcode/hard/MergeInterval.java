package main.java.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Add the current interval to the list of given intervals and make sure to return the correct number of overlapping
 * intervals.
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{9,10},{12,16}};
        int[] interval = new int[]{4,8};
        int[][] result = insert(intervals, interval);
        for(int a = 0; a < result.length; a++) {
            System.out.println(result[a][0] + "," +result[a][1]);
        }
    }
    static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int startIdx = binarySearch(intervals, newInterval[0], 1);
        int endIdx = binarySearch(intervals, newInterval[1], 0);

        if(startIdx <= endIdx) {
            newInterval[0] = Math.min(newInterval[0], intervals[startIdx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[endIdx][1]);
        }
        int i = 0;

        while(i < startIdx) {
            list.add(intervals[i]);
            i++;
        }
        list.add(newInterval);
        i = endIdx + 1;
        while(i < intervals.length) {
            list.add(intervals[i++]);
        }

        int[][] result = new int[list.size()][2];
        for(int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }

    static int binarySearch(int[][] intervals, int num, int position) {
        int low = 0; int high = intervals.length;
        while(low < high) {
            int mid = (low + high)/2;
            if(intervals[mid][position] == num) return mid;
            if(intervals[mid][position] > num) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        if(position == 1) {
            return low; //index of the interval's end point bigger than newInterval.start
        }
        return low-1;  // index of the interval's start point less than newInterval.end
    }
}
