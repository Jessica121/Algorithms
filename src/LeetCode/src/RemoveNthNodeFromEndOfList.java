
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
}
