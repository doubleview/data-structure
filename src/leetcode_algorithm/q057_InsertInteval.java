package leetcode_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class q057_InsertInteval {


    public static void main(String[] args) {
        List<Interval> source = new ArrayList<>();
        source.add(new Interval(1, 2));
        source.add(new Interval(3, 5));
        source.add(new Interval(6, 7));
        source.add(new Interval(8, 10));
        source.add(new Interval(12, 16));
        System.out.println(new q057_InsertInteval().insert(source, new Interval(4, 9)));
    }

    /**
     * 解法1(个人解法)
     *
     * @param intervals
     * @param interval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval interval) {
        List<Interval> result = new ArrayList<>();
        boolean saveInterval = false;
        for (Interval i : intervals) {
            if (interval.start > i.end) {
                result.add(i);
                continue;
            }
            if (interval.end < i.start) {
                if (!saveInterval) {
                    result.add(interval);
                    saveInterval = true;
                }
                result.add(i);
                continue;
            }
            if (interval.start <= i.end) {
                interval.start = Math.min(interval.start, i.start);
            }
            if (interval.end >= i.start) {
                interval.end = Math.max(interval.end, i.end);
            }
        }
        if (!saveInterval) result.add(interval);
        return result;
    }


    /**
     * 解法2(推荐解法)
     *
     * @param intervals
     * @param newINterval
     * @return
     */
    public List<Interval> insert2(List<Interval> intervals, Interval newINterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newINterval.start)
            result.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newINterval.end) {
            newINterval = new Interval(Math.min(newINterval.start, intervals.get(i).start),
                    Math.max(newINterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newINterval);
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}


