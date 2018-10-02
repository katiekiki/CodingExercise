import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {

        int[] input = {1,2,3};

        Subset subset = new Subset();
        List<List<Integer>> output = subset.getAllSubset(input);

        for (List<Integer> outputList : output) {
            System.out.print(outputList);
        }

    }

    public List<List<Integer>> getAllSubset(int[] input) {
        List<Integer> chosen = new ArrayList();
        List<List<Integer>> output = new ArrayList<>();
        subsetHelper(input,chosen,0,output, "");

        return output;

    }

    public void subsetHelper(int[] input, List<Integer> chosen, int index, List<List<Integer>> output, String indent) {


        if (index == input.length) {
            //add chosen to output
            System.out.println(indent + "Adding " + new ArrayList<>(chosen) + " index " + index);
            output.add(new ArrayList<>(chosen));
        } else {

            chosen.add(input[index]);
            subsetHelper(input,chosen,index+1,output,indent + "    ");
            System.out.println(indent + "remove element " + chosen.get(chosen.size() - 1));
            chosen.remove(chosen.size()-1);
            subsetHelper(input,chosen,index+1,output,indent + "    ");

        }



    }
}
