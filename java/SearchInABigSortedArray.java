/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class SearchInABigSortedArray {
  /**
   * @param reader: An instance of ArrayReader.
   * @param target: An integer
   * @return : An integer which is the index of the target number
   */
  public int searchBigSortedArray(ArrayReader reader, int target) {
    // set boundary
    int k = 1;

    while (reader.get(k - 1) != -1 && reader.get(k - 1) < target) {
      k = k * 2;
    }

    // find first position == target
    int start = 0, end = k - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (reader.get(mid) != -1 && reader.get(mid) < target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (reader.get(start) == target) {
      return start;
    } else if (reader.get(end) == target) {
      return end;
    } else {
      return -1;
    }
  }
}
