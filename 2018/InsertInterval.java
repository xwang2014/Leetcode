

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
        
        int idx = 0;
        
        while (idx < intervals.size() && intervals.get(idx).end < newInterval.start) {
            ans.add(intervals.get(idx));
            idx += 1;
        }
    
        while (idx < intervals.size() && overlap(intervals.get(idx), newInterval) ) {
            newInterval = merge(intervals.get(idx), newInterval);
            idx += 1;
        }
        
        ans.add(newInterval);
        
        while (idx < intervals.size()) {
            ans.add(intervals.get(idx));
            idx += 1;
        }
        
        return ans;
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

