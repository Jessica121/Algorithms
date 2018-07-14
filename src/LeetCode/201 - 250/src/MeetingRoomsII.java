import java.util.*;
public class MeetingRoomsII {
    /*
    sort the array based on the start points, then iterate the res array, if not overlap, meaning the last < start, then merge, by changing the last to this last. break. if to the end not get merged, add itself to the res.
    return the res size.
    n^2 + n lgn = n ^ 2 time
    
    */
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> (a.start - b.start));
        List<Interval> res = new ArrayList<>();
        boolean merged = false;
        for(Interval inter : intervals) {
            merged = false;
            for(Interval i : res) {
                if(merged) break;
                if(i.end <= inter.start){
                    i.end = inter.end;
                    merged = true;
                } 
            }
            if(!merged) res.add(inter);
        }
        return res.size();
    }
}
