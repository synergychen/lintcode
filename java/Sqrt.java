public class Sqrt {
  /**
   * @param x: An integer
   * @return: The sqrt of x
   */
  public int sqrt(int x) {
    // find last y that y^2 <= x
    long start = 0, end = x;

    while (start + 1 < end) {
      long mid = start + (end - start) / 2;

      if (mid * mid < x) {
        start = mid;
      } else if (mid * mid > x) {
        end = mid;
      } else {
        return (int) mid;
      }
    }

    if (end * end <= x) {
      return (int) end;
    }

    return (int) start;
  }
}
