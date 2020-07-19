package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Finder {

    private String[] dataSample;
    private boolean isEmpty;

    public Finder(String[] input) {

        boolean isEmpty = true;
        for (String ob : input) {
            if (ob != null) {
                isEmpty = false;
                break;
            }
        }

        if (!isEmpty) {
            this.dataSample = input;
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
        }
    }

    public String[] getDataSample() {
        return dataSample;
    }

    /**
     * ASSUMPTION: The string needs to contain exactly the same amount of same characters.
     * I.e. 'sad' and 'ssad' will not be a match
     *
     * @param input String we want to be used as search sample
     * @return Strings from array that contain the same characters
     */
    public String[] find(String input) {

        if (isEmpty || dataSample.length == 0) {
            System.out.println("No matches found, as the data sample array is empty.");
            return null;
        }

        if (input == null || input.isEmpty()) {
            System.out.println("No matches found, as the input is empty.");
            return null;
        }

        int dataSampleCounter = 0;
        List<String> resultList = new ArrayList<>();

        do {
            int duplicate = 0;
            int sizeOfInputString = input.length();
            String currentString = this.dataSample[dataSampleCounter];
            char[] currentStringArray = currentString.toCharArray();
            char[] splitInput = input.toCharArray();

            // Size of the boolean array is based on the assumption we are
            // using Unicode characters
            boolean[] usedCharacters = new boolean[65536];

            for (char currentDataSampleChar : currentStringArray) {
                if (containsCharacter(splitInput, currentDataSampleChar)) {
                    sizeOfInputString--;
                    if (!usedCharacters[currentDataSampleChar]) {
                        usedCharacters[currentDataSampleChar] = true;
                    } else {
                        duplicate++;
                    }
                }
            }

            dataSampleCounter++;
            if (duplicate == 0 && sizeOfInputString == 0) {
                resultList.add(currentString);
            }

        } while (dataSampleCounter < dataSample.length);

        String[] resultArray = new String[resultList.size()];
        return resultList.toArray(resultArray);
    }


    /**
     * @param inputs                Input separated into chars
     * @param stringSampleCharacter current char of the sample string
     * @return boolean describing if the current char of sample string is in the input char array
     */
    public boolean containsCharacter(char[] inputs, char stringSampleCharacter) {
        int found = IntStream.range(0, inputs.length)
                .filter(x -> inputs[x] == stringSampleCharacter)
                .findFirst()
                .orElse(-1);
        return found != -1;
    }
}
