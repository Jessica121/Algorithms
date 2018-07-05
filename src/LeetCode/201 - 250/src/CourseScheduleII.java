import java.util.*;
public class CourseScheduleII {
    /*
    same as first one, just print it.
    have a ptr iterating the array.
    
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int cnt = 0;
        int[] dep = new int[numCourses], res = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        initRelationMap(map, prerequisites, dep);
        Queue<Integer> que = new LinkedList<>();
        initQueue(que, dep);
        while(!que.isEmpty()) {
            res[cnt++] = que.poll();
            if(map.containsKey(res[cnt - 1])) {
                for(int child : map.get(res[cnt - 1])) {
                    if(--dep[child] == 0) que.offer(child);
                }
            }
        }
        return cnt == numCourses ? res : new int[0];
    }
    
    // remeber when initing the relationship map, also increase the number of deps in the array.
    private void initRelationMap(Map<Integer, List<Integer>> map, int[][] prerequisites, int[] dep) {
        for(int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
            dep[pre[0]]++;
        }
    }
    
    private void initQueue(Queue<Integer> que, int[] dep) {
        for(int i = 0; i < dep.length; i++) {
            if(dep[i] == 0) que.offer(i);
        }
    }
}
