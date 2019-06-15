package com.virtusa.merchants.galaxy.factory;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;
import com.virtusa.merchants.galaxy.writer.CreditWriter;
import com.virtusa.merchants.galaxy.writer.SymbolWriter;
import com.virtusa.merchants.galaxy.writer.UnknownWriter;
import com.virtusa.merchants.galaxy.writer.Writer;

/**
 * A factory for creating Writer objects.
 *  @author prasenjit Ghoshal
 */
public class WriterFactory {
    
    /** The Constant REGEX_SYMBOL. */
    private static final String REGEX_SYMBOL = "^(how much is )[a-zA-Z ]+(\\?)$";
    
    /** The Constant REGEX_CREDIT. */
    private static final String REGEX_CREDIT = "^(how many Credits is )[a-zA-Z ]+(\\?)$";
    
    /** The Constant NAME_SYMBOL. */
    private static final String NAME_SYMBOL = "symbolWriter";
    
    /** The Constant NAME_CREDIT. */
    private static final String NAME_CREDIT = "creditWriter";
    
    /** The symbol writer. */
    private static SymbolWriter symbolWriter;
    
    /** The credit writer. */
    private static CreditWriter creditWriter;
    
    /** The unknown writer. */
    private static UnknownWriter unknownWriter;

    static {
        symbolWriter = new SymbolWriter();
        creditWriter = new CreditWriter();
        unknownWriter = new UnknownWriter();

        SymbolRepository symbolRepository = (SymbolRepository) RepositoryFactory.getRepository("symbolRepository");
        CreditRepository creditRepository = (CreditRepository) RepositoryFactory.getRepository("creditRepository");

        symbolWriter.setSymbolRepository(symbolRepository);
        creditWriter.setSymbolRepository(symbolRepository);
        creditWriter.setCreditRepository(creditRepository);
    }

    /**
     * Gets the writer.
     *
     * @param input the input
     * @return the writer
     */
    public static Writer getWriter(String input) {
        if (NAME_SYMBOL.equals(input) || input.matches(REGEX_SYMBOL)) {
            return symbolWriter;
        }
        else if (NAME_CREDIT.equals(input) || input.matches(REGEX_CREDIT)) {
            return creditWriter;
        }
        else {
            return unknownWriter;
        }
    }
}
