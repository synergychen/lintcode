public class UniquePathsII {
  /**
   * @param obstacleGrid: A list of lists of integers
   * @return: An integer
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0) {
      return -1;
    }

    if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
      return -1;
    }

    // f[i][j]: unique paths num from [0, 0] to [i, j]
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] f = new int[m][n];

    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    f[0][0] = 1;

    for (int i = 1; i < m; i++) {
      f[i][0] = (obstacleGrid[i][0] == 1 ? 0 : f[i - 1][0]);
    }

    for (int i = 1; i < n; i++) {
      f[0][i] = (obstacleGrid[0][i] == 1 ? 0 : f[0][i - 1]);
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        f[i][j] = (obstacleGrid[i][j] == 1 ? 0 : f[i - 1][j] + f[i][j - 1]);
      }
    }

    return f[m - 1][n - 1];
  }
}
