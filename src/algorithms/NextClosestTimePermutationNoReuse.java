package algorithms;
import java.util.*;

public class NextClosestTimePermutationNoReuse {
	// Next closest time with permutation only. Cannot reuse digits.
	    public static void main(String[] args) {
	        System.out.println(next("23:55"));
	    }
	    
	    private static String next(String s) {
	        int[] arr = {s.charAt(0) - '0', s.charAt(1) - '0', s.charAt(3) - '0', s.charAt(4) - '0'};
	        // Target original to find.
	        int target = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
	        Arrays.sort(arr);
	        List<Integer> res = new ArrayList<>();
	        permutate(arr, 0, new HashSet<Integer>(), res); // unique
	        // Sort permutations increasingly.
	        Collections.sort(res, (a, b) -> (a - b));
	        // Find target, use next. When target being the last, use the first one.
	        int ind = binarySearch(res, target);
	        String iRes = res.get((ind + 1) % res.size()).toString();
	        // Formatting to leading 0s when string length < 4
	        String resStr = ("0000" + iRes).substring(iRes.length());
	        return resStr.substring(0, 2) + ":" + resStr.substring(2, 4);
	    }
	    
	    private static int binarySearch(List<Integer> res, int tar) {
	        int s = 0, e = res.size() - 1, mid = 0;
	        while(s < e) {
	            mid = s + (e - s) / 2;
	            if(res.get(mid) == tar) return mid;
	            else if(res.get(mid) < tar) s = mid + 1;
	            else e = mid;
	        }
	        return -1;
	    }
	    
	    private static void permutate(int[] arr, int sum, Set<Integer> set, List<Integer> res) {
	        if(set.size() == 4) {
	        	// If invalid time skip; else add
	            if(sum / 100 < 24 && sum % 100 < 60) res.add(sum);
	            return;
	        }
	        for(int i = 0; i < 4; i++) {
	            if(i > 0 && arr[i] == arr[i - 1] && !set.contains(i - 1)) continue;
	            if(!set.contains(i)) {
	                set.add(i);
	                sum = sum * 10 + arr[i];
	                permutate(arr, sum, set, res);
	                sum = (sum - arr[i]) / 10;
	                set.remove(i);
	            }
	        }
	    }
}
