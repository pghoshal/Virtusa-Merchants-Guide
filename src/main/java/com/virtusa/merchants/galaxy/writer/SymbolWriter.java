package com.virtusa.merchants.galaxy.writer;

import com.virtusa.merchants.galaxy.interpreter.SymbolInterpreter;
import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;
import com.virtusa.merchants.galaxy.util.RepositoryUtil;

/**
 * The Class SymbolWriter.
 * @author prasenjit Ghoshal
 */
public class SymbolWriter implements Writer {
    
    /** The Constant PREFIX. */
    private static final String PREFIX = "how much is ";
    
    /** The Constant SUFFIX. */
    private static final String SUFFIX = " ?";
    
    /** The Constant DELIMITER. */
    private static final java.lang.String DELIMITER = " ";
    
    /** The symbol interpreter. */
    private SymbolInterpreter symbolInterpreter;
    
    /** The symbol repository. */
    private SymbolRepository symbolRepository;

    /**
     * Instantiates a new symbol writer.
     */
    public SymbolWriter() {
        symbolInterpreter = new SymbolInterpreter();
    }

    /* (non-Javadoc)
     * @see com.virtusa.merchants.galaxy.writer.Writer#process(java.lang.String)
     */
    public void process(String input) {
        String variables = extractVariablesFromInput(input);
        String symbols = RepositoryUtil.lookupSymbolsFromVariables(symbolRepository, variables.split(DELIMITER));
        writeOutput(variables, symbols);
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
     * @param symbols the symbols
     */
    private void writeOutput(String variables, String symbols) {
        System.out.println(variables + " is " + symbolInterpreter.interpret(symbols));
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
    }
}
