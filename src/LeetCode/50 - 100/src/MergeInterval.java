import java.util.*;
public class MergeInterval {
    /*
    Sort the intervals based on start point.
    add to res if its the first interval or it not overlaps with the last one in the res.
    if it does, merge.
    
    */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        for(Interval interval : intervals) {
            if(res.isEmpty() || interval.start > res.get(res.size() - 1).end) res.add(interval);
            // the end could be less than the prev of the last res.
            else res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, interval.end);
        }
        return res;
    }
    
}
