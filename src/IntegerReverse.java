/*
reverse an integer -- from udemy: coding-interview-bootcamp-algorithms-and-data-structure
 */

public class IntegerReverse {

    public static void main(String[] args) {
        int[] input = {10, 500, 567, 20987, -15};

        for (int inputInt : input) {
            System.out.println("Input Integer value : [" + inputInt + "] and reversed integer value : [" + reverseInteger(inputInt) + "]");
        }

    }

    public static int reverseInteger(int input) {

        int remainder = 0;
        StringBuilder sb = new StringBuilder("");
        boolean isNegative = false;

        if (input < 0) {
            isNegative = true;
        }

        input = Math.abs(input);

        while(input >= 10) {
            remainder = input % 10;
            input = input/10;
            sb.append(remainder);
        }

        sb.append(input);

        int result = Integer.parseInt(sb.toString());

        if (isNegative) {
            return -result;
        } else {
            return result;
        }
    }
}
