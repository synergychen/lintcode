public class LongestCommonSubstring {
  /**
   * @param A, B: Two string.
   * @return: the length of the longest common substring.
   */
  public int longestCommonSubstring(String A, String B) {
    if (A == null || B == null) {
      return 0;
    }

    if (A.length() == 0 || B.length() == 0) {
      return 0;
    }

    int m = A.length(), n = B.length();
    int[][] f = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++) {
      f[i][0] = 0;
    }

    for (int i = 0; i < n + 1; i++) {
      f[0][i] = 0;
    }

    int max = 0;

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          f[i][j] = f[i - 1][j - 1] + 1;
          max = Math.max(f[i][j], max);
        }
      }
    }

    return max;
  }
}
