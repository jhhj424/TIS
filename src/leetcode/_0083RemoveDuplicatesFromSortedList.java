package leetcode;


public class _0083RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode fast = head.next;
        ListNode slow = head;
        slow.next = null;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
                slow.next = null;
            }
        }
        return head;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
