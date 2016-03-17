class SortColors {
  /**
   * @param nums: A list of integer which is 0, 1 or 2 
   * @return: nothing
   */
  public void sortColors(int[] nums) {
    // // bubble sort
    if (nums == null || nums.length <= 1) {
      return;
    }

    int pLeft = 0, pRight = nums.length - 1, i = 0;

    while (i <= pRight) {
      if (nums[i] == 0) {
        swap(nums, i++, pLeft++);
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, i, pRight--);
      }
    }
  }

  public void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
