package l11;

import org.junit.Assert;
import org.junit.Test;

public class LrsBruteForceTest {

    @Test
    public void lcp() {
        Assert.assertEquals(LrsBruteForce.lcp("1", "1"), "1");
        Assert.assertEquals(LrsBruteForce.lcp("21", "13"), "");
        Assert.assertEquals(LrsBruteForce.lcp("123", "12"), "12");
    }

    @Test
    public void lrsBrute() {
        Assert.assertEquals(LrsBruteForce.lrs("123412"), "12");
        Assert.assertEquals(LrsBruteForce.lrs("111223111"), "111");
        Assert.assertEquals(LrsBruteForce.lrs("aacaagtttacaagc"), "acaag");
    }

    @Test
    public void lrsSuffixSorting() {
        Assert.assertEquals(LrsBruteForce.lrs("aacaagtttacaagc"), "acaag");
    }

}