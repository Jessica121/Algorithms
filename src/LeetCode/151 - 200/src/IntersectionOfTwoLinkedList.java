
public class IntersectionOfTwoLinkedList {
    /*
    Find the diff in length. run two pointers from heads, when one is null, use another pointer set to non-null's head. move together, when non-null -> null, this new pointer points to the node equal length with short one.
    then move together untill two nodes same.
    no intersection: 1 - 2 - 3
                     4
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode ia = headA, ib = headB;
        while(ia != ib) {
        	// set to head to find the diff. then it turns out it is the smarty solution
            ib = ib == null ? headA : ib.next;
            ia = ia == null ? headB : ia.next;
        }
        return ia;
    }
}
