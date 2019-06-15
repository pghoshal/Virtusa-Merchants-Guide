package com.virtusa.merchants.galaxy.writer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class UnknownWriterTest.
 */
public class UnknownWriterTest {
    
    /** The Constant TEST_INPUT. */
    private static final String TEST_INPUT = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
    
    /** The Constant UNKNOWN_MESSAGE. */
    private static final String UNKNOWN_MESSAGE = "I have no idea what you are talking about";
    
    /** The writer. */
    private UnknownWriter writer;
    
    /** The mock print stream. */
    private PrintStream mockPrintStream;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        writer = new UnknownWriter();
        mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        System.setOut(null);
    }

    /**
     * Should output unknown message.
     */
    @Test
    public void shouldOutputUnknownMessage() {
        writer.process(TEST_INPUT);
        verify(mockPrintStream).println(UNKNOWN_MESSAGE);
    }
}
