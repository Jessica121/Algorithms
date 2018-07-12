
public class DelNodeInLinkedListExceptTheTail {
    /*
    set next node val to self and remove the next
    self.next = self.next.next
    
    */
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
