
public class PopulatingNextRightPointerInEachNodeII {
    /*
    really differ from previous problem is the next level head is not known.
    so when checking its children, check next level head is null or not. for both left and right children.
    the rest same, set non null chilren next to prev. when ran out of this level, next level head is passed and prev reset.
    
    */
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelHead = root, prev = new TreeLinkNode(-1), next = null;
        while(levelHead != null) {

            while(levelHead != null) {
                if(levelHead.left != null) {
                    if(next == null) next = levelHead.left;
                    prev.next = levelHead.left;
                    prev = levelHead.left;
                }
                if(levelHead.right != null) {
                    if(next == null) next = levelHead.right;
                    prev.next = levelHead.right;
                    prev = levelHead.right;
                }
                levelHead = levelHead.next;
            }
            levelHead = next;
        	// set next to null. when pointer is passing the next iteration. after passed set it to null.
            next = null;
            prev = new TreeLinkNode(-1);
        }
    }
}
