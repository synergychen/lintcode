public class LongestCommonSubsequence {
  /**
   * @param A, B: Two strings.
   * @return: The length of longest common subsequence of A and B.
   */
  public int longestCommonSubsequence(String A, String B) {
    int m = A.length(), n = B.length();
    int[][] f = new int[m + 1][n + 1];

    // initialize
    for (int i = 0; i < m + 1; i++) {
      f[i][0] = 0;
    }

    for (int i = 0; i < n + 1; i++) {
      f[0][i] = 0;
    }

    // state function
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          f[i][j] = f[i - 1][j - 1] + 1;
        } else {
          f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
        }
      }
    }

    // final
    return f[m][n];
  }
}
