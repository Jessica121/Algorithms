
public class ConvertSortedListToBST {
    /*
    same technique to convert sorted array.
    find the middle: fast == tail || fast.next == tail
    left is head to mid, right is mid.next to null
    if head == tail, return null.
    
    */
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head, null);
    }
    
    private TreeNode convert(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = convert(head, slow);
        node.right = convert(slow.next, tail);
        return node;
    }
}
}
