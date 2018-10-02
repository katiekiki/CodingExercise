import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int input = 3;
        List<String> outputList = generateParantheses(input);

        for (String output: outputList) {
            System.out.println(output);
        }

    }

    public static List<String> generateParantheses(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) return result;

        parenthesesHelper(0,0,n, "", result);

        return result;

    }

    public static void parenthesesHelper(int left, int right, int n, String result, List<String> resultList) {
        if (result.length() == 2*n) {
            resultList.add(result);
            return;
        }

        if (left < n) {
            parenthesesHelper(left+1,right,n,result+"(",resultList);
        }

        if (right < left) {
            parenthesesHelper(left,right+1,n,result+")",resultList);
        }
     }
}
