public class Triangle {
  /**
   * @param triangle: a list of lists of integers.
   * @return: An integer, minimum path sum.
   */
  public int minimumTotal(int[][] triangle) {
    if (triangle == null || triangle.length == 0) {
      return Integer.MAX_VALUE;
    }

    if (triangle[0] == null || triangle[0].length == 0) {
      return Integer.MAX_VALUE;
    }

    // state: min path sum from [0, 0] to [x, y]
    int n = triangle.length;
    int[][] f = new int[n][n];

    // initialize: two sides of triangle
    f[0][0] = triangle[0][0];

    for (int i = 1; i < n; i++) {
      f[i][0] = f[i - 1][0] + triangle[i][0];
      f[i][i] = f[i - 1][i - 1] + triangle[i][i];
    }

    // function
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < i; j++) {
        f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
      }
    }

    // answer
    int minSum = Integer.MAX_VALUE;

    for (int j = 0; j < n; j++) {
      if (f[n - 1][j] < minSum) {
        minSum = f[n - 1][j];
      }
    }

    return minSum;
  }
}

