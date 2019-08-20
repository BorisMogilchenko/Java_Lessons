package main.java.ru.quazar.l05.service;

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
class FileGetterService {

    /**
     * Get file with input conditions.
     *
     * @param fileName Source file name
     * @param filePath Source file path
     * @throws IOException
     * @exception RuntimeException
     */
    File getFileWithConditions(String target, String filePath, String fileName) throws IOException {
        switch (target) {
            case "1":
                return getFileByPath(filePath, fileName);
            case  "2":
                return getFileFromResources(fileName);
            default:
                throw new RuntimeException("Not correct first argument");
        }
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
    private File getFileFromResources(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IOException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
