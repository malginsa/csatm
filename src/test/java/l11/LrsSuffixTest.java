package l11;

import org.junit.Assert;
import org.junit.Test;

public class LrsSuffixTest {

    @Test
    public void lcp1() {
        LrsSuffix lrsSuffix = new LrsSuffix("1");
        LrsSuffix.Suffix suffix1 = lrsSuffix.createSuffix(0);
        LrsSuffix.Suffix suffix2 = lrsSuffix.createSuffix(0);
        Assert.assertEquals(LrsSuffix.lcp(suffix1, suffix2), "1");
    }

    @Test
    public void lcp2() {
        LrsSuffix lrsSuffix = new LrsSuffix("123");
        LrsSuffix.Suffix suffix1 = lrsSuffix.createSuffix(0);
        LrsSuffix.Suffix suffix2 = lrsSuffix.createSuffix(1);
        Assert.assertEquals(LrsSuffix.lcp(suffix1, suffix2), "");
    }

    @Test
    public void lcp3() {
        LrsSuffix lrsSuffix = new LrsSuffix("123124");
        LrsSuffix.Suffix suffix1 = lrsSuffix.createSuffix(0);
        LrsSuffix.Suffix suffix2 = lrsSuffix.createSuffix(3);
        Assert.assertEquals(LrsSuffix.lcp(suffix1, suffix2), "12");
    }

    @Test
    public void doLrs1() {
        LrsSuffix lrs = new LrsSuffix("123412");
        Assert.assertEquals(lrs.doLrs(), "12");
    }

    @Test
    public void doLrs2() {
        LrsSuffix lrs = new LrsSuffix("aacaagtttacaagc");
        Assert.assertEquals(lrs.doLrs(), "acaag");
    }

    @Test
    public void doLrs3() {
        LrsSuffix lrs = new LrsSuffix("gagattaacgtcaagagacgcgtgctagacgag" +
                "gtgtttcaatatgtggctctcctccgttatgctctccattgtacgggaagggctt" +
                "ttctcggcatcg");
        Assert.assertEquals(lrs.doLrs(), "gctctcc");
    }
}