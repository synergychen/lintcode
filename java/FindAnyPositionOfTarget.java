public class FindAnyPositionOfTarget {
  /**
   * @param A an integer array sorted in ascending order
   * @param target an integer
   * @return an integer
   */
  public int findPosition(int[] A, int target) {
    // find any position == target
    if (A == null || A.length == 0) {
      return -1;
    }

    int start = 0, end = A.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (A[mid] < target) {
        start = mid;
      } else if (A[mid] > target) {
        end = mid;
      } else {
        return mid;
      }
    }

    if (A[start] == target) {
      return start;
    } else if (A[end] == target) {
      return end;
    } else {
      return -1;
    }
  }
}
