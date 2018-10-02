import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
  CtCI Problem 2.1 Remove Dups
 */

public class LinkedListRemoveDuplicates {

    public static void main(String[] args) {

        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 4, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        removeDuplicates_usingHashSet(head);
        System.out.println(head.printForward());

    }

    public static void removeDuplicateNode(LinkedListNode node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public static void removeDuplicates(LinkedListNode node) {
        Map<Integer,Integer> dataMap = new HashMap<>();
        //go through the linkedlist and put all values into a hashmap

        dataMap.put(node.data,1);
        while (node.next != null) {
            node = node.next;
            if (dataMap.containsKey(node.data)) {
                //remove the element
                removeDuplicateNode(node);
            } else {
                dataMap.put(node.data,1);
            }
        }

    }

    public static void removeDuplicates2(LinkedListNode node) {

        Set<Integer> dataSet = new HashSet<>();
        LinkedListNode previous = null;

        while (node != null) {
            if (dataSet.contains(node.data)) {
                previous.next = node.next;
            } else {
                dataSet.add(node.data);
                previous = node;
            }

            node = node.next;
        }

    }

    public static void removeDuplicates3(LinkedListNode node) {
        LinkedListNode current = node;

        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void removeDupicates4(LinkedListNode node) {

        LinkedListNode current = node;
        System.out.println("this is current " + current.data);
        while (current != null) {

            LinkedListNode runner = current;
            System.out.println("this is runner " + runner.data);

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void removeDuplicates_usingHashSet(LinkedListNode node) {
        Set<Integer> dataSet = new HashSet<>();

        LinkedListNode current = node;
        dataSet.add(current.data);
        while (current.next != null) {
            if (dataSet.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                dataSet.add(current.next.data);
                current = current.next;
            }
        }

    }
}
