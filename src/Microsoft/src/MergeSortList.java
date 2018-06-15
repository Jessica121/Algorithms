
public class MergeSortList {
    /*
    Merge sort, find the middle, sort left and right recursively
    then merge the second list into first list
    
    middle: fast pointer == null or its next == null
    cur pointer track prev every move, recursively sort head ~ prev, cur ~ null(tail)
    then merge sort: ptr1-head1, ptr2-head2, advance smaller if in ptr1, else insert pointer2, advance pointer2
    if start == end return start (including null)
    if start.next == null return start
    return head1
    
    */
    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }
    
    private ListNode mergeSort(ListNode start, ListNode end) {
        if(start == end) return end;
        ListNode slow = start, fast = start, next = null;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        next = slow.next;
        slow.next = null;
        ListNode head1 = mergeSort(start, slow), head2 = mergeSort(next, end);
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode prev = null, retHead = head1;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                prev = head1;
                head1 = head1.next;
            } else {
                ListNode head2Next = head2.next;
                head2.next = head1;
                if(prev != null) {
                    prev.next = head2;
                } else {
                    retHead = head2;
                }
                // previous reset to head2 always.
                prev = head2;
                head2 = head2Next;
            }
        }
        if(head2 != null) prev.next = head2;
        return retHead;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { 
    		val = x;
    	}
    }
}
