package com.virtusa.merchants.galaxy.writer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * The Class SymbolWriterTest.
 */
public class SymbolWriterTest {
    
    /** The writer. */
    private SymbolWriter writer;
    
    /** The mock print stream. */
    private PrintStream mockPrintStream;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        writer = new SymbolWriter();

        mockPrintStream = mock(PrintStream.class);
        symbolRepository = mock(SymbolRepository.class);

        when(symbolRepository.get("one")).thenReturn("I");
        when(symbolRepository.get("ten")).thenReturn("X");
        when(symbolRepository.get("fifty")).thenReturn("L");

        writer.setSymbolRepository(symbolRepository);

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
     * Should output single variable sum.
     */
    @Test
    public void shouldOutputSingleVariableSum() {
        writer.process("how much is ten ?");
        verify(mockPrintStream).println("ten is 10");
    }

    /**
     * Should output multiple variable sum.
     */
    @Test
    public void shouldOutputMultipleVariableSum() {
        writer.process("how much is ten fifty one one ?");
        verify(mockPrintStream).println("ten fifty one one is 42");
    }
}
