import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   Common Elements Two Sorted Arrays
   11-essential-coding-interview-questions (udemy)
 */
public class CommonElementTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).

        System.out.println("Common elements in array1 : " + Arrays.toString(array1A) + " and array2: " + Arrays.toString(array2A) +
                           " are " + Arrays.toString(commonElements(array1A, array2A)));

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
        System.out.println("Common elements in array1 : " + Arrays.toString(array1B) + " and array2: " + Arrays.toString(array2B) +
                " are " + Arrays.toString(commonElements(array1B, array2B)));

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        System.out.println("Common elements in array1 : " + Arrays.toString(array1C) + " and array2: " + Arrays.toString(array2C) +
                " are " + Arrays.toString(commonElements(array1C, array2C)));

    }

    public static Integer[] commonElements(int[] array1, int[] array2) {

        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) {
            return null;
        }
        List<Integer> resultArray =  new ArrayList<>();

        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < array1.length && ptr2 < array2.length) {

            if (array1[ptr1] == array2[ptr2]) {
                resultArray.add(array1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (array1[ptr1] < array2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }

        }

        Integer[] result = new Integer[resultArray.size()];

        return resultArray.toArray(result);
    }
}
