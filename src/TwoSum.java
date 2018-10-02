import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

        int[] input = {2,7,11,15};
        int target = 9;

        System.out.println("The two integers that adds up to " + target + " is " + Arrays.toString(twoSum(input,target)));

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]),i};
            } else {
                numMap.put(nums[i],i);
            }
        }

        return null;
    }
}
