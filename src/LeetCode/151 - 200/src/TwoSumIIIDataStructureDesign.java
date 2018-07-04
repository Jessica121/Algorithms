import java.util.*;
public class TwoSumIIIDataStructureDesign {

    /** 
    use a hashmap to store the number and its counts. 
    search is searching one by one. target - cur. if cur * 2 == target, then check the number in map >= 2.
    */
    Map<Integer, Integer> map;
    public TwoSumIIIDataStructureDesign() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : map.keySet()) {
        	// it is get the counter of key, not the value...... think clear before you code. always.
            int cnter = value - key;
            if(cnter == key) {
                if(map.get(key) >= 2) return true;
            }
            else if(map.containsKey(cnter)) return true;
        }
        return false;
    }
}
