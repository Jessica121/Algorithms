import java.util.*;
import java.util.ArrayList;
public class SkylineProblem {
    /*
    Use three priority queues, min heap, one for start, height and one for end, height, one for the height currently in range 0 - x => can reduce to two as the start and end put together, h for start and end for -h
    hright pq. offer a zero first.
    one a start encountered, add the height into height pq, once end encountered, remove the height
    while pq is not empty, x start from 0, 
    if x == start, check height. add the height into height pq. poll the start. if height > max, add (x, height), update max height.
    if x == end, check its height, remove from the height pq. if it is max, remove the max height from height pq, add (x, new top of height pq) to the result, update the max of height.
    
    */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Integer> height = new PriorityQueue<>((a, b) -> b - a);
        height.offer(0);
        PriorityQueue<int[]> coor = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1]; // put start at the front if x is both a start and an end.
        });
        buildPq(buildings, coor);
        int max = 0;
        while(!coor.isEmpty()) {
            int[] coordinate = coor.poll();
            if(coordinate[1] > 0) {
                height.offer(coordinate[1]);
                if(height.peek() > max) {
                    max = height.peek();
                    res.add(new int[] {coordinate[0], max});
                }
            } else {
            	// remove the height should be neg back.
                height.remove(-coordinate[1]);
                if(height.peek() < max) {
                    max = height.peek();
                    res.add(new int[] {coordinate[0], max});
                }
            }
        }
        return res;
    }
    
    private void buildPq(int[][] buildings, PriorityQueue<int[]> coor) {
        for(int[] building : buildings) {
            coor.offer(new int[] {building[0], building[2]});
            coor.offer(new int[] {building[1], -building[2]});
        }
    }
}
