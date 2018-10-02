/*
Leetcode 21. Merge Two Sorted Lists
 */
public class LinkedListMergeTwoSortedList {

    public static void main(String[] args) {

//        ListNode l1a = new ListNode(1);
//        ListNode l1b = new ListNode(2);
//        ListNode l1c = new ListNode(4);
//        ListNode l2a = new ListNode(1);
//        ListNode l2b = new ListNode(3);
//        ListNode l2c = new ListNode(4);

        ListNode l1a = new ListNode(-9);
        ListNode l1b = new ListNode(3);

        ListNode l2a = new ListNode(5);
        ListNode l2b = new ListNode(7);

        l1a.next = l1b;
//        l1b.next = l1c;

        l2a.next = l2b;
//        l2b.next = l2c;

        ListNode result = mergeTwoLists(l1a,l2a);

        while(result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result;
        ListNode head;

        if (l1.val < l2.val) {
            result = l1;
            head = result;
            l1 = l1.next;
        } else {
            result = l2;
            head = result;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        while (l1 != null) {
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }

        while (l2 != null) {
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }

        return head;
    }

}
