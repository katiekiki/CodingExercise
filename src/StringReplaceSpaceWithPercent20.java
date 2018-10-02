public class StringReplaceSpaceWithPercent20 {

    public static void main(String[] args) {

        String input = "take it easy              ";

        StringReplaceSpaceWithPercent20 stringReplaceSpaceWithPercent20 = new StringReplaceSpaceWithPercent20();
        int trueLength = stringReplaceSpaceWithPercent20.getLastCharacterPosition(input.toCharArray());
        String updatedString = stringReplaceSpaceWithPercent20.replaceSpaces(input.toCharArray(),trueLength);

        System.out.println(updatedString);

    }


    public int countSpaces(char[] input, int trueLength) {

        int count = 0;

        for (int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                count++;
            }
        }

        return count;
    }

    public String replaceSpaces(char[] inputArray, int trueLength) {

        int numOfSpaces = countSpaces(inputArray,trueLength);

        int index = trueLength + 2 * numOfSpaces;

        if (trueLength < inputArray.length) {
            inputArray[trueLength] = '\0';
        }

        for (int i = trueLength -1; i >= 0 ; i--) {
            if (inputArray[i] == ' ') {
                inputArray[index -1] = '0';
                inputArray[index -2] = '2';
                inputArray[index -3] = '%';
                index -= 3;
            } else {
                inputArray[index-1] = inputArray[i];
                index--;
            }
        }

        return String.valueOf(inputArray);
    }

    public int getLastCharacterPosition(char[] input) {
        for (int i = input.length -1; i >= 0; i--) {
            if (input[i] != ' ') {
                return i+1;
            }
        }

        return -1;
    }

}
