import java.util.*;
public class AddLinkedList {
    /*
    Return the flag as the first node and the real node as the second node.
    parent stack going to modify first node for itself and append a flag node, return flag node
    if two lists are of different length, align first, set a cnt indicating one larger than the other 
    modify that node1.len >= node2.len
    if(cnt > 0) only modify next on node1, return the flag, cnt--
    else modify next one both the pointer
    main function check recursion's head, 1, return, 0 return next
    
    Linked List: no length know, only access from head: recursion, put flag as the head pointer
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node1 = l1, node2 = l2;
        int cnt = processDifflen(node1, node2);
        if(cnt < 0) { // l2 is longer
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
            cnt = Math.abs(cnt);
        }
        ListNode head = add(l1, l2, cnt);
        if(head.val == 0) return head.next;
        else return head;
    }
    
    private ListNode add(ListNode l1, ListNode l2, int cnt) {
        if(l1 == null && l2 == null) return null;
        ListNode flag = new ListNode(0), next = null;
        int sum = 0;
        if(cnt > 0) {
            next = add(l1.next, l2, cnt - 1);
            // note that next maybe null
            sum = l1.val + (next == null ? 0 : next.val);
        } else {
            next = add(l1.next, l2.next, cnt);
            sum = l1.val + (next == null ? 0 : next.val) + l2.val;
        }
        // note that next maybe null here too
        if(next == null) next = new ListNode(sum % 10);
        else next.val = sum % 10;
        flag.val = sum / 10;
        flag.next = next;
        return flag;
    } 
    
    private int processDifflen(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        int cnt = 0;
        while(l1 != null) {
            l1 = l1.next;
            cnt++;
        }
        while(l2 != null) {
            l2 = l2.next;
            cnt--;
        }
        return cnt;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { 
    		val = x; 
    	}
    }
}
