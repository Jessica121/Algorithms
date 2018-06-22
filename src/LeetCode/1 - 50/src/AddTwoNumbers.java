
public class AddTwoNumbers {
/*
    Linked list problem, 
    two pointers, move at the same time. each time, add flag + ptr1.val + ptr2.val, set the ptr1.val into total / 10, flag total % 10
    advance both pointers.
    one may be shorter than the other, in this case, only add the value when they are not null.
    then append a flag node when it is 1.
    return the l1 head.
*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), ret = head; // sudo node.
        int flag = 0;
        while(l1 != null || l2 != null) {
            int total = flag;
            if(l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(total % 10);
            head = head.next;
            flag = total / 10;
        }
        if(flag == 1) head.next = new ListNode(1);
        return ret.next;
    }
}
