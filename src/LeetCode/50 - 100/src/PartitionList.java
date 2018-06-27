
public class PartitionList {
    /*
    preserve the original order, need to append to the end of first list and tail of second list.
    tail of left link to head of right.
    can use a sudo left head and sudo right head.
    save the two heads
    the mistake of below code is making a circle when manipulating the pointers. remeber if creating a new list but using the 
    old nodes, save the next and set the next to null to prevent cycle.
    */
    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1), rightHead = new ListNode(-1), saveLeft = leftHead, saveRight = rightHead;
        while(head != null) {
        	/* Save the next node and nullify the next node.*/
        	ListNode next = head.next;
            head.next = null;
        	/* Save the next node and nullify the next node.*/
            if(head.val < x) {
                leftHead.next = head;
                leftHead = leftHead.next;
            } else {
                rightHead.next = head;
                rightHead = rightHead.next;
            }
        	/* Save the next node and nullify the next node.*/
            head = next;
        }
        if(saveLeft.next == null) return saveRight.next;
        leftHead.next = saveRight.next;
        // System.out.println(saveLeft.next.val);
        return saveLeft.next;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1), node = head;
    	int[] arr = {4,3,2,5,2};
    	for(int i = 0; i < arr.length; i++) {
    		node.next = new ListNode(arr[i]);
    		node = node.next;
    	}
    	ListNode res = partition(head, 3);
    	while(res != null) {
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
