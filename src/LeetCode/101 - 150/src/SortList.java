
public class SortList {
    /*
    quick sort: pick the head node, smaller put to left, big right.
    recursively sort left and right.
    left: start is head, end is self. right, start is self next end is tail
    link start tail - self - head next.
    each call could return both head and tail.
    if node next is null, return node, node.
    iterate: node not equal to tail
    keep a left head, cur point to next next, node append to left head, update left head.
    recurse left and right
    */
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return sort(head, null)[0];
    }
    
    private ListNode[] sort(ListNode start, ListNode tail) {
        if(start == tail) return null;
        if(start.next == tail) return new ListNode[] {start, start};
        ListNode iter = start.next, leftHead = start, rightTail = start;
        while(iter != tail) {
            ListNode next = iter.next;
            if(iter.val < start.val) {
                rightTail.next = iter.next;
                iter.next = leftHead;
                leftHead = iter;
            } else rightTail = iter;
            iter = next;
        }
        ListNode[] left = sort(leftHead, start), right = sort(start.next, tail);
        if(left != null) left[1].next = start;
        if(right != null) start.next = right[0];
        return new ListNode[] {left == null ? start : left[0], right == null ? start : right[1]};
    }
}
