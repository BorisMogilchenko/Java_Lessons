package ru.quazar.l02;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
class FileToStream {
    private static final String findString = "Hello, guys!";

    /**
     * Get file from source path.
     *
     * @param inputFile Object File with path to file
     *
     * @return String file path
     *
     * @throws IOException
     * @exception RuntimeException
     */
    static String loadFileToStream(File inputFile) {

        String myStringToFile = "";
        try (FileInputStream inFile = new FileInputStream(inputFile)

        ) {
            myStringToFile = fileFromStreamToString(inFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myStringToFile;
    }

    /**
     * Get file from stream to string.
     *
     * @param inFile FileInputStream stream
     *
     * @return cTargetString String for write to file
     *
     * @throws IOException
     * @exception RuntimeException
     */
    private static String fileFromStreamToString(FileInputStream inFile) throws IOException {
        String cOutSubString1 = "";
        String cOutSubString2 = "";
        String cTargetString = "";
        int c;
        String cOutSubString2 = "";
        String sInputFile;
        int iBeginFindString;
        int iLenSubString = 20;

        StringBuilder inCharToString = new StringBuilder();
        while ((c = inFile.read()) != -1) {
            inCharToString.append(Character.toChars(c));
        }
        sInputFile = inCharToString.toString();
        System.out.println(sInputFile);
        System.out.println();
        if (sInputFile.contains(findString)) {
            if ((iBeginFindString = sInputFile.indexOf(findString)) != -1) {
                cOutSubString1 = sInputFile.substring(iBeginFindString - iLenSubString, iBeginFindString);
                cOutSubString2 = sInputFile.substring(iBeginFindString + findString.length(), iBeginFindString + (findString.length()) + (iLenSubString));
            }
        }

        cTargetString = cOutSubString1 + cOutSubString2;

        return cTargetString;
    }
}
