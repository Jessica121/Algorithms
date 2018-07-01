
public class LinkedListCycleII {
    /*
    when slow at the enter point, and moved k steps for that. fast will be 2k steps which is k steps into the cycle.
    which is cycle len - k steps slower than the slow. to catch up the slow, slow moves len - k steps, fast is 2 times, but 1 time laster than slow. so slow and fast will meet, after slow moves len - k into the cycle.
    at this point, slow is k steps to the entry point. have another slow pointer start from head, move two together, when they meet is the entry node.
    really dont need to count the number, just when they meet, set another pointer to the head.
    
    */
    public ListNode detectCycle(ListNode head) {
        ListNode node = head, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        while(node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return slow;
    }
}
