import java.util.*;
public class FindTheDuplicateNumber {
    /*
     * 
     * proof is the peagon hole problem.
    sort or budcket: modify the array. bucket(keep swapping until the index + 1 is equal to self)
    use map to track: extra space
    compare one by one: n^2
    compute the expected sum and real sum and substract: only works given it repeat only once.
    bit manipulation???
    
    my guess is using sum still to calculate the range the dup it could be. then binary search for it. in 1 - n
    count how many times that number shows up, if cnt > 1, then return it.
    nlogn time.
    
    but i dont know the relationship between sum and dup int.
    
    after i saw the solution, i decided to implement the sorting one.
    
    so sort it once, and checn i = 0 .. nums.length - 1, check with its later ones. if equal, then return it.
    
    */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) return nums[i];
        }
        return Integer.MAX_VALUE;
    }
    
    /*
    the value of the array is the "pointer" to the next one. 
    so like the linked list cycle, have a slow pointer and a fast pointer.
    slow pointer moves ont step to the next num, the fast one moves two steps.
    likewise in a cycled linked list, the starting node has 2+ nodes pointing to it, they will meet at some point.
    after meet, reset the fast to the head of the list, and move in the same pace until meet. that point is the start of the cycle.
    when they first meet, the slow one moves the cycle length distance.
    so resetting the fast to the beginning and move together slowly, the offset is the same to the starting point.
    
    start is 0, slow -> slow = nums[slow], fast -> fast = nums[nums[fast]]
    until their value equal;
    then reset the fast to 0, do slowly. until the value is equal. return it.
    
    */
    public int findDuplicateLinkedListCycle(int[] nums) {
        if(nums.length <= 1) return -1;
        // the value must be inbound, as value < len.
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
