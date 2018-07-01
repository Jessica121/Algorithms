import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    /*
    use a map to create the list: if the node not in the map, create a new one, assign the next, if not there, create, random, if not there, create, go to the next one.
    
    */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode save = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head != null) {
            if(!map.containsKey(head)) map.put(head, new RandomListNode(head.label));
            if(head.next != null) {
                if(!map.containsKey(head.next)) map.put(head.next, new RandomListNode(head.next.label));
                map.get(head).next = map.get(head.next);
            }
            if(head.random != null) {
                if(!map.containsKey(head.random)) map.put(head.random, new RandomListNode(head.random.label));
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }
        // save the node before change.
        return map.get(save);
    }
    
    private static class RandomListNode {
    	int label;
    	RandomListNode next, random;
    	RandomListNode(int x) { this.label = x; }
    };
    
    // i dont know why this wont pass. it works fine here.
    public static RandomListNode copyRandomListNoSpace(RandomListNode head) {
        if(head == null) return null;
        RandomListNode save = head;
        while(head != null) {
            RandomListNode next = head.next, copy = new RandomListNode(head.label - 10);
            head.next = copy;
            copy.next = next;
            head = next;
        }
        RandomListNode orgionHead = save, saveCopyHead = save.next;
        while(save != null) {
            RandomListNode copy = save.next, copyNext = copy.next;
            save.next = copyNext;
            if(copyNext != null) {
                copy.next = copyNext.next;
            }
            if(save.random != null) copy.random = save.random.next;
            save = copyNext;
        }
//        System.out.println(saveCopyHead.random.label);
        return saveCopyHead;
    }
    
    public static void main(String[] args) {
    	RandomListNode head = new RandomListNode(-1), second = new RandomListNode(-1), third = new RandomListNode(3), save = head;
    	head.next = second;
//    	second.next = third;
    	head.random = second;
	      RandomListNode temp = copyRandomListNoSpace(save);
	      while(temp != null) {
	    	 System.out.println(temp.label);
	    	 if(temp.random != null) {
	    		 System.out.println("	its random is " + temp.random.label);
	    	 }
  		 temp = temp.next;
	      }
    }
}
