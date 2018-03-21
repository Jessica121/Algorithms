package algorithms;
import java.util.*;

public class flattenDict {

  public static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap<String, String> res = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    flatten(sb, res, dict);
    return res;
  }
  
  private static void flatten(StringBuilder sb, HashMap<String, String> res, HashMap<String, Object> dict) {
    for(String key : dict.keySet()) {
      if(dict.get(key) instanceof String) {
    	  sb.append(key);
          res.put(sb.toString(), (String) dict.get(key));
          sb.setLength(sb.length() - key.length());
      } else {
        sb.append(key).append(".");
        flatten(sb, res, (HashMap<String, Object>) dict.get(key));
        sb.setLength(sb.length() - key.length() - 1);
      }
    }
  }
  
	public static void main(String[] args) {
		HashMap<String, Object> input = new HashMap<>();
		input.put("key1", "1");
		HashMap<String, Object> nestedOne = new HashMap<>();
		nestedOne.put("a", "a1");
		HashMap<String, Object> nestedTwo = new HashMap<>();
		nestedTwo.put("b", "b1");
		nestedOne.put("c", nestedTwo);
		input.put("key2", nestedOne);
		System.out.println(flattenDictionary(input));
	}

}
