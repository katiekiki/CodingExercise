public class StringUniqueCharacters {

    public static void main(String[] args) {

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }

    }

    public static boolean isUniqueChars(String input) {
        if (input.length() > 128) {
            return false;
        }

        boolean[] characterArray = new boolean[128];
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < inputArray.length; i++) {
            if (characterArray[inputArray[i]])
                return false;
            characterArray[inputArray[i]] = true;
        }

        return true;
    }
}
