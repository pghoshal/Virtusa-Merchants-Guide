# Overview

* TDD using JUnit, Hamcrest, Mockito and PowerMockito (96.9% coverage). Unit and integration testing -- passes supplied test data.
* Tools: IDEA 14 (static code analysis) and Git (local)
* System components:
 * MerchantConverterApp: Runnable, loads input file and passes to Parser
 * InputParser: Parses each line and calls relevant Repository and Writer interface function
 * Factories: Repository and Writer factories for obtaining the correct concrete implementation based on regex or name
 * Repository: Interface and concrete implementations for setting Symbols (i.e. Roman numerals) or Credits
 * Writer: Interface and concrete implementations for getting and outputting Symbols or Credits
 * SymbolInterpreter: Conversion from Roman to Arabic numerals
 * RepositoryUtil: Helper method used by different classes

# Design and Assumptions

* Maven project with pom.xml for dependency management (testing libraries)
* 'Clean Code' principles (e.g. naming, only necessary code comments, DRY, SRP, small functions, avoid magic numbers...)
* In Roman numerals VVV, LLL and DDD are invalid, which is reflected in the Interpreter.
* Use of Repository and Writer interfaces for polymorphism of common functions with different implementations
* Credits are stored assuming a quantity of 1 -- this is then multiplied as required for output
* Credits are stored as BigDecimal, but output with no decimal places (in order to conform to test output)
* Writers are in control of output implementation (currently System.out) to reduce data bubbling and allow flexibility
* Unit tests for InputParser (trouble getting PowerMockito to work with my legacy version of JUnit...ran out of time)

# Enhancements

* String interpolation instead of concatenation
* Additional unit tests for private functions (change to protected). Underlying implementation so not tested-first with TDD.
* Better name for 'Repository' (not happy with it)
* Increased validation (e.g. case insensitive, boundary conditions, invalid data in correct format) and error handling
* Integration test not to have a hard-coded file path

# How to build with test cases

mvn clean package

# How to Run

Three separate ways to run -- all equivalent.

## Terminal

1. Open Terminal or Console
2. Navigate to the ZIP folder directory: /Virtusa-Merchants-Guide/target/classes
3. Run: java com.virtusa.merchants.galaxy.MerchantConverterApp "/path/to/your/input/file"

__Sample:__

$ pwd
/Users/me/projects/Virtusa-Merchants-Guide/target/classes

$ java com.virtusa.merchants.galaxy.MerchantConverterApp "/Users/me/projects/Virtusa-Merchants-Guide/src/test/resources/test-input.txt"

## Load project in IDEA/Eclipse and run integration test

1. Import the project in IDEA
2. Use Maven to download any dependencies
3. Open the MerchantConverterAppIntegrationTest class
4. Modify the FULL_INPUT_PATH variable to that on your machine
5. Right click the class and select 'Run' to launch the test

## Load project in IDEA/Eclipse and specify a Run Configuration

1. Import the project in IDEA
2. Use Maven to download any dependencies
3. Open the MerchantConverterApp class
4. In the toolbar select Run > Edit Configurations
5. Add a new 'Application' run type, com.virtusa.merchants.galaxy.MerchantConverterApp as the class, and input file path as the program arguments
6. Run the configuration