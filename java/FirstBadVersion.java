/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class FirstBadVersion {
  /**
   * @param n: An integers.
   * @return: An integer which is the first bad version.
   */
  public int findFirstBadVersion(int n) {
    // find first position == bad version
    if (n == 0) {
      return -1;
    }

    int start = 1, end = n;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (SVNRepo.isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (SVNRepo.isBadVersion(start)) {
      return start;
    }

    return end;
  }
}

