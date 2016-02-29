class BalancedBinaryTree {
  /**
   * @param root: The root of binary tree.
   * @return: True if this Binary tree is Balanced, or false.
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    // divide
    boolean leftIsBalanced = isBalanced(root.left);
    boolean rightIsBalanced = isBalanced(root.right);
    int maxLeftDepth = maxDepth(root.left);
    int maxRightDepth = maxDepth(root.right);

    // conquer
    return leftIsBalanced && rightIsBalanced && Math.abs(maxLeftDepth - maxRightDepth) <= 1;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return 1 + Math.max(left, right);
  }
}

class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
  }
}
