package ru.quazar.l02;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;

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
public class HomeWork02 {

    private static final String inFileName = "homework_02_input.txt";
    private static final String outFileName = "homework_02_output.txt";

    public static void main(String[] args) throws Exception {
//        String targetPath = "";
//        String inFullName = "";
//        String outFullName = "";
//        ArrayList<String> myStringToFile;
        String myStringToFile;

        FileGetter fileGetter = new FileGetter();

        File inputFile = fileGetter.getFileWithConditions(args[0], args[1], inFileName);
        myStringToFile = FileToStream.loadFileToStream(inputFile);

        File outFile = new File(inputFile.getPath());
        StreamToFile.uploadStreamToFile(myStringToFile,outFile);
/*        HomeWork02 main = new HomeWork02();
        File fileInput = main.getFileFromResources(inFileName);
        targetPath = fileInput.getParent();

        switch (args.length) {
            case 0:
                System.out.println("Отсутствуют входящие параметры!!!");
                return;
            case 1:
                try {
                    if (isNumber(args[0]) )
                        readingTarget = Integer.parseInt(args[0]);
                } catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException("Неправильное значение аргумента!!!");
                }
                break;
            case 2:
                switch (readingTarget) {
                    case 1:
                        if (args.length == 2) {
                            targetPath = args[1];
                            inFullName = targetPath + inFileName;
                            outFullName = targetPath + outFileName;
                            break;
                        } else {
                            System.out.println("Неправильное значение аргумента (Тип 1 - 1, Тип 2 - пусто)!!!");
                            return;
                        }
                    case 2:
                        switch (args.length) {
                            case 1:
                                inFullName = targetPath + inFileName;
                                outFullName = targetPath + outFileName;
                                break;
                            case 2:
                                if (fileInput.exists()) {
                                    targetPath = args[1];
                                    inFullName = targetPath + inFileName;
                                    outFullName = targetPath + outFileName;
                                    break;
                                } else {
                                    System.out.println("Неправильное значение аргумента (Тип 1 - 2, Тип 2 - вне ресурсов)!!!");
                                    return;
                                }
                            default:
                                    System.out.println("Неправильное значение количества аргументов!!!");
                                    return;
                        }

                    default: System.out.println("Неправильное значение аргумента (Тип 1 не равен 1 или 2)!!!");
                        return;
                }
            default:
                System.out.println("Неправильное значение количества аргументов!!!");
                return;
        }*/

/*                        if (args.length == 2) {
                            File fileInput = main.getFileFromResources(inFileName);
                            System.out.println("Путь входящего файла: " + fileInput);

                            if (fileInput.exists()) {
                                targetPath = args[1];
                                inFullName = targetPath + inFileName;
                                outFullName = targetPath + outFileName;
                                break;
                            } else {
                                System.out.println("Неправильное значение аргумента (Тип 1 - 2, Тип 2 - вне ресурсов)!!!");
                                return;
                            }
                        } if (args.length == 1) {
                        File fileInput = main.getFileFromResources(inFileName);
                        targetPath = fileInput.getParent();
                        inFullName = targetPath + inFileName;
                        outFullName = targetPath + outFileName;
                        break;
                    }*/

/*        System.out.println("Имя входящего файла: " + inFullName);
        System.out.println();
        System.out.println("Имя выходящего файла: " + outFullName);
        System.out.println();*/

    }

/*    private File getFileFromResources(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IOException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }*/

/*    private static boolean isNumber(String s) {
        try {
            int result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect type: " + e);
            //return false;
        }
        return true;
    }*/

}
