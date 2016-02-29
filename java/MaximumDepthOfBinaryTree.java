/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class MaximumDepthOfBinaryTree {
  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // divide
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    // conquer
    return 1 + Math.max(left, right);
  }
}
