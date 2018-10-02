import java.util.Arrays;

public class IsPermutation {

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        System.out.println("********** Testing IsPermutation");
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }

        System.out.println("********** Testing IsPermutation_two");
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation_two(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }

    }

    public static boolean isPermutation(String stringA, String stringB) {

        char[] arrayA = stringA.toCharArray();
        char[] arrayB = stringB.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        return Arrays.equals(arrayA,arrayB);

    }

    public static boolean isPermutation_two(String stringA, String stringB) {

        if (stringA.length() != stringB.length()) {
            return false;
        }

        int[] charArray = new int[128];

        for (int i = 0; i < stringA.length(); i++) {
            charArray[stringA.charAt(i)]++;
        }

        for (int i = 0; i < stringB.length(); i++) {
            charArray[stringB.charAt(i)]--;
            if (charArray[stringB.charAt(i)] < 0) {
                return false;
            }
        }

        return true;

    }
}
