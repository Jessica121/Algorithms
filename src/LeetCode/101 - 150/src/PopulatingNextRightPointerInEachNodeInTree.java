
public class PopulatingNextRightPointerInEachNodeInTree {
    /*
    save the head node, outter loop check the head of the level is not null and save its next.
    inner loop starts with level head, set its child left to right and set prev.
    reach the end of the level, set the prev null or sudo head.
    
    */
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelHead = root, prev = new TreeLinkNode(-1), next = null;
        while(levelHead != null) {
            next = levelHead.left;
            while(levelHead != null) {
            	// check the child is not null
                if(levelHead.left != null) {
                    prev.next = levelHead.left;
                    prev = levelHead.left;
                }
                if(levelHead.right != null) {
                    prev.next = levelHead.right;
                    prev = levelHead.right;
                }
                levelHead = levelHead.next;
            }
            prev = new TreeLinkNode(-1);
            levelHead = next;
        }
    }
}
