package main.java.Leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a list of start and end times as an array list, find the minimum number of meeting rooms that is needed
 */
public class MeetingRoomsII {
    public static void main(String[] args) {

    }
     static int numOfMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }

         Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

         PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));

         minHeap.add(intervals[0]);

         for (int i = 1; i < intervals.length; i++) {
             Interval current = intervals[i];
             Interval earliest = minHeap.remove();

             if(current.start >= earliest.end) {
                 earliest.end = current.end;
             } else {
                 minHeap.add(current);
             }
             minHeap.add(earliest);
         }

         return minHeap.size();
     }
}
