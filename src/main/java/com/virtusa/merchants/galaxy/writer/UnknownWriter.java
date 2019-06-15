package com.virtusa.merchants.galaxy.writer;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * The Class UnknownWriter.
 * @author prasenjit Ghoshal
 */
public class UnknownWriter implements Writer {
    
    /** The Constant UNKNOWN_MESSAGE. */
    private static final String UNKNOWN_MESSAGE = "I have no idea what you are talking about";

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#process(java.lang.String)
     */
    public void process(String input) {
        System.out.println(UNKNOWN_MESSAGE);
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#setSymbolRepository(com.virtusa.merchants.galaxy.repository.SymbolRepository)
     */
    public void setSymbolRepository(SymbolRepository symbolRepository) {
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#setCreditRepository(com.virtusa.merchants.galaxy.repository.CreditRepository)
     */
    public void setCreditRepository(CreditRepository creditRepository) {
    }
}
