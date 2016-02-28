public class SearchA2dMatrix {
  /**
   * @param matrix, a list of lists of integers
   * @param target, an integer
   * @return a boolean, indicate whether matrix contains target
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row;

    // find row: find last row <= target
    int start = 0, end = matrix.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (matrix[mid][0] < target) {
        start = mid;
      } else if (matrix[mid][0] > target) {
        end = mid;
      } else {
        return true;
      }
    }

    if (matrix[end][0] <= target) {
      row = end;
    } else if (matrix[start][0] <= target) {
      row = start;
    } else {
      return false;
    }

    // find column: find any column == target
    start = 0;
    end = matrix[0].length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (matrix[row][mid] < target) {
        start = mid;
      } else if (matrix[row][mid] > target) {
        end = mid;
      } else {
        return true;
      }
    }

    if (matrix[row][start] == target || matrix[row][end] == target) {
      return true;
    }

    return false;
  }
}

