package com.virtusa.merchants.galaxy.writer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * The Class CreditWriterTest.
 */
public class CreditWriterTest {
    
    /** The writer. */
    private CreditWriter writer;
    
    /** The mock print stream. */
    private PrintStream mockPrintStream;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;
    
    /** The credit repository. */
    private CreditRepository creditRepository;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        writer = new CreditWriter();

        mockPrintStream = mock(PrintStream.class);
        symbolRepository = mock(SymbolRepository.class);
        creditRepository = mock(CreditRepository.class);

        when(symbolRepository.get("one")).thenReturn("I");
        when(symbolRepository.get("ten")).thenReturn("X");
        when(symbolRepository.get("fifty")).thenReturn("L");
        when(creditRepository.get("Foo")).thenReturn("2");

        writer.setSymbolRepository(symbolRepository);
        writer.setCreditRepository(creditRepository);

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
     * Should output no multiplier credits.
     */
    @Test
    public void shouldOutputNoMultiplierCredits() {
        writer.process("how many Credits is ten Foo ?");
        verify(mockPrintStream).println("ten Foo is 20 Credits");
    }

    /**
     * Should output multiplier credits.
     */
    @Test
    public void shouldOutputMultiplierCredits() {
        writer.process("how many Credits is ten fifty Foo ?");
        verify(mockPrintStream).println("ten fifty Foo is 80 Credits");
    }
}
