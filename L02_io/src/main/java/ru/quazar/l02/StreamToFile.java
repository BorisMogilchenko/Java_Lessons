package ru.quazar.l02;

import lombok.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Data
class StreamToFile {
    static void uploadStreamToFile (ArrayList<String> myList, String target) {

        try(FileOutputStream outFile = new FileOutputStream(target)

        ){
            for(String s2f : myList){
            byte[]buffer=s2f.getBytes();
            outFile.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
