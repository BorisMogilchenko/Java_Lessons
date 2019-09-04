package ru.quazar.l05springboot.service;

import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @version $Id: StreamToFileService.java,v 1.0 2019-08-20 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
public class StreamToFileService {

    /**
     * Put file to target directory.
     *
     * @param myList Collection of strings for upload into file
     * @param target Upload file name
     * @throws IOException
     * @exception RuntimeException
     */
    static void uploadStreamToFile (String outString, File target) {

        try(FileOutputStream outFile = new FileOutputStream(target)

        ){
            byte[]buffer = outString.getBytes();
            outFile.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
