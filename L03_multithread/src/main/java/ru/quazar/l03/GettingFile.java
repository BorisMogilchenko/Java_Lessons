package ru.quazar.l03;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
class GettingFile {

    /**
     * Get file with input conditions.
     *
     * @param fileName Source file name
     * @param filePath Source file path
     * @throws IOException
     * @exception RuntimeException
     */
    File getFileWithConditions(String fileName) throws IOException {

        System.out.println("Имя файла: " + fileName);
        System.out.println();
        File file = new File(fileName);
        if (fileName.contains("\\")) {
            if (file.exists()) {
                return getFileByPath(fileName);
            } else {
                throw new RuntimeException("Not correct first argument");
            }
        } else {
            if (fileName.length() != 0) {
                return getFileFromRes(fileName);
            } else {
                throw new RuntimeException("Not correct first argument");
            }
        }

    }

    /**
     * @return File by path.
     */
    private  File getFileByPath(String fileName) {
        return new File(fileName);
    }

    /**
     * @return File from resources.
     */
    private File getFileFromRes(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        URL srcResource = classLoader.getResource(fileName);
        if (srcResource == null) {
            throw new IOException("file is not found!");
        } else {
            return new File(srcResource.getFile());
        }
    }
}
