public class StringReversedIII {

    public static void swap(char[] input, int from, int to) {

        char temp = input[from];
        input[from] = input[to];
        input[to] = temp;


    }



    public static void reverseString(char[] input) {

        int frontPtr = 0;
        int backPtr = input.length -1;

        while (frontPtr < backPtr) {
            swap(input,frontPtr,backPtr);
            frontPtr++;
            backPtr--;

        }

    }

    public static String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }

        String[] inputArray = s.split(" ");
        String[] output = new String[inputArray.length];
        int count = 0;

        for (String input: inputArray) {
            char[] inputCharArray = input.toCharArray();
            reverseString(inputCharArray);
            output[count] = new String(inputCharArray);
            count++;
        }

        StringBuilder result = new StringBuilder("");

        for (String out: output) {
            result.append(out + " ");
        }

        if (output.length > 0) {
            return result.toString().substring(0,result.toString().length() - 1);
        } else {
            return "";
        }



    }

    public static void main(String[] args) {
        String input = "this is a quiz";

        System.out.println("This is the output : " + reverseWords(input));
    }

}
