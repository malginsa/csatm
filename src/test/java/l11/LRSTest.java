package l11;

import org.junit.Assert;
import org.junit.Test;

public class LRSTest {

    @Test
    public void lcp() {
        Assert.assertEquals(LRS.lcp("1", "1"), "1");
        Assert.assertEquals(LRS.lcp("21", "13"), "");
        Assert.assertEquals(LRS.lcp("123", "12"), "12");
    }

    @Test
    public void lrsBrute() {
        Assert.assertEquals(LRS.lrsBrute("123412"), "12");
        Assert.assertEquals(LRS.lrsBrute("111223111"), "111");
        Assert.assertEquals(LRS.lrsBrute("aacaagtttacaagc"), "acaag");
    }

    @Test
    public void lrsSuffixSorting() {
        Assert.assertEquals(LRS.lrsSuffixSorting("aacaagtttacaagc"), "acaag");
    }

}