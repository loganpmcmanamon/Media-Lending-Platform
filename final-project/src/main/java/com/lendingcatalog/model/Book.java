package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem{
    //variables
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;


    //constructors
    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
    //methods
    @Override
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }
    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr.equalsIgnoreCase(title)){
            return true;
        }
        return false;
    }
    @Override
    public boolean matchesCreator(String searchStr) {
        if(searchStr.equalsIgnoreCase(author)){
            return true;
        }
        return false;
    }
    @Override
    public boolean matchesYear(int searchYear) {
        if(searchYear == publishDate.getYear()){
            return true;
        }
        return false;
    }
    @Override
    public void registerItem() throws FileStorageException {
        id = String.valueOf(UUID.randomUUID());
        String fileName = "src/main/resources/logs/books.dat";
        String dateAndTime = String.valueOf(LocalDate.now());

        FileStorageService.writeContentsToFile(dateAndTime + " " + this.toString(), fileName, true );
    }
}
