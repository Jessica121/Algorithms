import java.util.*;
public class SerializeAndDeserilizeBinarySize {
    /*
    use an in order traversal, append to a string builder, append self and a splitter.
    then if self is not null, call left and right.
    call a helper function.
    */
    private final String NULL = "null", SPLIT = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NULL).append(SPLIT);
            return;
        }
        sb.append(node.val).append(SPLIT);
        encode(node.left, sb);
        encode(node.right, sb);
    }
    
    // Decodes your encoded data to tree.
    /*
    split the data by the splitter, and put it into a queue.
    poll the top of the queue. its not gonna be empty baby.
    build self (create a node of value top), if the value is null, return null.
    else build the node, left is recursive left and right is recursive right, return itself.
    need a helper function for it.
    */
    public TreeNode deserialize(String data) {
        String[] arr = data.split(SPLIT);
        Queue<String> que = new LinkedList<>(); 
        putIntoQueue(arr, que);
        return decode(que);
    }
    
    private TreeNode decode(Queue<String> que) {
        String val = que.poll();
        if(val.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = decode(que);
        node.right = decode(que);
        return node;
    }
    
    private void putIntoQueue(String[] arr, Queue<String> que) {
        for(String str : arr) {
            if(!str.isEmpty()) que.offer(str);
        }
    }
}
