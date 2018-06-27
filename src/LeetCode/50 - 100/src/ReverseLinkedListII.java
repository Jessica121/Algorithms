
public class ReverseLinkedListII {
    /*
    just count to m and m, save this two nodes as start and end.
    reverse returns both the head and tail.
    then just link m - 1 with head, tail next is n + 1
    if m == 0 link the tail and return head.
    if tail is the end then no need for linking the tail
    could just reverse the whole list wont affect the result.
    
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sudo = new ListNode(-1), node = sudo, start = null, beforeStart = null, beforeEnd = null;
        sudo.next = head;
        int i = 0;
        while(node != null) {
            if(i == m - 1) {
                start = node.next;
                beforeStart = node;
            } 
            if(i == n + 1) beforeEnd = node;
            node = node.next;
            i++;
        }
        ListNode[] pair = reverse(start, 0, n - m);
        beforeStart.next = pair[0];
        pair[1].next = beforeEnd;

        return sudo.next;
    }
    
    private ListNode[] reverse(ListNode node, int cur, int cnt) {
        if(cur == cnt) return new ListNode[]{node, node};
        ListNode[] next = reverse(node.next, cur + 1, cnt);
        next[1].next = node;
        node.next = null;
        return new ListNode[]{next[0], node};
    }
    
    /*
    record the node when n - 1. i = n thru m, record its next, add to next of n - 1, next is the next.
    also tail link to its next.
    reverse partial list usually involves two anchors on the changed part, if doing iteratively. 
    similar: partition list.
    
    */
    public ListNode reverseBetweenOnePass(ListNode head, int m, int n) {
        ListNode sudo = new ListNode(-1), tail = null, beforeStart = null;
        sudo.next = head;
        ListNode node = sudo;
        int i = 0;
        while(node != null) {
            ListNode next = node.next;
            if(i == m - 1) beforeStart = node;
            if(i >= m && i <= n) {
                if(i == m) tail = node;
                else {
                    ListNode prevHead = beforeStart.next;
                    beforeStart.next = node;
                    node.next = prevHead;
                    tail.next = next;
                }
            }
            node = next;
            i++;
        }
        return sudo.next;
    }
}
