package com.virtusa.merchants.galaxy.util;

import com.virtusa.merchants.galaxy.repository.Repository;

/**
 * The Class RepositoryUtil.
 * @author prasenjit Ghoshal
 */
public class RepositoryUtil {
    
    /**
     * Lookup symbols from variables.
     *
     * @param repository the repository
     * @param keys the keys
     * @return the string
     */
    public static String lookupSymbolsFromVariables(Repository repository, String[] keys) {
        StringBuffer symbols = new StringBuffer();

        for (String key : keys) {
            symbols.append(repository.get(key));
        }

        return symbols.toString();
    }
}
