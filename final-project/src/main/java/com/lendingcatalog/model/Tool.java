package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Tool implements CatalogItem{
    //variables
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    //constructors
    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }
    //methods

    @Override
    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Number Available: " + count + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if(searchStr.equalsIgnoreCase(type)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if(searchStr.equalsIgnoreCase(manufacturer)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() throws FileStorageException {
        id = String.valueOf(UUID.randomUUID());
        String fileName = "src/main/resources/logs/tools.dat";
        String dateAndTime = String.valueOf(LocalDate.now());

        FileStorageService.writeContentsToFile(dateAndTime + " " + this.toString(), fileName, true);
    }
}
