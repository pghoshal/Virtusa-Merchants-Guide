package com.virtusa.merchants.galaxy.factory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * The Class RepositoryFactoryTest.
 */
public class RepositoryFactoryTest {
    
    /** The Constant SYMBOL_MATCH. */
    private static final String SYMBOL_MATCH = "prok is V";
    
    /** The Constant SYMBOL_NAME. */
    private static final String SYMBOL_NAME = "symbolRepository";
    
    /** The Constant CREDIT_MATCH. */
    private static final String CREDIT_MATCH = "glob prok Gold is 57800 Credits";
    
    /** The Constant CREDIT_NAME. */
    private static final String CREDIT_NAME = "creditRepository";

    /**
     * Should get symbol repository by matcher.
     */
    @Test
    public void shouldGetSymbolRepositoryByMatcher() {
        assertThat(RepositoryFactory.getRepository(SYMBOL_MATCH), is(instanceOf(SymbolRepository.class)));
    }

    /**
     * Should get symbol repository by name.
     */
    @Test
    public void shouldGetSymbolRepositoryByName() {
        assertThat(RepositoryFactory.getRepository(SYMBOL_NAME), is(instanceOf(SymbolRepository.class)));
    }

    /**
     * Should get credit repository by matcher.
     */
    @Test
    public void shouldGetCreditRepositoryByMatcher() {
        assertThat(RepositoryFactory.getRepository(CREDIT_MATCH), is(instanceOf(CreditRepository.class)));
    }

    /**
     * Should get credit repository by name.
     */
    @Test
    public void shouldGetCreditRepositoryByName() {
        assertThat(RepositoryFactory.getRepository(CREDIT_NAME), is(instanceOf(CreditRepository.class)));
    }
}
