package ru.quazar.l02;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
class FileToStream {
    private static final String findString = "Hello, guys!";

    static List<String> loadFileToStream(String source) {
        String cOutSubString1 = "";
        String cOutSubString2 = "";
        int c;

        try (FileInputStream inFile = new FileInputStream(source)

        ) {
            String sInputFile;
            int iBeginFindString;
            int iLenSubString = 20;

            /*            StringBuilder inCharToString = new StringBuilder();
            while ((c = inFile.read()) != -1) {
                inCharToString.append(Character.toChars(c));
            }
            sInputFile = inCharToString.toString();*/
            sInputFile = inFile.toString();
            if (sInputFile.contains(findString)) {
                if ((iBeginFindString = sInputFile.indexOf(findString)) != -1) {
                    cOutSubString1 = sInputFile.substring(iBeginFindString - iLenSubString, iBeginFindString);
                    cOutSubString2 = sInputFile.substring(iBeginFindString + findString.length(), iBeginFindString + (findString.length()) + (iLenSubString));
                }
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> myStringToFile = new ArrayList<>();
        myStringToFile.add(cOutSubString1);
        myStringToFile.add(cOutSubString2);

        return myStringToFile;
    }
}
