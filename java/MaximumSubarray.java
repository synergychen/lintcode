public class MaximumSubarray {
  /**
   * @param nums: A list of integers
   * @return: A integer indicate the sum of max subarray
   */
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Integer.MIN_VALUE;
    }

    // f[i]: largest sum ending with nums[i]
    int len = nums.length;
    int[] f = new int[len];

    f[0] = nums[0];
    int max = f[0];

    for (int i = 1; i < len; i++) {
      f[i] = f[i - 1] < 0 ? nums[i] : f[i - 1] + nums[i];
      max = Math.max(f[i], max);
    }

    return max;
  }
}
