package ru.quazar.l03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

class FileToBufStream {

    static ArrayList loadFileToStream(File inputFile, Book booksCatalog) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
             BufferedReader bufRead = new BufferedReader(isr)
        ) {
            String line;
            while ((line = bufRead.readLine()) != null) {
                booksCatalog.add(new Book(line, false));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return booksCatalog;
    }
}
