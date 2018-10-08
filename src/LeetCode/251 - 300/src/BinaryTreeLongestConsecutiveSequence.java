    /*
    keep a global variable to track the longest.
    recursively pass the children. pass the self value.
    compare with parent value, if self large by it by 1, increase the length by 1 and pass it on.
    else the length pass on 1, or the length set to 0.
    cmp to global value.
    pass on left right child, base case node is null.
    pass on the length, self value.=> could pass on self node reference as well. 
    
    the tricky part is the len is calculated continusly or not. need to know if the len it increases pass the immediate parent or not.
    
    */
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return res;
        checkLongest(root, null, res);
        return res;
    }
    
    private void checkLongest(TreeNode root, TreeNode parent, int len) {
        if(root == null) return;
        len = (parent == null || parent.val + 1 != root.val) ? 1 : len + 1;
        res = Math.max(res, len);
        checkLongest(root.left, root, len);
        checkLongest(root.right, root, len);
    }