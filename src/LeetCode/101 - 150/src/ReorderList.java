
public class ReorderList {
    /*
    recursion to my first instinct. and it better to be right.
    save current next. recurse on next.
    current.next = next;
    return next.next
    base case: have to know the center first.
    if it is odd, and the center, return its next.
    if its even, and center, return itself.
    but i dont like checking the odd and even.
    but it could be easier.
    odd is fast next is null. even is fast is null
    so set a flag on that.
    
    */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, node = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) reorder(head, slow, true);
        else reorder(head, slow, false);
    }
    
    private ListNode reorder(ListNode node, ListNode mid, boolean isEven) {
        if(node == mid) {
            if(isEven) return node;
            else {
                ListNode res = node.next;
                // really tricky, set the node next null is return node next.
                // or will have a loop
                // reorder list kind of problem, be cautious about resetting the pointers to prevent loop.
                node.next = null;
                return res;
            }
        }
        ListNode next = reorder(node.next, mid, isEven), originalNext = node.next;
        node.next = next;
        ListNode nextCall = next.next;
        // link the list with original next. when, however, the list is even, and at the center. the original next equal to the current next.
        // then set it to null.
        next.next = originalNext != next ? originalNext : null;
        return nextCall;
    }
}
