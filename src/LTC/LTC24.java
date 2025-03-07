package LTC;

public class LTC24 {

    /**
     * O(n) / O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode temp = new ListNode(-1, head);
        ListNode result = temp;

        while (temp.next != null && temp.next.next != null) {
            ListNode f = temp.next;
            ListNode s = f.next;

            f.next = s.next;
            s.next = f;
            temp.next = s;

            temp = temp.next.next;
        }

        return result.next;

    }

    public ListNode swapPairs2(ListNode head) {
        ListNode temp = new ListNode(-1, head);
        ListNode result = temp;

        while (temp.next != null && temp.next.next != null) {
            ListNode other = temp.next.next.next;  // 바꿀 대상 다음 ex)3
            ListNode first = temp.next;
            temp.next = temp.next.next;
            first.next = other;
            temp.next.next = first;

            temp = temp.next.next;
        }

        return result.next;
    }
}
