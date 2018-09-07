import java.util.*;
public class ValidWordAbbr {

    /*
    most intuitive way is to have a helper function, take in a string and output the abbreviated version.
    use a hashmap<string, integer> to track the abbs in the dict.
    isUniq func have the same thing, take a string, get the abbr and check the set has it or not.
    this question is speechless for me.
    so save all the strings in the dict then. check if size == 1 if exist and it contains itself.
    
    */
    
    private Map<String, Set<String>> abbs;
    public ValidWordAbbr(String[] dictionary) {
        this.abbs = new HashMap<>();
        initSet(abbs, dictionary);
    }
    
    private void initSet(Map<String, Set<String>> abbs, String[] dictionary) {
        for(String word : dictionary) {
            abbs.computeIfAbsent(getAbbr(word), k -> new HashSet<>()).add(word);
        }
    }
    
    private String getAbbr(String input) {
        if(input.length() <= 2) return input;
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0)).append(input.length() - 2).append(input.charAt(input.length() - 1));
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
        String ab = getAbbr(word);
        return !abbs.containsKey(ab) || (abbs.get(ab).size() == 1 && abbs.get(ab).contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

class ValidWordAbbrBtterVersion {

    /*
    most intuitive way is to have a helper function, take in a string and output the abbreviated version.
    use a hashmap<string, integer> to track the abbs in the dict.
    isUniq func have the same thing, take a string, get the abbr and check the set has it or not.
    this question is speechless for me.
    if a key maps to more than 1 word, then it is invalid and save to invalid format.
    check the key exist, if already invalid then ignore. else compare the key if not equal to self, then set it to invalid.
    check key not exist or is invalid.
    
    */
    
    private Map<String, String> abbs;
    public ValidWordAbbrBtterVersion(String[] dictionary) {
        this.abbs = new HashMap<>();
        initSet(abbs, dictionary);
    }
    
    private void initSet(Map<String, String> abbs, String[] dictionary) {
        for(String word : dictionary) {
            String ab = getAbbr(word);
            if(abbs.containsKey(ab) && !abbs.get(ab).equals(word)) abbs.put(ab, "");
            else abbs.put(ab, word);
        }
    }
    
    private String getAbbr(String input) {
        if(input.length() <= 2) return input;
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0)).append(input.length() - 2).append(input.charAt(input.length() - 1));
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
        String ab = getAbbr(word);
        return !abbs.containsKey(ab) || abbs.get(ab).equals(word);
    }
}