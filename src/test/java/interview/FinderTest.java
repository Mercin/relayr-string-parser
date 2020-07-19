package interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FinderTest {

    @Test
    public void containsCharacter() {

        char[] inputChars = new char[2];
        inputChars[0] = 'a';
        inputChars[1] = 'x';

        String[] exampleStrings = new String[1];
        Finder finder = new Finder(exampleStrings);

        boolean resultFound = finder.containsCharacter(inputChars, 'a');
        boolean resultNotFound = finder.containsCharacter(inputChars, 'b');

        Assertions.assertTrue(resultFound);
        Assertions.assertFalse(resultNotFound);
    }

    @Test
    public void findSimpleCase() {
        String[] dataSamples = new String[5];
        dataSamples[0] = "asd";
        dataSamples[1] = "asdd";
        dataSamples[2] = "fre";
        dataSamples[3] = "glk";
        dataSamples[4] = "lkm";

        String[] expectedResult = new String[1];
        expectedResult[0] = "asd";
        String input = "sad";

        Finder finder = new Finder(dataSamples);
        Assertions.assertArrayEquals(expectedResult, finder.find(input));
    }

    @Test
    public void findMoreComplexCase() {
        String[] dataSamples = new String[8];
        dataSamples[0] = "asd";
        dataSamples[1] = "asdd";
        dataSamples[2] = "fre";
        dataSamples[3] = "glk";
        dataSamples[4] = "lkm";
        dataSamples[5] = "sad";
        dataSamples[6] = "lkm";
        dataSamples[7] = "lkm";

        String[] expectedResult = new String[2];
        expectedResult[0] = "asd";
        expectedResult[1] = "sad";
        String input = "sad";

        Finder finder = new Finder(dataSamples);
        Assertions.assertArrayEquals(expectedResult, finder.find(input));
    }

    @Test
    @RepeatedTest(value = 50000)
    public void findMoreComplexCaseRunManyTimes() {

        // On my machine it finishes in cca 6 sec

        String[] dataSamples = new String[8];
        dataSamples[0] = "asd";
        dataSamples[1] = "asdd";
        dataSamples[2] = "fre";
        dataSamples[3] = "glk";
        dataSamples[4] = "lkm";
        dataSamples[5] = "sad";
        dataSamples[6] = "lkm";
        dataSamples[7] = "lkm";

        String[] expectedResult = new String[2];
        expectedResult[0] = "asd";
        expectedResult[1] = "sad";
        String input = "sad";

        Finder finder = new Finder(dataSamples);
        Assertions.assertArrayEquals(expectedResult, finder.find(input));
    }

    @Test
    public void noDataSampleArray() {
        String[] dataSamples = new String[1];
        Finder finder = new Finder(dataSamples);
        String input = "sad";

        Assertions.assertNull(finder.find(input));

    }

    @Test
    public void noInput() {
        String[] dataSamples = new String[1];
        dataSamples[0] = "bla";
        Finder finder = new Finder(dataSamples);
        String input = null;

        Assertions.assertNull(finder.find(input));
    }


}