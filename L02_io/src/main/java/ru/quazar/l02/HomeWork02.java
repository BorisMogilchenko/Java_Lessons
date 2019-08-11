package ru.quazar.l02;

import lombok.Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Data
public class HomeWork02 {

    private static final String findString = "Hello, guys!";
    private static final String inFileName = "homework_02_input.txt";
    private static final String outFileName = "homework_02_output.txt";

    public static void main(String[] args) throws IllegalArgumentException {
        private static String targetPath = "";
        private static String inFullName = "";
        private static String outFullName = "";

        if (args.length == 0) {
            System.out.println("Отсутствуют входящие параметры!!!");
            System.exit(0);
        }

        int readingTarget = Integer.parseInt(args[0]);


        if (readingTarget < 1 || readingTarget > 2) {
            System.out.println("Неправильное значение аргумента!!!");
            System.exit(0);
        } else {
            if ((args.length == 2) && !(args[1].length() == 0)) {
                targetPath = args[1];
            } else {
                targetPath = "L02_io\\src\\main\\resources\\";
            }
        }

        inFullName = targetPath + inFileName;
        outFullName = targetPath + outFileName;

        try {
            file2Stream(inFullName,outFullName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void file2Stream(String source, String target) throws IOException {

        private static String cOutSubString1 = "";
        private static String cOutSubString2 = "";
        int c;

        try (FileInputStream inFile = new FileInputStream(source);
             FileOutputStream outFile = new FileOutputStream(target)

        ) {
            StringBuilder inChar2String = new StringBuilder();
            String sInputFile;
            int iBeginFindString;
            int iLenSubString = 20;
                while ((c = inFile.read()) != -1) {
                    inChar2String.append(Character.toChars(c));
                }
            sInputFile = inChar2String.toString();
            if (sInputFile.contains(findString)) {
                if ((iBeginFindString = sInputFile.indexOf(findString)) != -1) {
                    cOutSubString1 = sInputFile.substring(iBeginFindString - iLenSubString, iBeginFindString);
                    cOutSubString2 = sInputFile.substring(iBeginFindString + findString.length(), iBeginFindString + (findString.length()) + (iLenSubString));
                }

                ArrayList<String> myString2File = new ArrayList<>();
                myString2File.add(cOutSubString1);
                myString2File.add(cOutSubString2);

                for (String s2f : myString2File) {
                    byte[] buffer = s2f.getBytes();
                    outFile.write(buffer);
                }
            }
        }
    }
}
