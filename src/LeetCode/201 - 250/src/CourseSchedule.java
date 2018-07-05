import java.util.*;
public class CourseSchedule {
    /*
    have an array for length of numCourses, for int[1], add its child of int[0]. and increase the parent the children has.
    start from the element with value 0, put all of them into a queue, build the courses without prerequests first.
    get all its chilren, decrease the dep array for the children. if the child has the dep of 0, add it to the queue.
    one poll from the queue, increase the number of courses taken.
    return if number of courses taken == numcourse.
    
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dep = new int[numCourses];
        int cnt = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        initRelationMap(map, prerequisites, dep);
        Queue<Integer> que = new LinkedList<>();
        initQueue(que, dep);
        while(!que.isEmpty()) {
            int pare = que.poll();
            cnt++;
            if(map.containsKey(pare)) {
                for(int child : map.get(pare)) {
                    if(--dep[child] == 0) que.offer(child);
                }
            }
        }
        return cnt == numCourses;
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
