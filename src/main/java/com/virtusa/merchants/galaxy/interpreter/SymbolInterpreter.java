package com.virtusa.merchants.galaxy.interpreter;

import java.math.BigDecimal;

import javafx.util.Pair;

/**
 * The Class SymbolInterpreter.
 * @author prasenjit Ghoshal
 */
public class SymbolInterpreter {
    
    /** The Constant DELIMITER. */
    private static final java.lang.String DELIMITER = " ";
    
    /** The Constant REGEX_SYMBOLS. */
    private static final String REGEX_SYMBOLS = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    
    /** The Constant SUBSTITUTIONS. */
    public final static Pair[] SUBSTITUTIONS = {
            new Pair<String, String>("IV", " 4 "),
            new Pair<String, String>("IX", " 9 "),
            new Pair<String, String>("XL", " 40 "),
            new Pair<String, String>("XC", " 90 "),
            new Pair<String, String>("CD", " 400 "),
            new Pair<String, String>("CM", " 900 "),
            new Pair<String, String>("I", " 1 "),
            new Pair<String, String>("V", " 5 "),
            new Pair<String, String>("X", " 10 "),
            new Pair<String, String>("L", " 50 "),
            new Pair<String, String>("C", " 100 "),
            new Pair<String, String>("D", " 500 "),
            new Pair<String, String>("M", " 1000 ")
    };

    /**
     * Interpret.
     *
     * @param input the input
     * @return the big decimal
     */
    public BigDecimal interpret(String input) {
        validateInput(input);
        String decimalString = convertToDecimalStringWithSpacesBetween(input);
        return sumDecimalString(decimalString);
    }

    /**
     * Validate input.
     *
     * @param input the input
     */
    private void validateInput(String input) {
        if (!input.matches(REGEX_SYMBOLS)) {
            throw new IllegalArgumentException("Invalid symbol in the input: " + input);
        }
    }

    /**
     * Convert to decimal string with spaces between.
     *
     * @param input the input
     * @return the string
     */
    private String convertToDecimalStringWithSpacesBetween(String input) {
        String inputCopy = input;

        for (Pair<String, String> sub : SUBSTITUTIONS) {
            inputCopy = inputCopy.replaceAll(sub.getKey(), sub.getValue());
        }

        return inputCopy;
    }

    /**
     * Sum decimal string.
     *
     * @param decimalString the decimal string
     * @return the big decimal
     */
    private BigDecimal sumDecimalString(String decimalString) {
        BigDecimal sum = new BigDecimal(0);

        for (String element : decimalString.trim().replaceAll("  ", " ").split(DELIMITER)) {
            sum = sum.add(new BigDecimal(element.trim()));
        }

        return sum;
    }
}
