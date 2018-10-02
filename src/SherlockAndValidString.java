import java.util.*;

public class SherlockAndValidString {

    public static void main(String[] args) {

        String input = "abcdefghhgfedecba";

        System.out.println("is input valid ? " + isValid(input));

    }


    static String isValid(String s) {
        int[] charArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }

        //sort the array
        Arrays.sort(charArray);

        Map<Integer,Integer> countMap = new HashMap<>();
        for (int j = 0; j < charArray.length; j++) {
            if (charArray[j] == 0) {
                continue;
            }
            if (countMap.containsKey(charArray[j])) {
                countMap.put(charArray[j],countMap.get(charArray[j]) +1);
            } else {
                countMap.put(charArray[j],1);
            }
        }
System.out.println("count map size " + countMap.entrySet().size());
        if (countMap.entrySet().size() > 2) {
            return "NO";
        } else {
             if (countMap.entrySet().size() == 1) {
                 return "YES";
             } else {
                 int previousCountKey = 0;
                 int previousCountValue = 0;
                 Iterator<Map.Entry<Integer,Integer>> mapIter = countMap.entrySet().iterator();
                 while (mapIter.hasNext()) {
                     Map.Entry<Integer,Integer> nextCount = mapIter.next();
                     if (previousCountKey == 0) {
                         previousCountKey = nextCount.getKey();
                         previousCountValue = nextCount.getValue();
                     }
                     else {
                         System.out.println(" previousCount Key " + previousCountKey + " previousValue " +
                                 previousCountValue + " and nextCount Key " + nextCount.getKey() + " and next count value " + nextCount.getValue());
                         if (nextCount.getValue() > previousCountValue) {
                             if (previousCountValue == 1 && previousCountKey == 1) {
                                 System.out.println("return yes 1");
                                 return "YES";
                             } else {
                                 System.out.println("return no 1");
                                 return "NO";
                             }
                         } else {
                             if (nextCount.getValue() == 1 && nextCount.getKey() == 1) {
                                 System.out.println("return yes 2");
                                 return "YES";
                             } else {
                                 System.out.println("return no 2");
                                 return "NO";
                             }

                         }

                     }
                 }

                 return "NO";

             }
        }
    }
}
