package com.virtusa.merchants.galaxy.writer;

import java.math.BigDecimal;
import java.util.Arrays;

import com.virtusa.merchants.galaxy.interpreter.SymbolInterpreter;
import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;
import com.virtusa.merchants.galaxy.util.RepositoryUtil;

/**
 * The Class CreditWriter.
 * @author prasenjit Ghoshal
 */
public class CreditWriter implements Writer {
    
    /** The Constant PREFIX. */
    private static final String PREFIX = "how many credits is ";
    
    /** The Constant SUFFIX. */
    private static final String SUFFIX = " ?";
    
    /** The Constant DELIMITER. */
    private static final java.lang.String DELIMITER = " ";
    
    /** The symbol interpreter. */
    private SymbolInterpreter symbolInterpreter;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;
    
    /** The credit repository. */
    private CreditRepository creditRepository;

    /**
     * Instantiates a new credit writer.
     */
    public CreditWriter() {
        symbolInterpreter = new SymbolInterpreter();
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#process(java.lang.String)
     */
    // Messy, would like to refactor into smaller functions but heavily intertwined steps
    public void process(String input) {
        String argumentString = extractVariablesFromInput(input);

        String[] argumentArray = argumentString.split(DELIMITER);
        String key = argumentArray[argumentArray.length - 1];
        String[] variables = Arrays.copyOfRange(argumentArray, 0, argumentArray.length - 1);
        String symbols = RepositoryUtil.lookupSymbolsFromVariables(symbolRepository, variables);

        writeOutput(argumentString, key, symbols);
    }

    /**
     * Extract variables from input.
     *
     * @param input the input
     * @return the string
     */
    private String extractVariablesFromInput(String input) {
        return input.substring(PREFIX.length(), input.length() - SUFFIX.length());
    }

    /**
     * Write output.
     *
     * @param variables the variables
     * @param key the key
     * @param symbols the symbols
     */
    private void writeOutput(String variables, String key, String symbols) {
        BigDecimal credits = new BigDecimal(creditRepository.get(key)).multiply(symbolInterpreter.interpret(symbols));
        credits = credits.setScale(0);
        System.out.println(variables + " is " + credits.toString() + " Credits");
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#setSymbolRepository(com.virtusa.merchants.galaxy.repository.SymbolRepository)
     */
    public void setSymbolRepository(SymbolRepository symbolRepository) {
        this.symbolRepository = symbolRepository;
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#setCreditRepository(com.virtusa.merchants.galaxy.repository.CreditRepository)
     */
    public void setCreditRepository(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }
}
