public class UniquePaths {
  /**
   * @param n, m: positive integer (1 <= n ,m <= 100)
   * @return an integer
   */
  public int uniquePaths(int m, int n) {
    // f[i][j]: unique path num from [0, 0] to [i, j]
    int[][] f = new int[m][n];

    f[0][0] = 1;

    for (int i = 1; i < m; i++) {
      f[i][0] = 1;
    }

    for (int i = 1; i < n; i++) {
      f[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        f[i][j] = f[i - 1][j] + f[i][j - 1];
      }
    }

    return f[m - 1][n - 1];
  }
}
