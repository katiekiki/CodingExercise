import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static void main(String[] args) {
        int[] input = {1,2,3};

        SubsetWithDuplicates subsetWithDuplicates = new SubsetWithDuplicates();
        Arrays.sort(input);

        List<List<Integer>> output = subsetWithDuplicates.subsetsWithDup(input);

        for (List<Integer> out: output) {
            System.out.println(out);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        subsetHelper(nums,new ArrayList<>(),0,output,"");

        return output;

    }


    public void subsetHelper(int[] nums, List<Integer> chosen, int index, List<List<Integer>> output, String indent) {

        System.out.println(indent + "Adding " + chosen + " index " + index);
        output.add(new ArrayList<>(chosen));

        for (int i = index; i < nums.length; i++) {
            //if the previous element and current element has the same value
            if (i != index && nums[i-1] == nums[i]) {
                continue;
            }

            chosen.add(nums[i]);
            subsetHelper(nums,chosen,i + 1,output, indent + "    ");
            System.out.println(indent + "remove element " + chosen.get(chosen.size() -1) + " index " + index);
            chosen.remove(chosen.size() -1);
        }


    }
}
