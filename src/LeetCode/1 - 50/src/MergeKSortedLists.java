import java.util.*;
public class MergeKSortedLists {
    /*
    merge left half, then right half, then merge the two
    half is determined by the range in the array of the list.
    base case is when start == end return this list.
    return the head.
    O(nlogn)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] list, int start, int end) {
        if(start == end) return list[start];
        if(start > end) return null; // for an empty list.
        int mid = start + (end - start) / 2;
        ListNode left = merge(list, start, mid), right = merge(list, mid + 1, end);
        return mergeTwo(left, right);
    }
    
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) l1.next = mergeTwo(l1.next, l2);
        else l2.next = mergeTwo(l1, l2.next);
        return l1.val <= l2.val ? l1 : l2;
    }
    
    
    /*
    Pq: min heap, smaller head, next put back. set next == null
    if head == null, set head. tail = head.
    else tail.next = this.
    set tail.
    nlogn
    */
    public ListNode mergeKListsPQ(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        buildPQ(pq, lists);
        ListNode head = null, tail = null;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) pq.offer(node.next);
            node.next = null;
            if(head == null) {
                head = node;
                tail = head;
            } else tail.next = node;
            tail = node;
        }
        return head;
    }
    
    private void buildPQ(PriorityQueue<ListNode> pq, ListNode[] lists) {
        // it may be null nodes in here.
        for(ListNode node : lists) if(node != null) pq.offer(node);
    } 
}
