package com.virtusa.merchants.galaxy.repository;

/**
 * The Interface Repository.
 * @author prasenjit Ghoshal
 */
public interface Repository {
    
    /**
     * Put.
     *
     * @param input the input
     */
    void put(String input);

    /**
     * Gets the.
     *
     * @param key the key
     * @return the string
     */
    String get(String key);
}
