package ru.quazar.l02;

import lombok.Data;

@Data
class CheckArgString {
    static boolean isNumber(String s) {
        try {
            int result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect type: " + e);
            //return false;
        }
        return true;
    }
}
