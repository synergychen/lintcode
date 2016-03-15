public class PartitionList {
  /**
   * @param head: The first node of linked list.
   * @param x: an integer
   * @return: a ListNode 
   */
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }

    ListNode leftDummy = new ListNode(0);
    ListNode rightDummy = new ListNode(0);
    ListNode left = leftDummy, right = rightDummy;

    while (head != null) {
      if (head.val < x) {
        left.next = head;
        left = head;
      } else {
        right.next = head;
        right = head;
      }

      head = head.next;
    }

    left.next = rightDummy.next;
    right.next = null;

    return leftDummy.next;
  }

  private class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }
}
