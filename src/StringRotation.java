/*
  Cracking the coding interview 1.9
 */



public class StringRotation {

    public static void main(String[] args) {

        String input1 = "waterbottle";
        String input2 = "terbottlewa";

//        System.out.println("is input2 substring of input 1 " + isSubString(input1.toCharArray(), input2.toCharArray()));

        System.out.println("is input2 : " + input2 + " rotation of input1 " + input1 + " ? " + isRotation(input1, input2));

    }

    public static boolean isSubString(char[] input1, char[] input2) {

        for (int i = 0; i < input1.length - input2.length; i++) {

            for (int j = 0; j < input2.length; j++) {
                if (input1[i+j] == input2[j]) {
                    if (j == input2.length - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }

        }

        return false;

    }

    public static boolean isRotation(String input1, String input2) {

        if (input1 == null || input1.length() == 0 || input2 == null || input2.length() == 0) {
            return false;
        }

        if (input1.length() != input2.length()) {
            return false;
        }

        String inputToCheck = input1 + input1;

        return isSubString(inputToCheck.toCharArray(),input2.toCharArray());

    }
}
