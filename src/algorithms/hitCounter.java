package algorithms;
import java.util.*;
public class hitCounter {
/*
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). 
You may assume that the earliest timestamp starts at 1. 
It is possible that several hits arrive roughly at the same time.

 * */
	public static void main(String[] args) {
		hitCounter counter = new hitCounter();
		// hit at timestamp 1.
		counter.hit(1);
		// hit at timestamp 2.
		counter.hit(2);
		// hit at timestamp 3.
		counter.hit(3);
		// get hits at timestamp 4, should return 3.
		System.out.println(counter.getHits(4));
		// hit at timestamp 300.
		counter.hit(300);
		// get hits at timestamp 300, should return 4.
		System.out.println(counter.getHits(300));
		// get hits at timestamp 301, should return 3.
		System.out.println(counter.getHits(301));
	}
	
    Queue<Integer> que;
    // update the map for the num of hits have till now.
    // get hit substract the current with get hits cure - 300 recursively
    
    public hitCounter() {
        que = new LinkedList<>();
    }
    
    public void hit(int time) {
        que.offer(time);
        if(time - que.element() >= 300) que.poll();
    }
    
    public int getHits(int time) {
    	while(!que.isEmpty() && time - que.peek() >= 300) {
    		que.poll();
    	}
    	return que.size();
    }

}
