import java.util.*;
public class ContainsDuplicateII {
    /*
    hashmap?
    if exist, compare the index i - map.get(i) <= k 
    tricky part is there could be multiple 1s, dont know which index to store is the most appropriate.
    but since the diff requires at most k, then store the most recent one is best.
    so if distant > k, update the map with current index i.
    if not exist, put it.
    
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            } else  map.put(nums[i], i);
        }
        return false;
    }
    
    /*
    compare to the last intuitive one, what is really slow is when checking one by one for the interval to merge with.
    so if the earlist finished meeting in the res cannot merge with the current one, none of the rest can.
    use a min heap to maintain res rather than list.
    compare with the min end interval, if not overlap, merge. else add it to the res.
    it is because intervals are sorted based on start time, it will not happend when it merged with a gap that later intervals can fit in. else that one will come first.
    even if there are two intervals can merge with the current smallest end one, if they dont overlap, they can merge together, if they do, only one of them can merge, its not affecting the overall result. 
    
    */
    public int minMeetingRoomsPQ(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> (a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end - b.end));
        for(Interval inter : intervals) {
            if(pq.size() == 0) pq.offer(inter);
            else {
                Interval top = pq.poll();
                if(top.end <= inter.start) top.end = inter.end;
                else pq.offer(inter);
                // so it will only sort when offering, so cannot change directly the head and wish it could sort like that. no.
                pq.offer(top);
            }
        }
        return pq.size();
    }
}
