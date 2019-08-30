package ru.quazar.l04springboot.service;

/**
 *
 */
public class CheckArgsService {
    /**
     *
     *
     * @param args
     * @return
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
