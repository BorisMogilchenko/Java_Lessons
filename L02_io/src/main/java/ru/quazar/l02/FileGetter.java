package ru.quazar.l02;

import lombok.Data;

import java.io.File;

@Data
public class FileGetter {
    public File getFileWithConditions(String fileName, String filePath) {
        switch (fileName) {
            case "1" :
                return getFileByPath(fileName, filePath);
            case  "2" :
                return getFileFromResources(fileName);
            default:
                throw new RuntimeException("Not correct first argument");
        }
    }

    private  File getFileByPath(String fileName, String filePath) {
        return null;
    }

    private File getFileFromResources(String fileName) {
        return null;
    }
}
