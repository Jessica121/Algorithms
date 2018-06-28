
public class ConvertSortedArrayToBST {
    /*
    take the middle as the root, left is left half or arr, start ~ mid - 1, right mid + 1 ~ end
    return the root.
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, start, mid - 1);
        node.right = build(nums, mid + 1, end);
        return node;
    }
}
