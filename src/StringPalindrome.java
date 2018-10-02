public class StringPalindrome {

    public static void main(String[] args) {
        String[] input = {"","abba", "abcde", "aabbccbbaa","aabaa"};

        for(String inputStr: input) {
            System.out.println("Is input : [" + inputStr + "] a Palindrome? " + isPalindrome(inputStr));
        }

    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        char[] inputArray = input.toCharArray();

        int frontPtr = 0;
        int backPtr = inputArray.length -1;

        while (frontPtr < backPtr) {
            if (inputArray[frontPtr] != inputArray[backPtr]) {
                return false;
            } else {
                frontPtr++;
                backPtr--;
            }
        }

        return true;


    }
}
