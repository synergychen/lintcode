public class DistinctSubsequence {
  /**
   * @param S, T: Two string.
   * @return: Count the number of distinct subsequences
   */
  public int numDistinct(String S, String T) {
    int m = T.length(), n = S.length();
    int[][] f = new int[m + 1][n + 1];

    for (int i = 1; i < m + 1; i++) {
      f[i][0] = 0;
    }

    for (int i = 0; i < n + 1; i++) {
      f[0][i] = 1;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (T.charAt(i - 1) == S.charAt(j - 1)) {
          f[i][j] = f[i - 1][j - 1] + f[i][j - 1];
        } else {
          f[i][j] = f[i][j - 1];
        }
      }
    }

    return f[m][n];
  }
}
