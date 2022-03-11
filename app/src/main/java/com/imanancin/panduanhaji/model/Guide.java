package com.imanancin.panduanhaji.model;

public class Guide {
    String title;
    String fileName;

    public Guide(String title, String fileName){
       this.title = title;
       this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }
}
