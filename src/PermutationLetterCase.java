import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationLetterCase {

    public static void main(String[] args) {
        String input = "a1b2";
        PermutationLetterCase permutationLetterCase = new PermutationLetterCase();

        List<String> output = permutationLetterCase.permute(input);

        for (String out: output) {
            System.out.println(out);
        }

    }

    public List<String> permute(String input) {

        List<String> output = new ArrayList<>();
        permuteHelper(input.toCharArray(),0,output);

        return output;
    }

    public void permuteHelper(char[] input, int index, List<String> output) {

            if (index == input.length) {
                output.add(String.valueOf(input));
                return;
            }

            if (Character.isAlphabetic(input[index])) {
                input[index] = Character.toLowerCase(input[index]);
                permuteHelper(input, index+1, output);
                input[index] = Character.toUpperCase(input[index]);
                permuteHelper(input, index+1, output);

            } else {
                //it is not an alphabet, no change and increment index
                permuteHelper(input,index+1,output);
            }
    }
}
