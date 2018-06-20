
public class RemoveNthNodeFromEndOfList {
    /*
    linkedlist does not know the head.
    recursion: if node == null, return 0;
    this = next + 1;
    if cur num = n + 1. then remove the next next...
    if next next not null, set. cur next = next next, else cur next = 0;

*/
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode node = head;
	    int rank = remove(node, n);
	    if(rank == n) return head.next;
	    return head;
	}
	
	private int remove(ListNode node, int n) {
	    if(node == null) return 0;
	    int rank = 1 + remove(node.next, n);
	    if(rank == n + 1) node.next = node.next.next;
	    return rank;
	}
	
    /*
    move the first one n steps frist: 0 .. n, if the node reached null, return null. not valid.
    then move two pointers together, record the prev of the first pointer
    when the second next is null, current of first is the first element, remove the prev element
    if prev is null, means delete the head. return head.next.
    */
    public ListNode removeNthFromEndSmart(ListNode head, int n) {
        ListNode fast = head, prev = null, slow = head;
        for(int i = 1; i < n; i++) {
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null) return head.next;
        prev.next = slow.next;
        return head;
    }
}
