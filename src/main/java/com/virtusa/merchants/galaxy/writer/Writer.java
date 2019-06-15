package com.virtusa.merchants.galaxy.writer;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * The Interface Writer.
 * @author prasenjit Ghoshal
 */
public interface Writer {
    
    /**
     * Process.
     *
     * @param input the input
     */
    void process(String input);

    /**
     * Sets the symbol repository.
     *
     * @param symbolRepository the new symbol repository
     */
    void setSymbolRepository(SymbolRepository symbolRepository);

    /**
     * Sets the credit repository.
     *
     * @param creditRepository the new credit repository
     */
    void setCreditRepository(CreditRepository creditRepository);
}