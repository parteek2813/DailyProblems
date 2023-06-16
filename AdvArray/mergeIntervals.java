package AdvArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}


public class mergeIntervals {

    static List<Interval> mergeIntervals(List<Interval> intervals ){
        // Sort intervals based on the start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new ArrayList<>();

        // Store the current interval first
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            // Check if the intervals overlap
            if (interval.start <= currentInterval.end) {
                // Update the end time of the current interval
                currentInterval.end = Math.max(currentInterval.end, interval.end);
            } else {
                // Intervals don't overlap, add the current interval to the result list
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last interval to the result list
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }
    public static void main(String[] args) {
        // Example usage
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> merged = mergeIntervals(intervals);

        System.out.println("Initial Intervals are:");
        System.out.println(Arrays.toString(intervals.toArray()));


        System.out.println("Merged Intervals are:");

        // Print the merged intervals
        for (Interval interval : merged) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
