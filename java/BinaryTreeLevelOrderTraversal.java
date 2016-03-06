public class BinaryTreeLevelOrderTraversal {
  /**
   * @param root: The root of binary tree.
   * @return: Level order a list of lists of integer
   */
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (root == null) {
      return result;
    }

    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      ArrayList<Integer> level = new ArrayList<Integer>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      result.add(level);
    }

    return result;
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
