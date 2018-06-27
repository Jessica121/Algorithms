
public class RemoveDupFromSortedLInkedlistII {
    /*
    keep a prev node, and a cnt.
    if not equal to prev && cnt == 1, add the prev node to tail of the list. can create a sudo head.
    set prev = self and cnt == 1;
    if equal to prev, cnt ++
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sudo = new ListNode(-1), newHead = sudo, prev = null;
        int cnt = 0;
        while(head != null) {
            if(prev == null || head.val != prev.val) {
                if(prev != null && cnt == 1) {
                    sudo.next = prev;
                    sudo = sudo.next;
                }
                prev = head;
                cnt = 1;
            } else cnt++;
            head = head.next;
        }
        if(prev != null && cnt == 1) {
            sudo.next = prev;
            sudo = sudo.next;
        }
        sudo.next = null;
        return newHead.next;
    }
}
