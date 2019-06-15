package com.virtusa.merchants.galaxy.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SymbolRepository.
 * @author prasenjit Ghoshal
 */
public class SymbolRepository implements Repository {
    
    /** The Constant DELIMITER. */
    private static final String DELIMITER = " is ";
    
    /** The symbols. */
    private Map<String, String> symbols = new HashMap<String, String>();

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.repository.Repository#get(java.lang.String)
     */
    public String get(String key) {
        return symbols.get(key);
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.repository.Repository#put(java.lang.String)
     */
    public void put(String input) {
        String[] args = input.split(DELIMITER);
        symbols.put(args[0], args[1]);
    }
}
