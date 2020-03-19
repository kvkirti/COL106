import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.io.IOException;
import java.io.PrintStream;
import col106.assignment4.HashMap.*;
import col106.assignment4.Map.*;
import col106.assignment4.WeakAVLMap.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RunTest {

    private boolean hashMap_test(String infile, String outfile) throws IOException {
		String outfile1 = "testcases/output/" + outfile;
		infile = "testcases/input/" + infile;
		outfile = "testcases/ans/" + outfile;

        HashMapDriverCode driver = new HashMapDriverCode();
        String[] input = {infile, outfile1};
        String file1 = outfile;
        String file2 = outfile1;

        PrintStream stdout = System.out;
        driver.main(input);
        System.setOut(stdout);

        boolean isEqual = true;

        File f1 = new File(file1);
        BufferedReader b1 = new BufferedReader(new FileReader(f1));
        String readLine1 = "";

        File f2 = new File(file2);
        BufferedReader b2 = new BufferedReader(new FileReader(f2));
        String readLine2 = "";

        while ((readLine1 = b1.readLine()) != null && (readLine2 = b2.readLine()) != null) {
            // System.out.println(readLine1);
            // System.out.println(readLine2);

            if(!readLine1.equals(readLine2)){
                isEqual = false;
                break;
            }
        }

        while ((readLine1 = b1.readLine()) != null) {
            if(!readLine1.equals("\n") && !readLine1.equals(" ")){
                isEqual = false;
                break;
            }
        }

        while ((readLine2 = b2.readLine()) != null) {
            if(!readLine2.equals("\n") && !readLine2.equals(" ")){
                isEqual = false;
                break;
            }
        }

        if(!isEqual){
            System.out.println("Mandatory test case failed");
        }

        return isEqual;
    }

    private boolean wordCounter_test(String infile, String outfile) throws IOException {
		String outfile1 = "testcases/output/" + outfile;
		infile = "testcases/input/" + infile;
		outfile = "testcases/ans/" + outfile;

        WordCounterDriverCode driver = new WordCounterDriverCode();
        String[] input = {infile, outfile1};
        String file1 = outfile;
        String file2 = outfile1;

        PrintStream stdout = System.out;
        driver.main(input);
        System.setOut(stdout);

        boolean isEqual = true;

        File f1 = new File(file1);
        BufferedReader b1 = new BufferedReader(new FileReader(f1));
        String readLine1 = "";

        File f2 = new File(file2);
        BufferedReader b2 = new BufferedReader(new FileReader(f2));
        String readLine2 = "";

        while ((readLine1 = b1.readLine()) != null && (readLine2 = b2.readLine()) != null) {
            // System.out.println(readLine1);
            // System.out.println(readLine2);
            if(!readLine1.equals(readLine2)){
                isEqual = false;
                break;
            }
        }

        while ((readLine1 = b1.readLine()) != null) {
            if(!readLine1.equals("\n") && !readLine1.equals(" ")){
                isEqual = false;
                break;
            }
        }

        while ((readLine2 = b2.readLine()) != null) {
            if(!readLine2.equals("\n") && !readLine2.equals(" ")){
                isEqual = false;
                break;
            }
        }

        if(!isEqual){
            System.out.println("Mandatory test case failed");
        }

        return isEqual;
    }

    private boolean weakAVLMap_test(String infile, String outfile) throws IOException {
		String outfile1 = "testcases/output/" + outfile;
		infile = "testcases/input/" + infile;
		outfile = "testcases/ans/" + outfile;

        WAVLDriverCode driver = new WAVLDriverCode();
        String[] input = {infile, outfile1};
        String file1 = outfile;
        String file2 = outfile1;

        PrintStream stdout = System.out;
        driver.main(input);
        System.setOut(stdout);

        boolean isEqual = true;

        File f1 = new File(file1);
        BufferedReader b1 = new BufferedReader(new FileReader(f1));
        String readLine1 = "";

        File f2 = new File(file2);
        BufferedReader b2 = new BufferedReader(new FileReader(f2));
        String readLine2 = "";

        while ((readLine1 = b1.readLine()) != null && (readLine2 = b2.readLine()) != null) {
            // System.out.println(readLine1);
            // System.out.println(readLine2);
            if(!readLine1.equals(readLine2)){
                // System.out.println(">" + readLine1);
                // System.out.println("<" + readLine2);
                isEqual = false;
                break;
            }
        }

        while ((readLine1 = b1.readLine()) != null) {
            if(!readLine1.equals("\n") && !readLine1.equals(" ")){
                isEqual = false;
                break;
            }
        }

        while ((readLine2 = b2.readLine()) != null) {
            if(!readLine2.equals("\n") && !readLine2.equals(" ")){
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    /******************************/
    /* Mandatory testcases begin here */

    //mandatory test 1 ~ WAVL ~
    @Test
    public void test1_10P() throws IOException{
        System.out.println("WAVL 1");
        // System.out.println(weakAVLMap_test("WAVL_INP1", "WAVL_OUT1"));
        assertTrue(weakAVLMap_test("WAVL_INP1", "WAVL_OUT1"));
    }
    // mandatory test 2 ~ WAVL ~
    @Test
    public void test2_5P() throws IOException{
        System.out.println("WAVL 2");
        // System.out.println(weakAVLMap_test("WAVL_INP2", "WAVL_OUT2"));
        assertTrue(weakAVLMap_test("WAVL_INP2", "WAVL_OUT2"));
    }
    // mandatory test 3 ~ WAVL ~
    @Test
    public void test3_5P() throws IOException{
        System.out.println("WAVL 3");
        // System.out.println(weakAVLMap_test("WAVL_INP3", "WAVL_OUT3"));
        assertTrue(weakAVLMap_test("WAVL_INP3", "WAVL_OUT3"));
    }
    // mandatory test 4 ~ WAVL ~
    @Test
    public void test4_20P() throws IOException{
        System.out.println("WAVL 4");
        // System.out.println(weakAVLMap_test("WAVL_INP4", "WAVL_OUT4"));
        assertTrue(weakAVLMap_test("WAVL_INP4", "WAVL_OUT4"));
    }
    // mandatory test 5 ~ WAVL ~
    @Test
    public void test5_20P() throws IOException{
        System.out.println("WAVL 5");
        // System.out.println(weakAVLMap_test("WAVL_INP5", "WAVL_OUT5"));
        assertTrue(weakAVLMap_test("WAVL_INP5", "WAVL_OUT5"));
    }
    //

    // mandatory test 6 ~ HashMap ~
    @Test
    public void test6_2P() throws IOException{
        System.out.println("HashMap 1");
        // System.out.println(hashMap_test("HashMap_INP1", "HashMap_OUT1"));
        assertTrue(hashMap_test("HashMap_INP1", "HashMap_OUT1"));
    }
    // mandatory test 7 ~ HashMap ~
    @Test
    public void test7_2P() throws IOException{
        System.out.println("HashMap 2");
        // System.out.println(hashMap_test("HashMap_INP2", "HashMap_OUT2"));
        assertTrue(hashMap_test("HashMap_INP2", "HashMap_OUT2"));
    }
    // mandatory test 8 ~ HashMap ~
    @Test
    public void test8_2P() throws IOException{
        System.out.println("HashMap 3");
        // System.out.println(hashMap_test("HashMap_INP3", "HashMap_OUT3"));
        assertTrue(hashMap_test("HashMap_INP3", "HashMap_OUT3"));
    }
    // mandatory test 9 ~ HashMap ~
    @Test
    public void test9_4P() throws IOException{
        System.out.println("HashMap 4");
        // System.out.println(hashMap_test("HashMap_INP4", "HashMap_OUT4"));
        assertTrue(hashMap_test("HashMap_INP4", "HashMap_OUT4"));
    }
    // mandatory test 10 ~ HashMap ~
    @Test
    public void test10_6P() throws IOException{
        System.out.println("HashMap 5");
        // System.out.println(hashMap_test("HashMap_INP5", "HashMap_OUT5"));
        assertTrue(hashMap_test("HashMap_INP5", "HashMap_OUT5"));
    }
    // mandatory test 11 ~ HashMap ~
    @Test
    public void test11_6P() throws IOException{
        System.out.println("HashMap 6");
        // System.out.println(hashMap_test("HashMap_INP6", "HashMap_OUT6"));
        assertTrue(hashMap_test("HashMap_INP6", "HashMap_OUT6"));
    }

    // mandatory test 12 ~ WordCounter ~
    @Test
    public void test12_3P() throws IOException{
        System.out.println("WordCounter 1");
        // System.out.println(wordCounter_test("WordCounter_INP1", "WordCounter_OUT1"));
        assertTrue(wordCounter_test("WordCounter_INP1", "WordCounter_OUT1"));
    }
    // mandatory test 13 ~ WordCounter ~
    @Test
    public void test13_5P() throws IOException{
        System.out.println("WordCounter 2");
        // System.out.println(wordCounter_test("WordCounter_INP2", "WordCounter_OUT2"));
        assertTrue(wordCounter_test("WordCounter_INP2", "WordCounter_OUT2"));
    }
}
