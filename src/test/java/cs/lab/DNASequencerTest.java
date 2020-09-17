package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

@Test
public class DNASequencerTest {

    public void testCase0() throws DNASequenceException {
        generic(0);
    }

    @Test(expectedExceptions = DNASequenceException.class, expectedExceptionsMessageRegExp = "Subsequence with too many characters")
    public void testCase1Error() throws Exception{
        List<String> lines = new ArrayList<String>();
        for (int gen = 0; gen < 100; gen++){
            String line = generateRandomString(205);
            lines.add(line);
        }
        DNASequencer sequencer = new DNASequencer();
        sequencer.calculate(lines);
    }

    public void testCase1Pass() throws Exception{
        List<String> lines = new ArrayList<String>();
        for (int gen = 0; gen < 100; gen++){
            String line = generateRandomString(120);
            lines.add(line);
        }
        DNASequencer sequencer = new DNASequencer();
        sequencer.calculate(lines);
    }

    @Test(expectedExceptions = DNASequenceException.class, expectedExceptionsMessageRegExp = "Too many subsequences")
    public void testCase2Error() throws DNASequenceException{
        List<String> lines = new ArrayList<String>();
        for (int gen = 0; gen < 160005; gen++){
            String line = generateRandomString(5);
            lines.add(line);
        }
        DNASequencer sequencer = new DNASequencer();
        sequencer.calculate(lines);
    }

    public void testCase2Pass() throws DNASequenceException{
        List<String> lines = new ArrayList<String>();
        for (int gen = 0; gen < 150001; gen++){
            String line = generateRandomString(5);
            lines.add(line);
        }
        DNASequencer sequencer = new DNASequencer();
        sequencer.calculate(lines);
    }

    @Test(invocationCount = 50, threadPoolSize = 50)
    public void testCase3() throws DNASequenceException{
        testCase0();
    }

    @Test(timeOut = 300)
    public void testcase4() throws DNASequenceException{
        testCase0();
    }

    private void generic(int i) throws DNASequenceException {
        List<String> input = readInput(i);
        String output = readOutput(i);
        DNASequencer sequencer = new DNASequencer();
        String response = sequencer.calculate(input);
        Assert.assertEquals(response, output);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }

    private static final String CHAR_UPPER = "ACTG";

    private static final String DATA_FOR_RANDOM_STRING =  CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();

    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();

    }
}
