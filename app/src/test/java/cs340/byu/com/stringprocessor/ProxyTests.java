package cs340.byu.com.stringprocessor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ProxyTests {
    private Integer testNegative = -12;

    @Test
    public void toLowerCaseProxy(){
        String returnString = StringProcessorProxy.getInstance().toLowerCase("TESTING");
        assertEquals(returnString, "testing");
    }

    @Test
    public void trimProxy(){
        String returnString = StringProcessorProxy.getInstance().trim("  CS 340   ");
        assertEquals(returnString, "CS 340");
    }

    @Test
    public void parseIntProxy(){
        Integer returnInt = StringProcessorProxy.getInstance().parseInteger("-12");
        assertEquals(returnInt, testNegative);
    }

    @Test(expected = NumberFormatException.class)
    public void parseIntProxyException(){
        Integer returnInt = StringProcessorProxy.getInstance().parseInteger("twelve");
    }
}