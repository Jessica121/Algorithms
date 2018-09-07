import java.util.*;
public class FindMedianInDataStream {
	
	/** 
	 * 
	 * the core idea of the problem is to how to balance the elements in two heaps so when they linked together, 
	 * it is properly sorted.
	 * can either compare with the non empty top, or compute the median and put in the right side. 
	 * then shift.
	 * 
    use insertion sort and find the median (?)
    or use a heap, but how to find the median? iterate all the time?        --> nope, use one min heap and one max heap.
    use a tree map, it is a balanced BST, but cannot retrieve the root.
   
    
    if both of heap are empty, put to right, it does matter, since everytime we add, we check the top of the right.
    else check the top of right, if element < top of right, then add to left. else add to right.
    shift left and right until the element are balanced. diff not more than one.
    can do separately when add to diff side.
    
    median is check both size and return left when odd, %2 != 0, else left and right peek / 2

    corner case is when add only one element, what is the median.
    also when adding, and one of the heap is empty, should check the non empty one.
    -1, -2, -3, -4, -5, because we want to properly sort it, before shifting elements
    */
           
    private PriorityQueue<Integer> left, right;
    public FindMedianInDataStream() {
        this.left = new PriorityQueue<>((a, b) -> (b - a));
        this.right = new PriorityQueue<>(); // min heap by default.
    }
    
    public void addNum(int num) {
        if(!right.isEmpty() && num < right.peek() || (!left.isEmpty() && num < left.peek())) {
            left.add(num);
            while(left.size() > right.size() + 1) right.add(left.poll());
        } else {
            right.add(num);
            while(right.size() > left.size()) left.add(right.poll());
        }
    }
    
    /** 
    left   median  right
    1,2,3    3      4,5
    so still use a max heap and a min heap, if both are empty, put into left.
    else call findMedian, put into left if <= median, else put right.
    then balance the number, than for adding to left, shift to right until left size - right = 1
    for adding to right, shift until right size !> left size.
    
    */
    public void addNumTwoCompareTheMedian(int num) {
        if(left.isEmpty() && right.isEmpty()) left.add(num);
        else {
            double median = findMedian();
            if((double) num <= median) {
                left.add(num);
                while(left.size() - right.size() > 1) right.add(left.poll());
            } else {
                right.add(num);
                while(right.size() > left.size()) left.add(right.poll());
            }
        }
    }
    
    public double findMedian() {
        int size = right.size() + left.size();
        if(size % 2 == 0) return (double)(right.peek() + left.peek()) / 2;
        else return (double) left.peek();
    }
	
	class MedianFinder {
		// this version does not work, as the input stream is required to be sorted... :]]]
	    /** keep a queue and a counter indicating which num it is. cnt starts from 0.
	    so if the cnt is even, then poll the queue(if not empty), and offer the element. the median is the head of the queue.
	    else don't poll from the queue, still offer the element, the median is the first two of the queue.
	    everytime add increase the counter and poll if necessary.
	    
	    find median just depend on the count and return the first or first two.
	    */
	    
	    private int cnt;
	    private Queue<Integer> que;
	    public MedianFinder() {
	        this.cnt = 0;
	        this.que = new LinkedList<>();
	    }
	    
	    public void addNum(int num) {
	        if(cnt % 2 == 0 && !que.isEmpty()) que.poll();
	        que.offer(num);
	        cnt++;
	    }
	    
	    public double findMedian() {
	        if(cnt % 2 != 0) return (double) que.peek();
	        else {
	            int num = 0, sum = 0;
	            for(int ele : que) {
	                if(num == 1) return (double) (sum + ele) / 2;
	                else {
	                    sum = ele;
	                    num++;
	                }
	            }
	        }
	        return 0;
	    }
	}
}
