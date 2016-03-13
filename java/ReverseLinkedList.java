public class ReverseLinkedList {
  /**
   * @param head: The head of linked list.
   * @return: The new head of reversed linked list.
   */
  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode temp = head;

    while (head != null) {
      temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }

    return prev;
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

