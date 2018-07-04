import java.util.*;

public class FractionToRecurringDecimal {
    /*
    use a map to track numerator and index of the result in the string.
    if(numerator < denominator) add a zero. if the first char, add a '.' too.
    numerator * 10. until numerator > denominator
    divide and take the residule. if % == 0 then append the res and return.
    else put numerator( < 10) and the index of the string into the map.
    take the residule, compare it in the map, if exist, take the index, insert '(' at that index and ')' at the end.
    return .
    if not exist, repeat the process. * 10 until > than denominator. do the same thing.
    
    */
    public String fractionToDecimal(int num, int deno) {
        long numerator = (long) num, denominator = (long) deno;
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator * denominator < 0) sb.append('-');
        // first, either of them are negative:
        // second, cast to integer, great, but overflow: so always use long to deal with int.
        if(numerator < 0) numerator = -numerator;
        if(denominator < 0) denominator = -denominator;
        Map<Long, Integer> map = new HashMap<>();
        while(numerator != 0) {
            long div = numerator / denominator;
            sb.append(div);
            // so check if its full or not. e.g. 4 / 2
            numerator -= div * denominator;
            if(numerator == 0) break;
            // if not, definitely append '.'
            sb.append('.');
            while(numerator < denominator) {
                if(map.containsKey(numerator)) {
                    sb.insert(map.get(numerator), "(");
                    sb.append(')');
                    return sb.toString();
                }
                numerator *= 10;
                div = numerator / denominator;
                sb.append(div);
                map.put(numerator / 10, sb.length() - 1);
                numerator -= div * denominator;
                if(numerator == 0) break;
            }
        }
        return sb.toString();
    }
}
