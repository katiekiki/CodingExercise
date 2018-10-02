import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationIntegerWithDuplicates {

    public static void main(String[] args) {

        int[] input = {1,1,2};

        PermutationIntegerWithDuplicates permutationIntegerWithDuplicates = new PermutationIntegerWithDuplicates();

        List<List<Integer>> output = permutationIntegerWithDuplicates.permuteUnique(input);

        for (List<Integer> out : output) {
            System.out.println(out);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        permuteHelper(nums,0,nums.length-1,output);

        return output;


    }

    public void permuteHelper(int[] nums, int left, int right, List<List<Integer>> output) {
        if (left == right) {
            List<Integer> outputList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            output.add(outputList);
        }

        for (int i = left; i <= right; i++) {
            if(!containsDuplicates(left,i,nums)) {
                swap(nums,i,left);
                permuteHelper(nums,left+1,right,output);
                swap(nums,i,left);
            }
        }
    }

    public void swap(int[] nums,int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public boolean containsDuplicates(int start, int end, int[] input) {
        for (int i = start; i < end; i++) {
            if (input[start] == input[end]) {
                return true;
            }
        }
        return false;
    }
}
