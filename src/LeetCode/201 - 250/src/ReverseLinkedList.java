
public class ReverseLinkedList {
    /*
    have a sudo head to append to, save the sudo head next and append in between.
    do this for all the nodes. save the next before proceed.
    return sudo head.next.
    
    */
    public ListNode reverseList(ListNode head) {
        ListNode sudo = new ListNode(-1);
        while(head != null) {
            ListNode next = head.next, sudoNext = sudo.next;
            sudo.next = head;
            head.next = sudoNext;
            head = next;
        }
        return sudo.next;
    }
    
    /*
    recursion:
    get the head of the recursion and append to its tail.
    return the head.
    return both the head and tail.
    if node.next == null return {node, node}
    
    */
    public ListNode reverseListRecursion(ListNode head) {
        if(head == null) return null;
        return reverse(head)[0];
    }
    
    private ListNode[] reverse(ListNode head) {
        if(head.next == null) return new ListNode[] {head, head};
        ListNode[] next = reverse(head.next);
        next[1].next = head;
        head.next = null;
        return new ListNode[] {next[0], head};
    }
    
    /*
    another recursion: cur is next.next return next.
    
    */
    public ListNode reverseListRecursion2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        // if current is the tail, then recursion function will return null. at this time return itself.
        if(next == null) return head;
        // it is the current next.next is self. not the recursion result.
        head.next.next = head;
        // dont forget to set the current node.next is null.!
        // pointer resetting, put prev into next, this kind of problem current pointer set next to null.
        head.next = null;
        return next;
    }
}
