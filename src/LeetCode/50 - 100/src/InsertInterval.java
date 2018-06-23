import java.util.*;

public class InsertInterval {
    /*
    function that has distinct steps. with one overall operation would not do it.
    three steps: 1. find the place to insert. interval <= end || > end && start < next's start
                 2. insert or merge.
                 3. keep the pointer, merge the rest. 
                 
    */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> res = new ArrayList<>();
        while(i < intervals.size()) {
            if(newInterval.start > intervals.get(i).start) {
                res.add(intervals.get(i));
                i++;
            } else break;
        }
        
        // need to merge the before add. 
        if(res.size() > 0 && newInterval.start <= res.get(res.size() - 1).end) {
            res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, newInterval.end);
        } else res.add(newInterval);
        
        while(i < intervals.size()) {
            if(intervals.get(i).start <= res.get(res.size() - 1).end) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            } else res.add(intervals.get(i));
            i++;
        }
        
        return res;
    }
}
