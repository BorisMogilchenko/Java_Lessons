package ru.quazar.l03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

class FileToBufStream {

    static Book loadFileToStream(File inputFile) {
        Book booksList = new ArrayList<String>();
        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
             BufferedReader bufRead = new BufferedReader(isr)
        ) {
            String line;
            while ((line = bufRead.readLine()) != null) {
                booksList.add(new Book(line, false));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return booksList;
    }
}
