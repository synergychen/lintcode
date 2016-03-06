class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class ResultType {
  boolean isBST;
  int maxValue, minValue;

  ResultType(boolean isBST, int maxValue, int minValue) {
    this.isBST = isBST;
    this.maxValue = maxValue;
    this.minValue = minValue;
  }
}

public class ValidateBinarySearchTree{
  /**
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    ResultType r = validBSTHelper(root);

    return r.isBST;
  }

  public ResultType validBSTHelper(TreeNode root) {
    if (root == null) {
      return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // divide
    ResultType left = validBSTHelper(root.left);
    ResultType right = validBSTHelper(root.right);

    // conquer
    if (!left.isBST || !right.isBST) {
      return new ResultType(false, 0, 0);
    }

    if ((root.left != null && left.maxValue >= root.val) ||
        (root.right != null && right.minValue <= root.val)) {
      return new ResultType(false, 0, 0);
        }

    return new ResultType(true,
        Math.max(root.val, right.maxValue),
        Math.min(root.val, left.minValue));
  }
}
