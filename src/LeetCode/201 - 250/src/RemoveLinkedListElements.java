
public class RemoveLinkedListElements {
    /*
    pretty straight forward: 
    if self equal to the val, if has next, copy next value over and remove next, lol. 
    remove next by put cur.next = next.next, if next is not null.
    if the head == null, return null.
    if val not exist, nothing will be done.
    use a while loop ran over the list.
    
    opps not work for the last one :) java is pass by value. 
    */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head, prev = new ListNode(-1), sudo = prev;
        prev.next = head;
        while(node != null) {
            if(node.val == val) prev.next = node.next;
            // only set prev only when it is not the target one
            else prev = node;
            node = node.next;
        }
        // if node is null, return here too.
        // return sudo next, not the original head! it may be removed also.
        return sudo.next;
    }
    
    /*
    recursion: cur next is next recursion call's head.
    if cur.val == target, return its next, without assigning anything, else assign self next is recur next and return itself.
    linkedlist recursion almost for sure.
    */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
