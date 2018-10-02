import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationInteger {

    public static void main(String[] args) {

        int[] input = {2,3,4};

        PermutationInteger permutationInteger = new PermutationInteger();
        List<String> output = permutationInteger.permute(input);

        for(String out: output) {
            System.out.println(out);
        }

    }

    public List<String> permute(int[] input) {

        List<String> output = new ArrayList<>();

        permuteHelper(input,0,input.length-1,output);

        return output;

    }

    public void permuteHelper(int[] input, int left, int right, List<String> output) {

        if (left == right) {
            output.add(Arrays.toString(input));
        }

        for (int i = left; i <= right; i++) {
            swap(input,left,i);
            permuteHelper(input,left+1,right,output);
            swap(input,left,i); //backtrack
        }

    }

    public void swap(int[] input, int from, int to) {
        int temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }

}
