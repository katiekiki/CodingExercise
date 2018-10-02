public class StringAnagrams {

    public static void main(String[] args) {

        String[] input1 = {"abcd", "abbcd", "sfwtw", "aab"};
        String[] input2 = {"dcba", "abbc", "wtwfs", "bbb"};

        for (int i = 0; i < input1.length; i++) {
            System.out.println("input1 : [" + input1[i] + "] input2: [" + input2[i] + "] , are they anagrams? " + isAnagram(input1[i], input2[i]));
        }

    }

    public static boolean isAnagram(String input1, String input2) {

        if (input1.length() != input2.length()) {
            return false;
        }

        int[] charArray = new int[128];

        char[] input1Array = input1.toCharArray(), input2Array = input2.toCharArray();

        for (int i = 0; i < input1Array.length; i++) {
            charArray[input1Array[i]]++;
        }

        for(int j = 0; j < input2Array.length; j++) {
            charArray[input2Array[j]]--;
            if (charArray[input2Array[j]] < 0) {
                return false;
            }
        }

        return true;
    }
}
