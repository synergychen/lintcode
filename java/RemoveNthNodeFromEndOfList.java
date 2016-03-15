public class RemoveNthNodeFromEndOfList {
  /**
   * @param head: The first node of linked list.
   * @param n: An integer.
   * @return: The head of linked list.
   */
  ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prevDelete = dummy;

    for (int i = 0; i < n; i++) {
      if (head == null) {
        return null;
      }

      head = head.next;
    }

    while (head != null) {
      head = head.next;
      prevDelete = prevDelete.next;
    }

    prevDelete.next = prevDelete.next.next;

    return dummy.next;
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

