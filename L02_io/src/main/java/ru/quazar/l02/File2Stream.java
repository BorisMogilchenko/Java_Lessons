package ru.quazar.l02;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Data
class File2Stream {
    private static final String findString = "Hello, guys!";

    static ArrayList<String> loadFile2Stream(String source) {
        String cOutSubString1 = "";
        String cOutSubString2 = "";
        int c;

        try (FileInputStream inFile = new FileInputStream(source)

        ) {
            StringBuilder inChar2String = new StringBuilder();
            String sInputFile;
            int iBeginFindString;
            int iLenSubString = 20;
            while ((c = inFile.read()) != -1) {
                inChar2String.append(Character.toChars(c));
            }
            sInputFile = inChar2String.toString();
            if (sInputFile.contains(findString)) {
                if ((iBeginFindString = sInputFile.indexOf(findString)) != -1) {
                    cOutSubString1 = sInputFile.substring(iBeginFindString - iLenSubString, iBeginFindString);
                    cOutSubString2 = sInputFile.substring(iBeginFindString + findString.length(), iBeginFindString + (findString.length()) + (iLenSubString));
                }
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> myString2File = new ArrayList<>();
        myString2File.add(cOutSubString1);
        myString2File.add(cOutSubString2);

        return myString2File;
    }
}
