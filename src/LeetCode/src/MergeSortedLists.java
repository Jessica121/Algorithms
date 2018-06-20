
public class MergeSortedLists {
    /*
     * iterative
    Everytime take one element, save its next and nullify the next.
    append to the head.next. if head == null, set to head directly, save the return head.
    return the return head.
    
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = null, head = tail;
        while(l1 != null && l2 != null) {
            ListNode chosen = l1.val <= l2.val ? l1 : l2;
            ListNode next = chosen.next;
            chosen.next = null;
            if(tail == null) {
                head = chosen;
                tail = head;
            } else tail.next = chosen;
            tail = chosen;
            if(chosen == l1) l1 = next;
            else l2 = next;
        }
        if(l1 != null) {
            if(head == null) return l1;
            else {
                tail.next = l1;
                return head;
            }
        }
        if(l2 != null) {
            if(head == null) return l2;
            else {
                tail.next = l2;
                return head;
            }
        }
        return head;
    }
    
    /*
     * recursion
    smaller one next = recursion: other and smaller one next
    if one of them is null, return the other.
    cannot be null both of the time.
    return the smaller head.
    */
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) l1.next = mergeTwoLists(l1.next, l2);
        else l2.next = mergeTwoLists(l1, l2.next);
        return l1.val <= l2.val ? l1 : l2;
    }
}
