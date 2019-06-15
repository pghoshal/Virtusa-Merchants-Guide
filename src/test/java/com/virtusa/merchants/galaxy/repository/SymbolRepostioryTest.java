package com.virtusa.merchants.galaxy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class SymbolRepostioryTest.
 */
public class SymbolRepostioryTest {
    
    /** The Constant TEST_KEY. */
    private static final String TEST_KEY = "foo";
    
    /** The Constant TEST_VALUE. */
    private static final String TEST_VALUE = "bar";
    
    /** The Constant TEST_INPUT_VALID. */
    private static final String TEST_INPUT_VALID = TEST_KEY + " is " + TEST_VALUE;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        symbolRepository = new SymbolRepository();
    }

    /**
     * Should set and get.
     */
    @Test
    public void shouldSetAndGet() {
        symbolRepository.put(TEST_INPUT_VALID);
        assertThat(symbolRepository.get(TEST_KEY), is(equalTo(TEST_VALUE)));
    }

    /**
     * Should get invalid key returns null.
     */
    @Test
    public void shouldGetInvalidKeyReturnsNull() {
        assertThat(symbolRepository.get(TEST_KEY), is(nullValue()));
    }
}
