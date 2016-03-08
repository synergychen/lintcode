public class JumpGame {
  /**
   * @param A: A list of integers
   * @return: The boolean answer
   */
  public boolean canJump(int[] A) {
    if (A == null || A.length == 0) {
      return false;
    }

    int n = A.length;
    boolean[] can = new boolean[n];

    can[0] = true;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (can[j] && i - j <= A[j]) {
          can[i] = true;
          break;
        }
      }
    }

    return can[n - 1];
  }
}

