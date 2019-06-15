package com.virtusa.merchants.galaxy;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.virtusa.merchants.galaxy.parser.InputParser;

/**
 * The Class MerchantConverterApp.
 * @author prasenjit Ghoshal
 */
public class MerchantConverterApp {
    
    /** The input parser. */
    private static InputParser inputParser = new InputParser();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String input = parseInputFromFilePath(args[0]);
        processInput(input);
    }

    /**
     * Parses the input from file path.
     *
     * @param filePath the file path
     * @return the string
     */
    public static String parseInputFromFilePath(String filePath) {
        try {
            return new String(readAllBytes(get(filePath)));
        }
        catch (IOException e) {
            try {
                return attemptToLoadFileFromResource(filePath);
            }
            catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }

            return null;
        }
    }

    /**
     * Attempt to load file from resource.
     *
     * @param filePath the file path
     * @return the string
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static String attemptToLoadFileFromResource(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        return new String(readAllBytes(get(url.toURI())));
    }

    /**
     * Process input.
     *
     * @param input the input
     */
    public static void processInput(String input) {
        inputParser.parse(input);
    }

    /**
     * Sets the input parser.
     *
     * @param inputParser the new input parser
     */
    public void setInputParser(InputParser inputParser) {
        MerchantConverterApp.inputParser = inputParser;
    }
}
