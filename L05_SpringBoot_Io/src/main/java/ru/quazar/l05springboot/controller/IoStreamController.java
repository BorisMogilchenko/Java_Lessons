package ru.quazar.l05springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.quazar.l05springboot.model.FileToStream;
import ru.quazar.l05springboot.service.FileGetterService;
import ru.quazar.l05springboot.service.FileToStreamService;
import ru.quazar.l05springboot.service.StreamToFileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IoStreamController witch manages models, services, repositories.
 *
 * @version $Id: IoStreamController.java,v 1.0 2019-08-20 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@RestController
public class IoStreamController {

    private static List<String> myResponseStrings = new ArrayList<>();

    @RequestMapping("/")
    public String index() {
        return "Welcome to Home page of Spring Boot!";
    }

    @RequestMapping("/get")
    public List<Object> getWithMultipleParams(
            FileToStream fileToStream) throws IOException {

        return Arrays.asList(
                fileToStream.getReadingTarget(),
                fileToStream.getTargetPath(),
                fileToStream.getFileName());
    }

    @RequestMapping("/getString")
    public String getResponseWithMultipleParams(
            FileToStream fileToStream) throws IOException {

        List<String> myInputList = Arrays.asList(
                fileToStream.getReadingTarget(),
                fileToStream.getTargetPath(),
                fileToStream.getFileName());
        String myStringToFile = "";
        String loadFilePath = "";

        FileGetterService fileGetter = new FileGetterService();

        if (myInputList.get(1).length() == 0) {
            loadFilePath = "";
        } else {
            loadFilePath = myInputList.get(1);
        }

        File inputFile = fileGetter.getFileWithConditions(myInputList.get(0), loadFilePath, myInputList.get(2));
        myStringToFile = FileToStreamService.loadFileToStream(inputFile);
        File outFile = new File(inputFile.getParent(), myStringToFile);
        StreamToFileService.uploadStreamToFile(myStringToFile, outFile);

        return myStringToFile;
    }

/*    @RequestMapping("/getFile")
    public List<Object> getWithMultipleRequestParams(
            @RequestParam(value = "readingTarget") String readingTarget,
            @RequestParam(value = "targetPath") String targetPath,
            @RequestParam(value = "fileName") String fileName
    ) throws IOException {
        final FileToStream fileToStream = new ObjectMapper().readValue(fileToStream, FileToStream.class);
        return Arrays.asList(
                fileToStream.getReadingTarget(),
                fileToStream.getTargetPath(),
                fileToStream.getFileName());
//        return "Welcome from Spring Boot!";
    }*/

/*    @Autowired
    private FileGetterService fileGetterService;
    private FileToStreamService fileToStreamServise;
    private StreamToFileService streamToFileService;

*/
}

