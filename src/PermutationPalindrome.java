import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PermutationPalindrome {

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};

        for (String input: strings) {
            System.out.println("input: " + input + " is Palindrome Permutation? " + isPalindromePermutation2(input));
        }
    }

    public static int getCharNumber(Character input) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int inputCharValue = Character.getNumericValue(input);
        System.out.println("this is input " + input + " and inputCharValue " + inputCharValue);

        if (inputCharValue >= a || inputCharValue <= z) {
            return inputCharValue;
        } else {
            return -1;
        }
    }

    public static boolean isPalindromePermutation(String input) {

        Map<Character,Integer> characterMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (getCharNumber(input.charAt(i)) != -1) {
                if (characterMap.containsKey(Character.toLowerCase(input.charAt(i)))) {
                    characterMap.put(Character.toLowerCase(input.charAt(i)), characterMap.get(Character.toLowerCase(input.charAt(i))) + 1);
                } else {
                    characterMap.put(Character.toLowerCase(input.charAt(i)), 1);
                }
            }
        }

        Iterator characterIter = characterMap.entrySet().iterator();
        boolean isOddFound = false;

        while (characterIter.hasNext()) {
            Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>) characterIter.next();
            if (entry.getValue() % 2 == 1) {
                if (isOddFound) {
                    return false;
                } else {
                    isOddFound = true;
                }
            }
        }

        return true;
    }

    public static boolean isPalindromePermutation2(String input) {
        int[] characterCountArray = new int[128];

        for (int i = 0; i < input.length(); i++) {
            characterCountArray[Character.toLowerCase(input.charAt(i))]++;
        }

        boolean isOddFound = false;

        for (int j = 0; j < characterCountArray.length; j++) {
            if (characterCountArray[j] % 2 == 1) {
                if (isOddFound) {
                    return false;
                } else {
                    isOddFound = true;
                }
            }

        }

        return true;
    }
}
