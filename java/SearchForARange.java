public class SearchForARange {
  /**
   *@param A : an integer sorted array
   *@param target :  an integer to be inserted
   *return : a list of length 2, [index1, index2]
   */
  public int[] searchRange(int[] A, int target) {
    if (A == null || A.length == 0) {
      return new int[]{-1, -1};
    }

    int[] bound = new int[2];

    // left bound: find first position == target
    int start = 0, end = A.length - 1, mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;

      if (A[mid] >= target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (A[start] == target) {
      bound[0] = start;
    } else if (A[end] == target) {
      bound[0] = end;
    } else {
      bound[0] = bound[1] = -1;
      return bound;
    }

    // right bound: find last position == target
    start = bound[0];
    end = A.length - 1;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;

      if (A[mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (A[end] == target) {
      bound[1] = end;
      return bound;
    } else if (A[start] == target) {
      bound[1] = start;
      return bound;
    } else {
      bound[0] = bound[1] = -1;
    }

    return bound;
  }
}

