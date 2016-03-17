class MergeSortedArray {
  /**
   * @param A: sorted integer array A which has m elements, 
   *           but size of A is m+n
   * @param B: sorted integer array B which has n elements
   * @return: void
   */
  public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    if (A == null || B == null || A.length == 0 || B.length == 0) {
      return;
    }

    int i = m - 1, j = n - 1, p = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (A[i] > B[j]) {
        A[p--] = A[i--];
      } else {
        A[p--] = B[j--];
      }
    }

    // A is empty
    if (i < 0) {
      for (i = 0; i <= j; i++) {
        A[i] = B[i];
      }
    }
  }
}
