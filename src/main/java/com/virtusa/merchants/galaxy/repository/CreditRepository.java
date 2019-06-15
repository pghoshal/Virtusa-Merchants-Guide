package com.virtusa.merchants.galaxy.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.virtusa.merchants.galaxy.interpreter.SymbolInterpreter;
import com.virtusa.merchants.galaxy.util.RepositoryUtil;

/**
 * The Class CreditRepository.
 * @author prasenjit Ghoshal
 */
public class CreditRepository implements Repository {
    
    /** The Constant DELIMITER. */
    private static final String DELIMITER = " ";
    
    /** The Constant ANCHOR_TEXT. */
    private static final String ANCHOR_TEXT = "is";
    
    /** The credits. */
    private Map<String, BigDecimal> credits = new HashMap<String, BigDecimal>();
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;
    
    /** The symbol interpreter. */
    private SymbolInterpreter symbolInterpreter;

    /**
     * Instantiates a new credit repository.
     */
    public CreditRepository() {
        symbolInterpreter = new SymbolInterpreter();
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.repository.Repository#get(java.lang.String)
     */
    public String get(String key) {
        if (credits.get(key) == null) {
            return null;
        }

        return credits.get(key).toString();
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.repository.Repository#put(java.lang.String)
     */
    public void put(String input) {
        String[] args = input.split(DELIMITER);
        int anchorPos = findArrayPositionForWordIs(args);
        processArgumentsAndPutToMap(args, anchorPos);
    }

    /**
     * Find array position for word is.
     *
     * @param array the array
     * @return the int
     */
    private int findArrayPositionForWordIs(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (ANCHOR_TEXT.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Process arguments and put to map.
     *
     * @param args the args
     * @param anchorPos the anchor pos
     */
    private void processArgumentsAndPutToMap(String[] args, int anchorPos) {
        String key = args[anchorPos - 1];
        BigDecimal value = new BigDecimal(args[anchorPos + 1]);
        BigDecimal multiplier = getDecimalFromVariables(Arrays.copyOfRange(args, 0, anchorPos - 1));

        credits.put(key, value.divide(multiplier));
    }

    /**
     * Gets the decimal from variables.
     *
     * @param variables the variables
     * @return the decimal from variables
     */
    private BigDecimal getDecimalFromVariables(String[] variables) {
        String symbols = RepositoryUtil.lookupSymbolsFromVariables(symbolRepository, variables);
        return getNumberFromSymbols(symbols);
    }

    /**
     * Gets the number from symbols.
     *
     * @param symbols the symbols
     * @return the number from symbols
     */
    private BigDecimal getNumberFromSymbols(String symbols) {
        return symbolInterpreter.interpret(symbols);
    }

    /**
     * Sets the symbol repository.
     *
     * @param symbolRepository the new symbol repository
     */
    public void setSymbolRepository(SymbolRepository symbolRepository) {
        this.symbolRepository = symbolRepository;
    }

    /**
     * Sets the symbol interpreter.
     *
     * @param symbolInterpreter the new symbol interpreter
     */
    public void setSymbolInterpreter(SymbolInterpreter symbolInterpreter) {
        this.symbolInterpreter = symbolInterpreter;
    }
}
