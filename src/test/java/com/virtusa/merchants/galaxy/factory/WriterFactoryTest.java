package com.virtusa.merchants.galaxy.factory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import com.virtusa.merchants.galaxy.writer.CreditWriter;
import com.virtusa.merchants.galaxy.writer.SymbolWriter;
import com.virtusa.merchants.galaxy.writer.UnknownWriter;

/**
 * The Class WriterFactoryTest.
 */
public class WriterFactoryTest {
    
    /** The Constant SYMBOL_MATCH. */
    private static final String SYMBOL_MATCH = "how much is pish tegj glob glob ?";
    
    /** The Constant SYMBOL_NAME. */
    private static final String SYMBOL_NAME = "symbolWriter";
    
    /** The Constant CREDIT_MATCH. */
    private static final String CREDIT_MATCH = "how many Credits is glob prok Gold ?";
    
    /** The Constant CREDIT_NAME. */
    private static final String CREDIT_NAME = "creditWriter";
    
    /** The Constant UNKNOWN_MATCH. */
    private static final String UNKNOWN_MATCH = "how much wood could a woodchuck chuck ?";

    /**
     * Should get symbol writer by matcher.
     */
    @Test
    public void shouldGetSymbolWriterByMatcher() {
        assertThat(WriterFactory.getWriter(SYMBOL_MATCH), is(instanceOf(SymbolWriter.class)));
    }

    /**
     * Should get symbol writer by name.
     */
    @Test
    public void shouldGetSymbolWriterByName() {
        assertThat(WriterFactory.getWriter(SYMBOL_NAME), is(instanceOf(SymbolWriter.class)));
    }

    /**
     * Should get credit writer by matcher.
     */
    @Test
    public void shouldGetCreditWriterByMatcher() {
        assertThat(WriterFactory.getWriter(CREDIT_MATCH), is(instanceOf(CreditWriter.class)));
    }

    /**
     * Should get credit writer by name.
     */
    @Test
    public void shouldGetCreditWriterByName() {
        assertThat(WriterFactory.getWriter(CREDIT_NAME), is(instanceOf(CreditWriter.class)));
    }

    /**
     * Should get unknown writer by matcher.
     */
    @Test
    public void shouldGetUnknownWriterByMatcher() {
        assertThat(WriterFactory.getWriter(UNKNOWN_MATCH), is(instanceOf(UnknownWriter.class)));
    }
}
