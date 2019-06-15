package com.virtusa.merchants.galaxy.factory;

import com.virtusa.merchants.galaxy.repository.CreditRepository;
import com.virtusa.merchants.galaxy.repository.Repository;
import com.virtusa.merchants.galaxy.repository.SymbolRepository;

/**
 * A factory for creating Repository objects.
 * @author prasenjit Ghoshal
 */
public class RepositoryFactory {
    
    /** The Constant REGEX_SYMBOL. */
    private static final String REGEX_SYMBOL = "^[a-zA-Z]+( is )(I|V|X|L|C|D|M)$";
    
    /** The Constant REGEX_CREDIT. */
    private static final String REGEX_CREDIT = "^[a-zA-Z ]*[a-zA-Z]+( is )[0-9]+( Credits)$";
    
    /** The Constant NAME_SYMBOL. */
    private static final String NAME_SYMBOL = "symbolRepository";
    
    /** The Constant NAME_CREDIT. */
    private static final String NAME_CREDIT = "creditRepository";
    
    /** The symbol repository. */
    private static SymbolRepository symbolRepository;
    
    /** The credit repository. */
    private static CreditRepository creditRepository;

    static {
        symbolRepository = new SymbolRepository();
        creditRepository = new CreditRepository();
        creditRepository.setSymbolRepository(symbolRepository);
    }

    /**
     * Gets the repository.
     *
     * @param input the input
     * @return the repository
     */
    public static Repository getRepository(String input) {
        if (NAME_SYMBOL.equals(input) || input.matches(REGEX_SYMBOL)) {
            return symbolRepository;
        }
        else if (NAME_CREDIT.equals(input) || input.matches(REGEX_CREDIT)) {
            return creditRepository;
        }

        return null;
    }
}
