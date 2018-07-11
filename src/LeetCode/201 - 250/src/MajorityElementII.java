import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    /*
    one crucial fact to realize here is there will be at most 2 candidates.
    so can1, can2, use Integer to set. cnt1, cnt 2
    what it really does is pairing up two candidates, then if the cur is neither of the candidates, then pair up with both of them.
    if cur one sees one of the cnter == 0, set it as the can1 for cnt1, can2 for cnt2
    if cur == can1, cnt1++, same for can2
    if it sees cnt1 == 0 || cnt2 == 0 set itself as that canX
    else pair with all candidates, --.
    then needs to check majorityty: e.g. 1 1 1 2 2 2. no majority.
    
    */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer can1 = null, can2 = null;
        int cnt1 = 0, cnt2 = 0;
        for(int n : nums) {
            if(can1 != null && n == can1) cnt1++;
            else if(can2 != null && n == can2) cnt2++;
            else if(cnt1 == 0) {
                can1 = n;
                cnt1++;
            } else if(cnt2 == 0) {
                can2 = n;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for(int n : nums) {
            if(can1 != null && n == can1) cnt1++;
            else if(can2 != null && n == can2) cnt2++;
        }
        if(cnt1 > nums.length / 3) res.add(can1);
        if(cnt2 > nums.length / 3) res.add(can2);
        return res;
    }
}
