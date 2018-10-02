/*

  Cracking the coding interview 1.3 URLify
 */

public class URLify {

    public static void main(String[] args) {

        String input = "take it easy    ";

        System.out.println("input string : " + input + " updated string " + replaceSpaces(input,12));

    }

    public static String replaceSpaces(String input, int trueLength) {
        char[] inputArray = input.toCharArray();

        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            if (inputArray[i] == ' ') {
                count++;
            }
        }

        int newLength = trueLength + count * 2;
        int backCounter = newLength - 1;
        for (int j = trueLength -1; j >= 0; j--) {
            if (inputArray[j] == ' ') {
                inputArray[backCounter] = '0';
                inputArray[backCounter - 1] = '2';
                inputArray[backCounter - 2] = '%';
                backCounter = backCounter -3;
            } else {
                inputArray[backCounter] = inputArray[j];
                backCounter--;
            }

        }

        return new String(inputArray);
    }
}
