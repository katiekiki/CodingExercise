import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
  Question from 11-essential-coding-interview-questions (udemy)
 */
public class IntegerMostFrequent {

    public static void main(String[] args) {

        int[][] inputArray = {{1,3,1,3,2,1},{3,3,1,3,2,1},{},{0},{0, -1, 10, 10, -1, 10, -1, -1, -1, 1}};

        for (int[] inputArr : inputArray) {
            if (inputArr == null || inputArr.length == 0) {

                System.out.println("Input Array is empty!");
            } else {

                System.out.println("The most frequent element of input array : " + Arrays.toString(inputArr) + " is [" + mostFrequent(inputArr) + "]");
            }

        }


    }

    public static int mostFrequent(int[] input) {

        Map<Integer,Integer> countMap = new HashMap<>();
        int max = 0;
        int maxElementIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (countMap.containsKey(input[i])) {
                countMap.put(input[i],countMap.get(input[i]) +1);
                if (countMap.get(input[i]) > max) {
                    max = countMap.get(input[i]);
                    maxElementIndex = i;
                }
            } else {
                countMap.put(input[i],1);
            }
        }

        return input[maxElementIndex];
    }
}
