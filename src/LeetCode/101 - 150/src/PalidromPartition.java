import java.util.*;

public class PalidromPartition {
    /*
    obviously sub problem on substrings. preferably on index
    on this index, return a bounch of palidromic rep, for the parent level to add to.
    only take substring 0 to index, index from start to end of string. if substring is a palidrom string, recursion call next,
    with the start index is the end of substring. get a list of result, append the substring to front for each of them, return the list.
    
    */
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        return partition(s, 0, map);
    }
    
    private List<List<String>> partition(String s, int index, Map<Integer, List<List<String>>> map) {
        List<List<String>> res = new ArrayList<>();
        if(index == s.length()) {
            List<String> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }
        
        if(map.containsKey(index)) return map.get(index);
        for(int i = index + 1; i <= s.length(); i++) {
            String candi = s.substring(index, i);
            if(isPali(candi)) {
                List<List<String>> next = partition(s, i, map);
                for(List<String> list : next) {
                	// one thing that is vely vely tricky is pass by value thing.
                	// modify the list directly without creating a new list will modify it in the map at the same time as well
                	// even if clone a new list and modify on that...
                	// so each list create a new one, add the newly created list.
                    List<String> temp = new ArrayList<>(list);
                    temp.add(0, candi);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    
    private boolean isPali(String candi) {
        int ptr1 = 0, ptr2 = candi.length() - 1;
        while(ptr1 < ptr2) {
            if(candi.charAt(ptr1) != candi.charAt(ptr2)) return false;
            ptr1++;
            ptr2--;
        }
        return true;
    }
}
