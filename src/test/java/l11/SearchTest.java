package l11;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SearchTest {

    private static String[] strings;
    private static int index;
    private static String presented;

    @BeforeClass
    public static void init() {
        strings = Generator.generateRandomStrings(10, "abcdefgh", 1_000);
        Arrays.sort(strings);
        index = StdRandom.uniform(strings.length);
        presented = strings[index];
    }

    @Test
    public void sequential() throws Exception {
        int sequential = Search.sequential(presented, strings);
        Assert.assertEquals(index, sequential);
    }

    @Test
    public void binaryRecursevlyPresent() throws Exception {
        int binaryRecursevly = Search.binaryRecursevly("1",
                new String[]{"0", "1", "2", "3", "4", "5", "6"});
        Assert.assertEquals(1, binaryRecursevly);
    }

    @Test
    public void binaryRecursevlyAbsent() throws Exception {
        int binaryRecursevly = Search.binaryRecursevly("1",
                new String[]{"0", "2", "3", "4", "5", "6"});
        Assert.assertEquals(-1, binaryRecursevly);
    }

    @Test
    public void binaryRecursevly3() throws Exception {
        int binaryRecursevly = Search.binaryRecursevly(presented, strings);
        Assert.assertEquals(index, binaryRecursevly);
    }

    @Test
    public void binaryIterativePresent() throws Exception {
        int binaryRecursevly = Search.binaryIterative("1",
                new String[]{"0", "1", "2", "3", "4", "5", "6"});
        Assert.assertEquals(1, binaryRecursevly);
    }

    @Test
    public void binaryIterativeAbsent() throws Exception {
        int binaryRecursevly = Search.binaryIterative("1",
                new String[]{"0", "2", "3", "4", "5", "6"});
        Assert.assertEquals(-1, binaryRecursevly);
    }

    @Test
    public void binaryIterative() throws Exception {
        int binaryIterative = Search.binaryIterative(presented, strings);
        Assert.assertEquals(index, binaryIterative);
    }

}