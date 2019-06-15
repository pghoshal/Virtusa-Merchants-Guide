package com.virtusa.merchants.galaxy.parser;

import com.virtusa.merchants.galaxy.factory.RepositoryFactory;
import com.virtusa.merchants.galaxy.factory.WriterFactory;

/**
 * The Class InputParser.
 * @author prasenjit Ghoshal
 */
public class InputParser {
    
    /** The Constant WRITER_LINE_PREFIX. */
    private static final String WRITER_LINE_PREFIX = "how ";

    /**
     * Parses the.
     *
     * @param input the input
     */
    public void parse(String input) {
        for (String line : input.split("\\r?\\n")) {
            parseSingleLine(line);
        }
    }

    /**
     * Parses the single line.
     *
     * @param input the input
     */
    public void parseSingleLine(String input) {
        if (input.startsWith(WRITER_LINE_PREFIX)) {
            WriterFactory.getWriter(input).process(input);
        }
        else {
            RepositoryFactory.getRepository(input).put(input);;
        }
    }
}
