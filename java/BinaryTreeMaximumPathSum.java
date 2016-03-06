public class BinaryTreeMaximumPathSum {
  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxPathSum(TreeNode root) {
    ResultType r = maxPathSumHelper(root);

    return r.maxPath;
  }

  private class ResultType {
    // singlePath: max path from root to any node
    // maxPath: max path from any node to any node
    int singlePath, maxPath;

    ResultType(int singlePath, int maxPath) {
      this.singlePath = singlePath;
      this.maxPath = maxPath;
    }
  }

  private ResultType maxPathSumHelper(TreeNode root) {
    if (root == null) {
      return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    // divide
    ResultType left = maxPathSumHelper(root.left);
    ResultType right = maxPathSumHelper(root.right);

    // conquer
    int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

    int maxPath = Math.max(Math.max(left.maxPath, right.maxPath),
        Math.max(left.singlePath, 0) +
        Math.max(right.singlePath, 0) +
        root.val);

    return new ResultType(singlePath, maxPath);
  }

  private class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }
}

