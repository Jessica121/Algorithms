
public class PalidromLinkedList {
    /*
    recursion: know when it is even or when it is odd.
    if odd, return next when itself is the mid. else return itself.
    check recursion false or true first. else return false and where it went wrong.
    compare itself with the recursion, if equal, return recursion's next.
    else return false. have a class wrap them.
    
    */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? check(head, slow, true).isP : check(head, slow, false).isP;
    }
    
    private Ret check(ListNode node, ListNode mid, boolean isEven) {
        if(node == mid) return new Ret((isEven ? node : node.next), true);
        Ret next = check(node.next, mid, isEven);
        if(!next.isP) return next;
        if(node.val != next.node.val) return new Ret(node, false);
        return new Ret(next.node.next, true);
    }
    
    class Ret {
        boolean isP;
        ListNode node;
        public Ret(ListNode node, boolean isP) {
            this.isP = isP;
            this.node = node;
        }
    }
}
