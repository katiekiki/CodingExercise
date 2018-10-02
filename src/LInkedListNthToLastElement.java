public class LInkedListNthToLastElement {

    public static class Node {

        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }

        Node head = current;
        System.out.println(linkedListToString(head));
        Node result = nthFromLast(head,1);
        System.out.println("when n = 1 and nth node from the last is " + result.val);

        result = nthFromLast(head,5);
        System.out.println("when n = 5 and nth node from the last is " + result.val);


        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        System.out.println(linkedListToString(head2));

        result = nthFromLast(head2,2);
        System.out.println("when n = 2 and nth node from the last is " + result.val);

        result = nthFromLast(head2,4);
        System.out.println("when n = 4 and nth node from the last is " + result.val);

        result = nthFromLast(head2,5);
        if (result == null) {
            System.out.println("when n = 5 and nth node from the last is null");
        } else {
            System.out.println("when n = 5 and nth node from the last is " + result.val);
        }

        result = nthFromLast(null,1);
        if (result == null) {
            System.out.println("when n = 1 but head = null and nth node from the last is null");
        } else {
            System.out.println("when n = 1 but head = null and nth node from the last is " + result.val);
        }
        // nthFromLast(head, 5) should return 5.
        // nthFromLast(head2, 2) should return 3.
        // nthFromLast(head2, 4) should return 1.
        // nthFromLast(head2, 5) should return null.
        // nthFromLast(null, 1) should return null.


    }

    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.val));
            sb.append(" -> ");
            current = current.next;
        }
        sb.append("(null)");
        return sb.toString();
    }

    public static Node nthFromLast(Node head, int n) {

        Node fastPtr = head, slowPtr = head;

        //advance fastPtr to n elements from head
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                return null;
            }
            fastPtr = fastPtr.next;
        }

        //then start slowPtr and fastPtr until fastPtr hits the end of the
        //linkedlist - slowPtr would be at the the element nth from the last

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }

}
