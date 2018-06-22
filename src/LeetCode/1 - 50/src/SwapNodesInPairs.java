
public class SwapNodesInPairs {
    /*
    Recursion: cur.next.next save recursion call
    cur.next.next = cur
    cur.next = head of recursion(nextnext)
    return cur.next;
    recursion: if node == null return null
    
    can expand to reverse every n node. keep a counter, when reach n, next set to 0
    */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nn = head.next.next, node = head.next;
        node.next = head;
        head.next = swapPairs(nn);
        return node;
    }
}
