import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMakingAnagrams {

    static int makeAnagram(String a, String b) {

        Map<Character, Integer> charMapA = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (!charMapA.containsKey(a.charAt(i))) {
                charMapA.put(a.charAt(i), 1);
            } else {
                charMapA.put(a.charAt(i), charMapA.get(a.charAt(i)) + 1);
            }
        }
        List<Character> output = new ArrayList<>();
        //go through string b to find all the characters in b but not in a
        for (int j = 0; j < b.length(); j++) {
            if (charMapA.containsKey(b.charAt(j)) && charMapA.get(b.charAt(j)) > 0) {
                charMapA.put(b.charAt(j),charMapA.get(b.charAt(j)) - 1);
            } else {
                output.add(b.charAt(j));
            }
        }

        //go through the map again to find any keys with count > 0
        for (Map.Entry<Character, Integer> entry : charMapA.entrySet()) {
            if (entry.getValue() > 0) {
                int count = entry.getValue();
                while (count > 0) {
                    output.add(entry.getKey());
                    count--;
                }
            }
        }
        return output.size();

    }

}
