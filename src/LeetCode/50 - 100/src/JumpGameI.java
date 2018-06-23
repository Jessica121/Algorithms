
public class JumpGameI {
    /*
    Can use greedy as the II
    keep a range, and the next end. when reach the end, update the end by the next end, continue.
    return end >= nums.length - 1 or not.
    if next end >= nums.length - 1 return true;
    */
    public boolean canJump(int[] nums) {
        int end = 0, nextEnd = 0, i = 0;
        while(i <= end) {
            nextEnd = Math.max(nextEnd, nums[i] + i);
            if(nextEnd >= nums.length - 1) return true;
            if(i == end) end = nextEnd;
            i++;
        }
        return false;
    }
    
    /*
     * Keep updating the ends.
     * */
    public boolean canJumpKeepUpdateingTheEnds(int[] nums) {
        int end = 0, nextEnd = 0, i = 0;
        while(i <= end) {
            nextEnd = Math.max(nextEnd, nums[i] + i);
            if(nextEnd >= nums.length - 1) return true;
            if(nextEnd > end) end = nextEnd;
            i++;
        }
        return false;
    }
}
