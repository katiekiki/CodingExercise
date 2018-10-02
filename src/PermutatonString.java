import java.util.ArrayList;
import java.util.List;

public class PermutatonString {

    public static void main(String[] args) {

        PermutatonString permutatonString = new PermutatonString();

        String input = "abcd";

        List<String> output = permutatonString.permute(input);

        for (String out: output) {
            System.out.print(out + " ");
        }

    }

    public List<String> permute(String input) {
        List<String> output = new ArrayList<>();
        permuteHelper(input,0,input.length() -1, output);
        return output;
    }


    public String swap(String input, int from, int to) {
        char[] charArray = input.toCharArray();
        char temp = charArray[from];
        charArray[from] = charArray[to];
        charArray[to] = temp;

        return String.valueOf(charArray);
    }

    public void permuteHelper(String input, int left, int right, List<String> output) {

        if (left == right) {
            output.add(input);
        }

        for (int i = left; i <= right; i++) {
            input = swap(input,left,i);
            permuteHelper(input, left+1,right, output);
            input = swap(input,left,i); //backtrack
        }

    }

}
