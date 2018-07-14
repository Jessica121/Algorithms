import java.util.*;

public class GroupShiftedStrings {
    /*
    most intuitive way is to use a map: pattern rep: list of them.
    then return the value set of it.
    so the pattern rep: abc -> 012 by substracting each char with the first char (a)
    so                  bcd -> 012 by - 'b' for each char.
    the put them into the map.
    corner case: empty string:
    and 1 2 and 12 ...
    
    1. wrap around definition requires add its length and mod by its length
    2. rep: multiple 1-digit to one n-digit corner case realize.
    */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String string : strings) {
            String rep = getRep(string);
            map.computeIfAbsent(rep, k -> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(map.values());
    }
    
    private String getRep(String s) {
        if(s.isEmpty()) return s;
        char first = s.charAt(0);
        StringBuilder sb = new StringBuilder(0);
        for(int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) - first + 26) % 26).append(',');
        }
        return sb.toString();
    }
}
