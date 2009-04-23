package org.xerial.silk;

import java.net.URL;

import junit.framework.Test;

import org.eclipse.hyades.test.common.junit.DefaultTestArbiter;
import org.eclipse.hyades.test.common.junit.HyadesTestCase;
import org.eclipse.hyades.test.common.junit.HyadesTestSuite;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;

/**
 * Generated code for the test suite <b>SilkPerformanceTest</b> located at
 * <i>/xerial
 * -core/src/test/java/org/xerial/silk/SilkPerformanceTest.testsuite</i>.
 */
public class SilkPerformanceTest extends HyadesTestCase
{
    private static Logger _logger = Logger.getLogger(SilkPerformanceTest.class);

    /**
     * Constructor for SilkPerformanceTest.
     * 
     * @param name
     */
    public SilkPerformanceTest(String name)
    {
        super(name);
    }

    /**
     * Returns the JUnit test suite that implements the <b>SilkPerformanceTest</b> definition.
     */
    public static Test suite()
    {
        HyadesTestSuite silkPerformanceTest = new HyadesTestSuite("SilkPerformanceTest");
        silkPerformanceTest.setArbiter(DefaultTestArbiter.INSTANCE).setId("A1DE2F2467B7CB00CB86B76331623361");
        silkPerformanceTest.addTest(new SilkPerformanceTest("testPullParser").setId("A1DE2FBDD882AAA0CD61E36235633235")
                .setTestInvocationId("A1DE2FBE66931320CD61E36235633235"));
        return silkPerformanceTest;
    }

    /**
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {}

    /**
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {}

    /**
     * testPullParser
     */
    public void testPullParser() throws Exception
    {
        SilkPullParser reader = new SilkPullParser(new URL(
                "file:///f:/cygwin/home/leo/work/t2k/hdrr_hni_allaxt_revised.silk"));

        StopWatch timer = new StopWatch();
        int count = 0;
        SilkEvent e;
        while ((e = reader.next()) != null)
        {
            count++;
            if (count % 10000 == 0)
                _logger.info(String.format("line: %d\tcount: %d,\ttime=%s", reader.getNumReadLine(), count, timer
                        .getElapsedTime()));
        }
        _logger.info("parsing time: " + timer.getElapsedTime());
        _logger.info("event count : " + count);
    }
}
