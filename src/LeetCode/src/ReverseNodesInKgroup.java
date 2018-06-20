
public class ReverseNodesInKgroup {
    /*
    Recursion: use a cnter to cnt the rank in the list it is.
    for each cnt, its next is recursion cnt - 1
    if cnt == 1, then it is the head and node.next = recursion cnt = k; restart
    return both the tail and the head.
    if cnt != 1, append itself to the tail and set itself as the tail.
    else itself is the head. mind this case itself is also the tail, for the previous nodes (in the upper recursion stack)
     to be able to append next to it.
    return cur. 
    
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        return reverse(head, k, k)[0];
    }
    
    private ListNode[] reverse(ListNode node, int k, int cnt) {
        if(node != null && node.next == null) return new ListNode[] {node, node};
        if(cnt == 1) {
            ListNode[] next = reverse(node.next, k, k);
            node.next = next[0];
            // return head head not head tail, since the previous ones need to append next to this, and this needs to be the tail.
            return new ListNode[] {node, node};
        }
        ListNode[] next = reverse(node.next, k, cnt - 1);
        // this next line is only for the purpose of the definition of the problem... remove could reverse even if the list len < k.
        if(cnt - 1 != 1 && next[0] == next[1]) return new ListNode[] {node, node};
        ListNode nextnext = next[1].next;
        next[1].next = node;
        node.next = nextnext;
        return new ListNode[] {next[0], node};
    }
}
