package ru.quazar.l04springboot.service;

/**
 * Check of values incoming arguments
 */
public class CheckArgsService {
    /**
     * Check count cycle iteration
     *
     * @param args Array of incoming arguments
     * @return Integer type of count cycle iteration
     * @throws NumberFormatException
     */
    public static int checkIteration(String[] args) throws NumberFormatException {
        if (args.length == 1) {
            return Integer.parseInt(args[0]);
        } else {
            throw new NumberFormatException("Incorrect argument!!!");
        }
    }
}
