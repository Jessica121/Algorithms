import java.util.*;
public class WordLadderII {
    /*
    same finding technique: BFS
    when deque-ed string equal to the endword, back track to print the path
    recursively, return parents path and append self to the res. back track. when the node is null, reverse the list, add to the res
    base case is it does not have a parent in the map. so add itself and return the list.
    when put a child into the queue, also put child : parent relation into the map.
    call the find path at the end. since all words must end with endword.
    and a node can have more parents since obviously, thats how there are multiple paths.
    
    also since it is the shortest path, so before attempting to extract from the que, check flag foundEndword
    which is set by parent level.
    if so then break the loop
    */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(), dict = new HashSet<>(wordList), tempVisited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        set.add(beginWord);
        boolean hasFound = false;
        while(!que.isEmpty()) {
            if(hasFound) break;
            int size = que.size();
            // this is the most imp part here: two words may transform into the same word, so need a visiting set not the visited set.
            // also this one needs to be set to empty at each level.
            tempVisited = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String parent = que.poll();
                char[] arr = parent.toCharArray();
                for(int k = 0; k < arr.length; k++) {
                    char ori = arr[k];
                    for(char cha = 'a'; cha <= 'z'; cha++) {
                        arr[k] = cha;
                        String trans = new String(arr);
                        if(!set.contains(trans) && dict.contains(trans)) {
                            // que.offer(trans);  // not right.
                            tempVisited.add(trans);
                            if(trans.equals(endWord)) hasFound = true;
                            map.computeIfAbsent(trans, o -> new ArrayList<>()).add(parent);
                        }
                    }
                    arr[k] = ori;
                }
            }
            set.addAll(tempVisited);
            // althou multiple words can match to same one, but it will lead to adding the same word again in the que.
            // so the que need to add this temp list at the end. not while the parent check its children.
            que.addAll(tempVisited);
        }
        if(!map.containsKey(endWord)) return res;
        List<String> temp = new ArrayList<>();
        findPath(map, endWord, temp, res);
        return res;
    }
    
    private void findPath(Map<String, List<String>> map, String endWord, List<String> temp, List<List<String>> res) {
        if(!map.containsKey(endWord)) {
            temp.add(0, endWord);
            res.add(new ArrayList<>(temp));
            // if you want to add things before adding it to the res, after adding, remove it from the result.
            temp.remove(0);
            return;
        }
        for(String parent : map.get(endWord)) {
            temp.add(0, endWord);
            findPath(map, parent, temp, res);
            temp.remove(0);
        }
    }
}
