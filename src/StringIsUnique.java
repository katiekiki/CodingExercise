/*
  Cracking the Coding Interview 1.1 IsUnique
 */

public class StringIsUnique {

    public static void main(String[] args) {
        String input = "abcda";

        System.out.println("is the input " + input + " unique ? " + isUnique(input));

    }

    public static boolean isUnique(String input) {
        if (input.length() > 128) return false;

        boolean[] inputTrace = new boolean[128];
        char[] inputCharArray = input.toCharArray();

        for (int i = 0; i < inputCharArray.length; i++) {

            if (inputTrace[inputCharArray[i]]) {
                return false;
            } else {
                inputTrace[inputCharArray[i]] = true;
            }

        }

        return true;
    }

}
