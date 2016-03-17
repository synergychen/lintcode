public class TwoSum {
  /*
   * @param numbers : An array of Integer
   * @param target : target = numbers[index1] + numbers[index2]
   * @return : [index1 + 1, index2 + 1] (index1 < index2)
   */
  public int[] twoSum(int[] numbers, int target) {
    int len = numbers.length;
    int[] result = new int[]{-1, -1};

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < len; i++) {
      if (map.containsKey(target - numbers[i])) {
        result[0] = map.get(target - numbers[i]);
        result[1] = i + 1;
        return result;
      }

      map.put(numbers[i], i + 1);
    }

    return result;
  }
}
