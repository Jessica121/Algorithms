import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class MaxNumOfPointsInaLine {
    /*
      NOT REALLY WORKING VERSION CUZ OF THE DUP DOTS.
    use a hashmap track the delta and the numbers in it. update the max along the way.
    delta = (p1.x - p2.x) / (p1.y - p2.y)
    since multiple lines could have the same k (delta), save in the map both the y intersect and the k.
    also for each starting point, only one k will be added. else multiple add will occur later, set: multiple k. 
    n^2. time and space.
    */
    public int maxPoints(Point[] points) {
        if(points.length <= 1) return points.length;
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < points.length - 1; i++) {
            set = new HashSet<>();
            for(int j = i + 1; j < points.length; j++) {
                int k = calculateDelta(points[i], points[j]);
                int b = calculateYIntersect(points[i], k);
                String key = new String(k + "," + b);
                if(!set.contains(k)) {
                    set.add(k);
                    map.put(key, map.getOrDefault(key, 1) + 1);
                }
                max = Math.max(map.get(key), max);
            }
        }
        return max;
    }
    
    private int calculateDelta(Point a, Point b) {
        return a.x == b.x ? Integer.MAX_VALUE : (a.y - b.y) / (a.x - b.x);
    }
    
    private int calculateYIntersect(Point p, int k) {
        return k == Integer.MAX_VALUE ? Integer.MAX_VALUE : p.y - k * p.x;
    }
    
    /*
    do it level by level since on different starting point may have same line will over-count.
    if points are the same, record same number of points.
    else calculate the k. if horizontal, k = MAX.
    count start from this point, how many points are in the same k. (must be in same line then) add with same point
    use a map for each level to track that, and update. N^2
    
    */
    public int maxPointsAlmostCorrectExceptTunicatingK(Point[] points) {
        if(points.length <= 1) return points.length;
        Map<Double, Integer> map = new HashMap<>();
        int sameP = 0, res = 0;
        for(int i = 0; i < points.length - 1; i++) {
            map.clear();
            sameP = 0;
            for(int j = i + 1; j < points.length; j++) {
                if(samePoint(points[i], points[j])) sameP++;
                else {
                    double k = calculateDelta(points[i], points[j]);
                    map.put(k, map.getOrDefault(k, 1) + 1);
                }
            }
            System.out.println(map);
            for(double key : map.keySet()) {
                res = Math.max(res, map.get(key) + sameP);
            }
            res = Math.max(res, sameP + 1);
        }
        return res;
    }
    
    private boolean samePoint(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }
    // correct way to get the slope but not much of a difference.
    private BigDecimal getSlope(Point a, Point b){
        if(b.x == a.x){
           return BigDecimal.valueOf(Integer.MAX_VALUE);
        }
        return BigDecimal.valueOf(b.y - a.y).divide(BigDecimal.valueOf(b.x - a.x), new MathContext(20));
    } 
    
    private  class Point {
    	int x;
    	int y;
    	Point() { x = 0; y = 0; }
    	Point(int a, int b) { x = a; y = b; }
    }
}
