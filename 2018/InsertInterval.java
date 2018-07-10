

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> ans = new ArrayList<Interval>();
        
        int pos = findPosition(intervals, newInterval);
        
        intervals.add(pos, newInterval);
        
        boolean merged = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (i < intervals.size() - 1 && overlap(intervals.get(i), intervals.get(i + 1))) {
                Interval temp = merge(intervals.get(i), intervals.get(i + 1));
                intervals.set(i + 1, temp);
            } else {
                ans.add(intervals.get(i));
            }
        }
        
        
        return ans;
    }
    
    
    private int findPosition(List<Interval> intervals, Interval in) {
        if (intervals.size() == 0) return 0;
        
        int left = 0, right = intervals.size() - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Interval m = intervals.get(mid);
            
            if (m.start >= in.start) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (intervals.get(left).start >= in.start) {
            return left;
        } else if (intervals.get(left).start < in.start && intervals.get(right).start >= in.start) {
            return right;
        } else {
            return right + 1;
        }
    }
    
    private boolean overlap(Interval in1, Interval in2) {
        return !(in1.start > in2.end || in1.end < in2.start);
    }
    
    private Interval merge(Interval in1, Interval in2) {
        return new Interval(
                        Math.min(in1.start, in2.start),
                        Math.max(in1.end, in2.end)
                        );
    }
}

