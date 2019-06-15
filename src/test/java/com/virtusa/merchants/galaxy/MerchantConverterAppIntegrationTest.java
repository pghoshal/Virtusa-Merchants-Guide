package com.virtusa.merchants.galaxy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class MerchantConverterAppIntegrationTest.
 */
public class MerchantConverterAppIntegrationTest {
    
    /** The Constant FULL_INPUT_PATH. */
    private static final String FULL_INPUT_PATH =
            "src/test/resources/test-input.txt";
    
    /** The Constant OUTPUT_LINE_1. */
    private static final String OUTPUT_LINE_1 = "pish tegj glob glob is 42";
    
    /** The Constant OUTPUT_LINE_2. */
    private static final String OUTPUT_LINE_2 = "glob prok Silver is 68 Credits";
    
    /** The Constant OUTPUT_LINE_3. */
    private static final String OUTPUT_LINE_3 = "glob prok Gold is 57800 Credits";
    
    /** The Constant OUTPUT_LINE_4. */
    private static final String OUTPUT_LINE_4 = "glob prok Iron is 782 Credits";
    
    /** The Constant OUTPUT_LINE_5. */
    private static final String OUTPUT_LINE_5 = "I have no idea what you are talking about";
    
    /** The mock print stream. */
    private PrintStream mockPrintStream;

    /**
     * Sets the up.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws URISyntaxException the URI syntax exception
     */
    @Before
    public void setUp() throws IOException, URISyntaxException {
        mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        MerchantConverterApp app = new MerchantConverterApp();
        MerchantConverterApp.main(new String[]{FULL_INPUT_PATH});
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        System.setOut(null);
    }

    /**
     * Should output line 1.
     */
    @Test
    public void shouldOutputLine1() {
        verify(mockPrintStream).println(OUTPUT_LINE_1);
    }

    /**
     * Should output line 2.
     */
    @Test
    public void shouldOutputLine2() {
        verify(mockPrintStream).println(OUTPUT_LINE_2);
    }

    /**
     * Should output line 3.
     */
    @Test
    public void shouldOutputLine3() {
        verify(mockPrintStream).println(OUTPUT_LINE_3);
    }

    /**
     * Should output line 4.
     */
    @Test
    public void shouldOutputLine4() {
        verify(mockPrintStream).println(OUTPUT_LINE_4);
    }

    /**
     * Should output line 5.
     */
    @Test
    public void shouldOutputLine5() {
        verify(mockPrintStream).println(OUTPUT_LINE_5);
    }
}
