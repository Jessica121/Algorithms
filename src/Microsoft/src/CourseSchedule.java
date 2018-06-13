import java.util.*;
public class CourseSchedule {
	    /*
	    use an array to track the number of prerequests it has. put into queue for ones has 0 in-degrees;
	    use an map to track parents to list of children, if cycle presents, then array has left ones with non-zero in-degree, yet queue is empty. (numCourses != 0)
	    
	    */
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[] degrees = new int[numCourses];
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        Queue<Integer> que = new LinkedList<>();
	        for(int[] pre : prerequisites) {
	            map.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
	            degrees[pre[0]]++;
	        }
	        for(int i = 0; i < degrees.length; i++) {
	            if(degrees[i] == 0) que.offer(i);
	        }
	        while(!que.isEmpty()) {
	            int parent = que.poll();
	            numCourses--;
	            if(!map.containsKey(parent)) continue;
	            for(int child : map.get(parent)) {
	                degrees[child]--;
	                if(degrees[child] == 0) que.offer(child);
	            }
	        }
	        return numCourses == 0;
	    }
}
