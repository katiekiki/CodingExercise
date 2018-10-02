
import java.util.LinkedList;
import java.util.ListIterator;

/*
Hackerrank coding challenge question
 */

public class SuperStack {

    private static LinkedList<Integer> inputArray = new LinkedList<>();


    public static void main(String[] args) {

        pop();
        printLastElement();
        push(2);
        printLastElement();
        push(3);
        printLastElement();
        push(4);
        printLastElement();
        push(5);
        printLastElement();
        increment(2,2);
        print();

    }

    public static void print() {
        ListIterator<Integer> listIter = inputArray.listIterator();

        while(listIter.hasNext()) {
            System.out.println(listIter.next());
        }
    }

    public static void printLastElement() {
        int lastElement = peek();

        if (lastElement > 0) {
            System.out.println(lastElement);
        } else {
            System.out.println("EMPTY");
        }
    }

    public static int peek() {
        if (inputArray.size() > 0) {
            return inputArray.getLast();
        } else {
            return -1;
        }
    }

    public static Integer pop() {
        if (inputArray.size() > 0) {
            return inputArray.pollLast();
        } else {
            return -1;
        }
    }

    public static void push(Integer value) {

        inputArray.offerLast(value);
    }

    public static void increment(int noOfElements, int incrementValue) {
        ListIterator<Integer> listIter = inputArray.listIterator();

        int count = 0;

        while (listIter.hasNext()) {
            if (count > noOfElements -1) {
                break;
            }
            int oldValue = listIter.next();
            System.out.println("This is count " + count + " and oldValue " + oldValue);
            listIter.set( oldValue + incrementValue);
            count++;
        }
    }
}
