public class MaximumSubarrayII {
  /**
   * @param nums: A list of integers
   * @return: An integer denotes the sum of max two non-overlapping subarrays
   */
  public int maxTwoSubArrays(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return Integer.MIN_VALUE;
    }

    int len = nums.size();
    int[] left = new int[len], right = new int[len];

    left[0] = nums.get(0);
    right[len - 1] = nums.get(len - 1);

    int leftMax = left[0], rightMax = right[len - 1];

    for (int i = 1; i < len; i++) {
      left[i] = Math.max(left[i - 1], 0) + nums.get(i);
    }

    for (int j = len - 2; j >= 0; j--) {
      right[j] = Math.max(right[j + 1], 0) + nums.get(j);
    }

    int max = nums.get(0) + nums.get(len - 1);

    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        max = Math.max(left[i] + right[j], max);
      }
    }

    return max;
  }
}


