import java.util.*;
public class WordLadder {
	  /*
    BFS to find the shortest path. almost a sign.
    from start word, put the neibor that is in the dict and not visited into the queue.
    mark visited of the words put into the queue.
    each level is 1 distance. 
    so if the polled word equal to the end word, return the level.
    not when the parent tries to put the child
    
    transform: transfer the string into array, change the char in array from a to z. convert into string and check
    transform back! 
    
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>(), dict = new HashSet<>(wordList);
        int level = 0;
        que.offer(beginWord); // beginWord is not part of dict, so no need to add it into visited.
        while(!que.isEmpty()) {
            level++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                String parent = que.poll();
                if(parent.equals(endWord)) return level;
                char[] arr = parent.toCharArray();
                for(int j = 0; j < arr.length; j++) {
                    char orig = arr[j];
                    for(char cha = 'a'; cha <= 'z'; cha++) {
                        arr[j] = cha;
                        String trans = new String(arr);
                        if(!visited.contains(trans) && dict.contains(trans)) {
                            que.offer(trans);
                            visited.add(trans);
                        }
                        arr[j] = orig;
                    }
                }
            }
        }
        return 0;
    }
}
