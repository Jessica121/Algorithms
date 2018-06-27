import java.util.HashMap;
import java.util.Map;

public class RotateList {
    /*
    firstly know the size, then start from 0 calculate the offset by (0 + k) % len = new index
    so 0 will end up in index new index, means last new index element put into front.
    can use a map to track index and the element, take space and save time. 
    depends on what matters more.
    
    */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        ListNode node = head;
        while(node != null) {
            map.put(i++, node);
            node = node.next;
        }
        int newIndex = k % i;
        // dont forget that if no rotation needed, the map wont get the value. return head.
        if(newIndex == 0) return head;
        ListNode newHead = map.get(i - newIndex);
        // System.out.println(newHead.val);
        map.get(i - 1).next = head;
        map.get(i - newIndex - 1).next = null;
        return newHead;
    }
    
    /*
    no map version:
    calculate the length first, when the pointer point to the tail, let it stay.
    then have another pointer move from the head by the same offset techniqu used, 
    save its next and set its next is null and tail.next is the head. return next.
    
    */
    public ListNode rotateRightNoMap(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head, node = head, next = null;
        int i = 0;
        while(tail != null) {
            i++;
            if(tail.next == null) break; // node is the tail.
            tail = tail.next;
        }
        // offset is the length - number to move
        int offset = i - k % i;
        if(offset == i) return head;
        // System.out.println(offset);

        while(offset - 1 > 0) {
            node = node.next;
            offset--;
        }
        next = node.next;
        node.next = null;
        tail.next = head;
        return next;
    }
}
