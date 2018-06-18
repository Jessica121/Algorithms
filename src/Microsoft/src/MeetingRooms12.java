import java.util.*;
import java.util.ArrayList;
public class MeetingRooms12 {
    /*
    If a person can attend all meetings:
    sort the arrays based on start point, start from second element, if start < prev end return false
    */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a.start != b.start) return a.start - b.start;
            else return a.end - b.end;
        });
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
    
    /*
    sort intervals base on starting time, 
    Have a list of different rooms, for each interval, check the rooms of intervals one by one, if not overlap, meaning the start >= this.end, merge them, making this.end is current interval's end, break;
    if till the end could ot find a room to merge with, add this interval and increase the number of rooms. => the room list will be sorted base on start time as the intervals are checked in the sorted order.
    return the size of the room list.
    */
    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> rooms = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a.start != b.start) return a.start - b.start;
            else return a.end - b.end;
        });
        for(int i = 0; i < intervals.length; i++) {
            if(rooms.size() == 0 || !canMerge(rooms, intervals[i])) {
                rooms.add(intervals[i]);
            }
        }
        return rooms.size();
    }
    
    /* Can merge will check if can merge into any of the exisitng room, if so, merge already, else return false*/
    private boolean canMerge(List<Interval> rooms, Interval interval) {
        for(Interval room : rooms) {
            if(room.end <= interval.start) {
                room.end = interval.end;
                return true;
            }
        }
        return false;
    }
    
    
    /*
    start time and end time sort 
    for each start time, check the min end time, if smaller, add 1 room and advance start time
    if larger, then use this end time's room, meaning this end time will surely greater than this current reused one, so advance the end time, and the stat time, no adding the room.
    work till the start time went out.
    what kind of thinking it applies?
    Waht else it applies?
    
    */
    public int minMeetingRoomsTwo(Interval[] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        buildArrays(intervals, start, end);
        int ptr1 = 0, ptr2 = 0, rooms = 0;
        while(ptr1 < start.length) {
            if(start[ptr1] >= end[ptr2]) ptr2++;
            else rooms++;
            ptr1++;
        }
        return rooms;
    }
    
    private void buildArrays(Interval[] total, int[] start, int[] end) {
        for(int i = 0; i < total.length; i++) {
            start[i] = total[i].start;
            end[i] = total[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
    }
}
