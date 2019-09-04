package ru.quazar.l05springboot;

import lombok.Data;

import ru.quazar.l05springboot.model.FileToStream;

import java.io.File;

/**
 * Put file "homework_02_input.txt" in any path of file system, then put into
 * application resource folder.
 * Make class for finding source file by path, find substring "Hello, guys!".
 * Write to the file "homework_02_output.txt" twenty symbols behind and
 * twenty symbols after finding substring.
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
public class IoBootApplcation {

    private static final String inFileName;
    private static final String outFileName;

    public static void main(String[] args) throws Exception {
        String myStringToFile;
        String loadFilePath = "";

        FileGetter fileGetter = new FileGetter();

        if (args.length < 2) {
            loadFilePath = "";
        } else {
            loadFilePath = args[1];
        }

        File inputFile = fileGetter.getFileWithConditions(args[0], loadFilePath, inFileName);
        myStringToFile = FileToStream.loadFileToStream(inputFile);
        File outFile = new File(inputFile.getParent(), outFileName);
        StreamToFile.uploadStreamToFile(myStringToFile, outFile);
    }
}
