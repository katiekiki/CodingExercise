/*
    CtCI 2.3 - Delete Middle Node

 */
public class LinkedListDeleteMiddleNode {


    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(0);

        LinkedListNode head = node;

        for (int i = 0; i < 8; i++) {
            LinkedListNode next = new LinkedListNode(i+1);
            node.next = next;

            node = node.next;
            
        }

        int count = 0;
        LinkedListNode testNode = head;
        while (count < 4) {
            testNode = testNode.next;
            count++;
        }

        System.out.println("before the list was updated " + head.printForward());

        removeMiddelNode(testNode);

        System.out.println("after the list was updated " + head.printForward());

    }


    public static boolean removeMiddelNode(LinkedListNode node) {

        if (node == null || node.next == null) {
            return false;
        }

        node.data = node.next.data;
        node.next = node.next.next;

        return true;
    }

}
