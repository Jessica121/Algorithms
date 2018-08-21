/*
if both the pointers inbound, then flag 0 -> ptr1, 1 is 2
advance the ptr1 or 2 then flag ^= 1
else just go ahead with the one that is inbound.
corner case: one of them is empty. it is fine.


*/
import java.util.*;
public class ZigzagIterator {

    private int ptr1, ptr2, flag;
    private List<Integer> v1, v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.ptr1 = 0;
        this.ptr2 = 0;
        this.v1 = v1;
        this.v2 = v2;
        this.flag = 0;
    }

    public int next() {
        Integer res = null;
        if(ptr1 < v1.size() && ptr2 < v2.size()) {
            if(flag == 0) res = v1.get(ptr1++);
            else res = v2.get(ptr2++);
            flag ^= 1;
        } else if(ptr1 < v1.size()) res = v1.get(ptr1++);
        else res = v2.get(ptr2++);
        return (int) res;
    }

    public boolean hasNext() {
        return !(ptr1 >= v1.size() && ptr2 >= v2.size());
    }


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */


	/*
	 * Follow up question: when it is a lists of list.
	i would say if it is a K lists, use a array and have a pointer circular move around it. 
	but it needs to check if the current list is empty or not. else continue to move on.
	this may not be efficient if consecutive lists are empty.
	so maybe use a resizable array and if it is empty, remove it.
	so is empty will be if the list size == 0.
	if use a queue, can deque it and offer it back, when it is not empty.
	so the que is of type integer, indicating which list and which pointer of this list. so need a pointer class.
	init it would be offer the num of lists in it and its indexes are zeros.
	poll the top when queue not empty, then add the list index element, increase the pointer index. if inbound, offer to the end of the list.
	
	*/
	
	private Queue<Pointer> que;
	private List<List<Integer>> lists;
	
	private class Pointer {
	    int listInd;
	    int index;
	    public Pointer(int listIndex) {
	        this.listInd = listIndex;
	        this.index = 0;
	    }
	}
	
	public ZigzagIterator(List<List<Integer>> lists) {
	    this.que = new LinkedList<>();
	    this.lists = lists;
	    initQueue(que, lists.size());
	}
	
	/*
	imagine that all lists are not empty. else it is more complicated: check empty before offering.
	*/
	private void initQueue(Queue<Pointer> que, int num) {
	    for(int i = 0; i < num; i++) {
	        que.offer(new Pointer(i));
	    }
	}
	
	public int nextFollowUp() {
	    Pointer p = que.poll();
	    int res = lists.get(p.listInd).get(p.index++);
	    if(p.index < lists.get(p.listInd).size()) que.offer(p);
	    return res;
	}
	
	public boolean hasNextFollowUp() {
	    return que.isEmpty();
	}
}