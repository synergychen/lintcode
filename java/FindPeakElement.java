class FindPeakElement {
  /**
   * @param A: An integers array.
   * @return: return any of peek positions.
   */
  public int findPeak(int[] A) {
    // find any position > left and < right
    if (A == null || A.length == 0) {
      return -1;
    }

    int start = 1, end = A.length - 2;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (A[mid] < A[mid - 1]) {
        end = mid;
      } else if (A[mid] < A[mid + 1]) {
        start = mid;
      } else {
        return mid;
      }
    }

    if (A[start] < A[end]) {
      return end;
    } else {
      return start;
    }
  }
}
