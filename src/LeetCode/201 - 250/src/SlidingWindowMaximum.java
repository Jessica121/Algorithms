import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    /*
    use a priority queue, maintain the elements in the window.
    when size == k, remove nums[i - k]. put the largest in the result.
    
    treeset will not allow duplicates.
    nlogn.
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        // mind this is max heap. so add a comparator 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(i < k) res[0] = pq.peek();
            else res[i - k + 1] = pq.peek();
            if(pq.size() == k) pq.remove(nums[i - k + 1]);
        }
        return res;
    }
    
    /*
    it utilize a two pass idea, but not the one i came up with..
    essentially, it divides the array into portions of size k, (last one may < k)
    and do a left most anchor pass and right anchor pass, with each anchor be the start of each portion: 
    left: if (i % k) == 0, reset max to itself.
    right: if (i + 1) % k == 0, then reset the max to itself.
    the reason to divde of length k is, for each sliding window, make sure there is <= 1 divier of the portions. 
    in this way, max will be captured by left and right pass. a b c d | e f. before the pipe, max is caped by a from right till the pipe. after the pipe, max is captured by f from left of the pipe.
    anything that is max will be sure to captured. then just to comapre the a and f, to get the max one.
    so if compareing from left, the max sits at its very right end. left end for right part.
    to compare the window, we use left bound of right and right bound of left to get the max.
    */
    public int[] maxSlidingWindowTwoPass(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1], left = new int[nums.length], right = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            left[i] = i % k == 0 ? nums[i] : Math.max(left[i - 1], nums[i]);
            // mind for the right, when i == 0, need to init as itself since it might not % k == 0, meaning the last portion could 
            // have less than k elements.
            right[nums.length - i - 1] = ((i == 0 || (nums.length - i) % k == 0)) ? nums[nums.length - i - 1] : Math.max(right[nums.length - i], nums[nums.length - i - 1]);
        }
        for(int i = 0; i < nums.length - k + 1; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
