class FindMinimumInRotatedSortedArray {
  /**
   * @param num: a rotated sorted array
   * @return: the minimum number in the array
   */
  public int findMin(int[] num) {
    // find first <= target, target == last element
    if (num == null || num.length == 0) {
      return -1;
    }

    int start = 0, end = num.length - 1;
    int target = num[end];

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (num[mid] <= target) {
        end = mid;
      } else if (num[mid] > target) {
        start = mid;
      }
    }

    if (num[start] <= target) {
      return num[start];
    } else if (num[end] <= target) {
      return num[end];
    } else {
      return -1;
    }
  }
}
