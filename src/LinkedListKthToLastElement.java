/*

from Cracking the coding interview Chapter 2 Q 02
 */
public class LinkedListKthToLastElement {
    public static void main(String[] args) {

        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 8, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        int k = 2;
        findKthElement(head,k);
        System.out.println("This is the k " + k + " and kth to the last element " + findKthElementPointers(head,k));

    }

    public static int findKthElement(LinkedListNode node, int k) {
        if (node == null)
            return 0;

        int index = findKthElement(node.next,k) + 1;

        if (index == k) {
            System.out.println("This is the kth element " + node.data);
        }

        return index;
    }

    public static int findKthElementPointers(LinkedListNode node, int k) {

        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        if (k > 0 && fast == null) {
            //kth element is bigger than the size of the linkedlist, return -1
            return -1;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}
