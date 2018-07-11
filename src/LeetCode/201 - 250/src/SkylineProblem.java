import java.util.*;

public class SkylineProblem {
    /*
    needs a height pq. sort the array base on both the start and the end.
    put it into a collection sort base on start point. 
    start +h, end -h. to know whether it is a start or end.
    iterate thru the sorted collection: if its a start:
    if larger than max height, update and add it to the result. put into pq
    else put into pq.
    
    if its an end: if its the max, poll() from pq, update the max to the top of the pq (offer a 0 first)
    add the new top to the res. (x, max)
    if it is not the max, remove it from pq. (-h)
    

    Corner case:
    end == start: if has a tie in x, put start first, then end.
    start == start: sort base on height;
    
    */
    public List<int[]> getSkyline(int[][] buildings) {
        int height = 0;
        List<int[]> points = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        buildPoints(points, buildings);
        Collections.sort(points, (a, b) -> {
        	// mid the first one is the x and second one is the height. so start height comes first.
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        for(int[] point : points) {
            if(point[1] > 0) pq.offer(point[1]);
            else pq.remove(-point[1]);
            if(pq.peek() != height) {
                height = pq.peek();
                res.add(new int[] {point[0], height});
            }
        }
        return res;
    }
    
    private void buildPoints(List<int[]> points, int[][] buildings) {
        for(int[] b : buildings) {
            points.add(new int[] {b[0], b[2]});
            points.add(new int[] {b[1], -b[2]});
        }
    }
}
