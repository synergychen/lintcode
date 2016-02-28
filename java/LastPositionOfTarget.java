public class LastPositionOfTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // find last position == target
        int lenA = A.length;

        if (A == null || lenA == 0) {
            return -1;
        }

        int start = 0, end = lenA - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[end] == target) {
            return end;
        } else if (A[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
