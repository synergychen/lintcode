public class JumpGameII {
  /**
   * @param A: A list of lists of integers
   * @return: An integer
   */
  public int jump(int[] A) {
    int len = A.length;

    int[] minSteps = new int[len];

    minSteps[0] = 0;

    for (int i = 1; i < len; i++) {
      minSteps[i] = Integer.MAX_VALUE;

      for (int j = 0; j < i; j++) {
        if (minSteps[j] != Integer.MAX_VALUE && i - j <= A[j]) {
          minSteps[i] = Math.min(minSteps[j] + 1, minSteps[i]);
        }
      }
    }

    return minSteps[len - 1];
  }
}

