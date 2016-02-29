public class SearchInRotatedSortedArray {
  /**
   *@param A : an integer rotated sorted array
   *@param target :  an integer to be searched
   *return : an integer
   */
  public int search(int[] A, int target) {
    // find minimum index
    // find first position <= last element
    if (A == null || A.length == 0) {
      return -1;
    }

    int start = 0, end = A.length - 1, mid;
    int lastElement = A[A.length - 1];

    while (start + 1 < end) {
      mid = start + (end - start) / 2;

      if (A[mid] <= lastElement) {
        end = mid;
      } else {
        start = mid;
      }
    }

    int minIndex;

    if (A[start] <= lastElement) {
      minIndex = start;
    } else if (A[end] <= lastElement) {
      minIndex = end;
    } else {
      return -1;
    }

    // find any position of target
    if (target <= lastElement) {
      start = minIndex;
      end = A.length - 1;
    } else {
      start = 0;
      end = minIndex - 1;
    }

    while (start + 1 < end) {
      mid = start + (end - start) / 2;

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
    }

    return -1;
  }
}

