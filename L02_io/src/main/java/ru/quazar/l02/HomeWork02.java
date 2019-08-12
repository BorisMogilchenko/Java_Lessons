package ru.quazar.l02;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static ru.quazar.l02.File2Stream.loadFile2Stream;

@Data
public class HomeWork02 {

    private static final String inFileName = "homework_02_input.txt";
    private static final String outFileName = "homework_02_output.txt";

    public static void main(String[] args){
        String targetPath = "";
        String inFullName;
        String outFullName;
        int readingTarget = 0;

        HomeWork02 main = new HomeWork02();

        if (args.length == 0) {
            System.out.println("Отсутствуют входящие параметры!!!");
            return;
        }

        try {
            if (CheckArgString.isNumber(args[0]) )
                readingTarget = Integer.parseInt(args[0]);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Неправильное значение аргумента!!!");
        }

        switch (readingTarget) {
            case 1: targetPath = args[1];
                break;
            case 2: targetPath = "";
                break;
            default: System.out.println("Неправильное значение аргумента!!!");
                return;
        }

        File file = main.getFileFromResources("homework_02_input.txt");
        inFullName = targetPath + inFileName;
        outFullName = targetPath + outFileName;

        try {
            Stream2File.uploadStream2File(loadFile2Stream(inFullName),outFullName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

}
