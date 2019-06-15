package com.virtusa.merchants.galaxy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.virtusa.merchants.galaxy.interpreter.SymbolInterpreter;

/**
 * The Class CreditRepostioryTest.
 */
public class CreditRepostioryTest {
    
    /** The Constant TEST_VALUE_1. */
    private static final String TEST_VALUE_1 = "1";
    
    /** The Constant TEST_VALUE_9. */
    private static final String TEST_VALUE_9 = "9";
    
    /** The Constant TEST_VALUE_81. */
    private static final String TEST_VALUE_81 = "81";
    
    /** The Constant TEST_KEY. */
    private static final String TEST_KEY = "Gold";
    
    /** The Constant TEST_INPUT_SINGLE. */
    private static final String TEST_INPUT_SINGLE = "foo " + TEST_KEY + " is " + TEST_VALUE_81 + " Credits";
    
    /** The Constant TEST_INPUT_DOUBLE. */
    private static final String TEST_INPUT_DOUBLE = "foo bar " + TEST_KEY + " is " + TEST_VALUE_81 + " Credits";
    
    /** The credit repository. */
    private CreditRepository creditRepository;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;
    
    /** The symbol interpreter. */
    private SymbolInterpreter symbolInterpreter;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        creditRepository = new CreditRepository();

        symbolRepository = mock(SymbolRepository.class);
        symbolInterpreter = mock(SymbolInterpreter.class);

        when(symbolRepository.get("foo")).thenReturn("I");
        when(symbolRepository.get("bar")).thenReturn("X");
        when(symbolInterpreter.interpret("I")).thenReturn(new BigDecimal(TEST_VALUE_1));
        when(symbolInterpreter.interpret("IX")).thenReturn(new BigDecimal(TEST_VALUE_9));

        creditRepository.setSymbolRepository(symbolRepository);
        creditRepository.setSymbolInterpreter(symbolInterpreter);
    }

    /**
     * Should set and get single variable credit.
     */
    @Test
    public void shouldSetAndGetSingleVariableCredit() {
        creditRepository.put(TEST_INPUT_SINGLE);
        assertThat(creditRepository.get(TEST_KEY), is(equalTo(TEST_VALUE_81)));
    }

    /**
     * Should set and get double variable credit.
     */
    @Test
    public void shouldSetAndGetDoubleVariableCredit() {
        creditRepository.put(TEST_INPUT_DOUBLE);
        assertThat(creditRepository.get(TEST_KEY), is(equalTo(TEST_VALUE_9)));
    }

    /**
     * Should get invalid key returns null.
     */
    @Test
    public void shouldGetInvalidKeyReturnsNull() {
        assertThat(creditRepository.get(TEST_KEY), is(nullValue()));
    }
}
