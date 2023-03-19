package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        if(appendFile){
           try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(filename, true))){
               dataOutput.println(contents);

           }catch (FileNotFoundException e){
               System.out.println("This file was not found. ");
           }
        }
        else {
            try(PrintWriter dataOutput = new PrintWriter(filename)) {
                dataOutput.println(contents);
            }catch (FileNotFoundException e){
                System.out.println("Please provide a valid fileName");
            }
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> fileContents = new ArrayList<>();

        try(Scanner fileInput = new Scanner(filename)){
            String contents = fileInput.nextLine();

            while (fileInput.hasNextLine()){
                fileContents.add(contents);
            }
        }
        return fileContents;
    }
}
