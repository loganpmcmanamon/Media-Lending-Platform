package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem{
    //variables
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    //constructors
    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }
    //methods

    @Override
    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if(searchStr.equalsIgnoreCase(name)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if(searchStr.equalsIgnoreCase(director)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if(searchYear == releaseDate.getYear()){
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() throws FileStorageException {
        id = String.valueOf(UUID.randomUUID());
        String fileName = "src/main/resources/logs/movies.dat";
        String dateAndTime = String.valueOf(LocalDate.now());

        FileStorageService.writeContentsToFile(dateAndTime + " " + this.toString(), fileName, true);
    }
}
