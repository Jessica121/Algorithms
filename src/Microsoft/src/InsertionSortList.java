
public class InsertionSortList {
	/*
    nextHead = sort(head.next)
    prev = null,
    while(nextHead != null && nextHead.value > head.val) go next
    if(nexthead == null) returnhead
    else if(prev == null) head.next = nexthead, return head
    else insert prev and next return nexthead
    
    */
	//O(N^2)
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode next = insertionSortList(head.next), nextHead = next;
        ListNode prev = null;
        while(next != null && next.val <= head.val) {
            prev = next;
            next = next.next;
        }
        if(next == null && prev == null) return head;
        else if(prev == null) {
            head.next = nextHead;
            return head;
        } else {
            next = prev.next;
            prev.next = head;
            head.next = next;
            return nextHead;
        }
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { 
    		val = x;
    	}
    }
}
