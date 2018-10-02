import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
767. Reorganize String - leetcode

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Input: S = "aab"
Output: "aba"

Input: S = "aaab"
Output: ""
 */
public class ReorganizeString {

    public static void main(String[] args) {

        String[] inputStrings= {"aab", "aaab"};

        for (String input : inputStrings) {
            System.out.println("this is the input : " + input + " and the output is " + reorganizeString(input));
        }

    }

    public static String reorganizeString(String s) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count = charCountMap.getOrDefault(s.charAt(i),0);
            if (count > (s.length() + 1)/2) { return ""; }
            charCountMap.put(s.charAt(i),count+1);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for (char c: charCountMap.keySet()) {
            pq.add(new int[]{c,charCountMap.get(c)});
        }


        StringBuilder sb = new StringBuilder("");
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            System.out.println("this is the next char " + (char) next[0] +" and count " + next[1]);
            if (sb.length() == 0 || sb.charAt(sb.length()-1) != next[0]) {
               //add next[0] to sb
                sb.append((char)next[0]);
                next[1]--;
                if(next[1] > 0) {
                    pq.add(next);
                }
            } else {
                int[] second = pq.poll();
                if (second != null) {
                    sb.append((char) second[0]);
                    second[1]--;
                    if (second[1] > 0) {
                        pq.add(second);
                    }

                    pq.add(next);
                }
            }

        }

        System.out.println("this is the output " + sb.toString());

        if (sb.toString().length() == s.length()) {
            return sb.toString();
        } else {
            return "Not a valid string";
        }

    }
}
