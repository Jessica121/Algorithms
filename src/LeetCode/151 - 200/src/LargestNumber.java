import java.util.Arrays;

public class LargestNumber {
    /*
    sort the whole string, one by one, insert each into the correct place. then concat al together.
    examples like 5 3, insert 4 in the middle. => 543
    
    */
    public String largestNumber(int[] nums) {
        String[] arr = converToStringArr(nums);
        // bigger one at front: (b + a) compare to a + b
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(String num : arr) {
            // for conditions like "0, 0, 0... "
            if(num.equals("0") && sb.length() == 0) continue;
            sb.append(num);
        }
        String res = sb.toString();
        // for conditions like "0, 0, 0... "
        return res.isEmpty() && nums.length > 0 ? "0" : res;
    }
    
    private String[] converToStringArr(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        return arr;
    }
}
