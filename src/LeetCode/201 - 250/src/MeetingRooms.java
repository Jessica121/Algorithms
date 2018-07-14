import java.util.Arrays;

public class MeetingRooms {
    /*
    sort it based on starting point, and if start < prev end, return false
    corner : no meeting.
    */
    public boolean canAttendMeetings(Interval[] intervals) {
    	// it is an array not collection.
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for(int i = 0; i < intervals.length; i++) {
            if(i > 0 && intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
