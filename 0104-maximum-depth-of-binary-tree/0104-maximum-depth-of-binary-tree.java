class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // An empty tree has depth 0
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the tree is the max of left and right subtree depths + 1 (for the current node)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
