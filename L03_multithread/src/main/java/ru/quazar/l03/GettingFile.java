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

        File file = new File(fileName);
        if (file.exists()) {
            return getFileFromRes(fileName);
        } else {
            throw new RuntimeException("Not correct first argument");
        }

/*        switch (typeTarget) {
            case "1":
                return getFileFromRes(fileName);
            default:
                throw new RuntimeException("Not correct first argument");
        }*/
    }

    /**
     * @return File by path.
     */
    private  File getFileByPath(String filePath, String fileName) {
        return new File(filePath, fileName);
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
