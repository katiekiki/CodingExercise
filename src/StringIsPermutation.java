/*
Cracking the coding interview 1.1 Check Permutation
 */

public class StringIsPermutation {

    public static void main(String[] args) {

        String input1 = "abcdefg";
        String input2 = "dagcbef";

        System.out.println("Is input 1: " + input1 + " permutations of input 2: " + input2 + " ? " + permutation(input1,input2));

    }

    public static boolean permutation(String input1, String input2) {


        if (input1.length() != input2.length()) {
            return false;
        }

        int[] charCount = new int[128];
        char[] input1Array = input1.toCharArray();

        //keep track of characters in input1
        for(int i = 0; i < input1Array.length; i++) {
            charCount[input1Array[i] - 'a']++;
        }

        char[] input2Array = input2.toCharArray();
        //keep track of characters in input1
        for(int j = 0; j < input1Array.length; j++) {
            charCount[input2Array[j] - 'a']--;
            if (charCount[input2Array[j] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
