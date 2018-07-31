import java.util.*;
public class AlienDictionary {
    /*
    take two words, check character, move till first different character set.
    if same, also need to add to dep map if not there
    add them to the parent : child map, use a set. so can check when this pair of relationship has already been added.
    dependency map increases for the child, if parent not exist, create one with value 0.
    then topological sort, build the string.
    init a string, if string length != dep map size, return empty one.
    
    corner case: when one of the string is longer, the rest of the chars are ignored.
    */
    public String alienOrder(String[] words) {
        if(words.length == 1) return words[0];
        Map<Character, Integer> dep = new HashMap<>();
        Map<Character, Set<Character>> relation = new HashMap<>();
        for(int i = 1; i < words.length; i++) {
            String str1 = words[i - 1], str2 = words[i];
            addInDep(str1, dep);
            addInDep(str2, dep);
            for(int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
                if(str1.charAt(j) != str2.charAt(j)) {
                    if(relation.computeIfAbsent(str1.charAt(j), k -> new HashSet<>()).add(str2.charAt(j))) 
                        dep.put(str2.charAt(j), dep.get(str2.charAt(j)) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> que = new LinkedList<>();
        putAllStartBuild(dep, que);
        while(!que.isEmpty()) {
            char pare = que.poll();
            sb.append(pare);
            if(relation.containsKey(pare)) {
                for(char child : relation.get(pare)) {
                    dep.put(child, dep.get(child) - 1);
                    if(dep.get(child) == 0) que.offer(child);
                }
            }
        }
        return sb.length() == dep.size() ? sb.toString() : "";
    }
    
    // have to add all first, since words that are different are going to break the later ones.
    private void addInDep(String s, Map<Character, Integer> dep) {
        for(int i = 0; i < s.length(); i++) {
            if(!dep.containsKey(s.charAt(i))) dep.put(s.charAt(i), 0);
        }
    }
    
    private void putAllStartBuild(Map<Character, Integer> dep, Queue<Character> que) {
        for(char key : dep.keySet()) {
            if(dep.get(key) == 0) que.offer(key);
        }
    }
}
