package com.axelpalacios.todoapp;
//Creating items for the list
public class ToDo {
    private String title;
    private String description;

    //Constructor
    public ToDo(String title, String description){
        this.title = title;
        this.description = description;
    }

    //get statements for title and description
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }

    //What shows in the actual list
    @Override
    public String toString(){
        return title;
    }
}
