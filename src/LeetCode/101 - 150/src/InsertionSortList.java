
public class InsertionSortList {
    /*
    no breainer recursion: imagine everything sorted in recursion: node.next.
    insert into the correct place and return the corret head.
    head maybe itself if it smaller than the head of the recursion call.
    or the head of the recurison call.
    if recursion call head is null, return itself
    
    */
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode next = insertionSortList(head.next);
        if(next == null) return head;
        ListNode prev = null, saveNext = next;
        while(next != null) {
            if(head.val > next.val) {
                prev = next;
                next = next.next;
            } else break;
        }
        if(prev == null) {
            head.next = saveNext;
            return head;
        } else {
            prev.next = head;
            head.next = next;
            return saveNext;
        }
    }
}
