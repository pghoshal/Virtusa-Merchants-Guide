package com.virtusa.merchants.galaxy.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.virtusa.merchants.galaxy.repository.Repository;

/**
 * The Class RepositoryUtilTest.
 */
public class RepositoryUtilTest {
    
    /** The Constant TEST_INPUT. */
    private static final String[] TEST_INPUT = {"ten", "fifty", "one", "one"};
    
    /** The Constant TEST_OUTPUT. */
    private static final String TEST_OUTPUT = "XLII";

    /**
     * Should lookup and return symbols.
     */
    @Test
    public void shouldLookupAndReturnSymbols() {
        Repository repository = mock(Repository.class);

        when(repository.get("one")).thenReturn("I");
        when(repository.get("ten")).thenReturn("X");
        when(repository.get("fifty")).thenReturn("L");

        assertThat(RepositoryUtil.lookupSymbolsFromVariables(repository, TEST_INPUT), is(equalTo(TEST_OUTPUT)));
    }
}
