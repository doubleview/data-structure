package leetcode_algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class q056_MergeIntevals {

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        System.out.println(new q056_MergeIntevals().merge(Arrays.asList(i1, i2, i3, i4)));
    }

    /**
     * 解法1(个人解法)
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> Integer.compare(o1.start, o2.start));
        Interval p = null;
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (p == null || interval.start > p.end) {
                result.add(interval);
                p = interval;
            } else if (interval.end > p.end) {
                p.end = interval.end;
            }
        }
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



