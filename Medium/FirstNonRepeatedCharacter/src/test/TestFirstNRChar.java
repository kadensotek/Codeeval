import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rrj09832.fnrc.FirstNRChar;

import java.lang.Exception;

public class TestFirstNRChar
{
    private FirstNRChar first;

    @Before
    public void setUp() throws Exception
    {
        first = new FirstNRChar();
    }

    @Test
    public void emptyStringShouldReturnEmptyString()
    {
        assertEquals("Empty string.",first.processLine(""));
    }

    @Test
    public void oneCharStringShouldReturnChar()
    {
        assertEquals("a",first.processLine("a"));
    }

    @Test
    public void allRepeatingCharShouldReturnNoRepeats()
    {
        String noRepeats = "No non-repeating characters found.";
        assertEquals(noRepeats,first.processLine("abccba"));
        assertEquals(noRepeats,first.processLine("aabbcc"));
    }

    @Test
    public void firstCharShouldBeReturned()
    {
        assertEquals("a",first.processLine("abccbd"));
        assertEquals("a",first.processLine("abcdef"));
    }

    @Test
    public void lastCharShouldBeReturned()
    {
        assertEquals("d",first.processLine("aabbccd"));
        assertEquals("f",first.processLine("abccbaf"));
    }

    @Test
    public void secondCharShouldBeReturned()
    {
        assertEquals("b",first.processLine("abcddca"));
    }


}