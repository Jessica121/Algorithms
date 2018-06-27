
public class RemoveDupFromSortedLinkedList {
    /*
    keep a prev, run thru a list, first pointer tracks everything not dup, second pointer check the list 
    if equal to prev, just advance the first pointer, else add it to the next of the second pointer. return the head of the second pointer.
    could do it in-place
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head, second = head, prev = null;
        while(second != null) {
            if(prev == null || second.val != prev.val) {
                if(prev != null) {
                    first.next = second;
                    first = first.next;
                }
                prev = second;
            } 
            second = second.next;
        }
        // nullify the first.next when do it in place. as if last ones are dups, the first will point to the start of that dups.
        if(first != null) first.next = null;
        return head;
    }
}
