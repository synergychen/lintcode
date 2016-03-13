public class RemoveDuplicatesFromSortedListII {
  /**
   * @param ListNode head is the head of the linked list
   * @return: ListNode head of the linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode curt = head;

    while (curt != null && curt.next != null) {
      if (curt.val == curt.next.val) {
        // remove all duplicates of curt
        while (curt.next != null && curt.val == curt.next.val) {
          curt.next = curt.next.next;
        }

        // remove curt
        prev.next = curt.next;
        curt = prev.next;
      } else {
        prev = prev.next;
        curt = curt.next;
      }
    }

    return dummy.next;
  }

  private class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
