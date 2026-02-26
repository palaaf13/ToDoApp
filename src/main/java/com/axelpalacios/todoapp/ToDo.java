package com.axelpalacios.todoapp;

public class ToDo {
    private String title;
    private String description;

    public ToDo(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){ return title; }
    public String getDescription(){ return description; }

    @Override
    public String toString(){
        return title;
    }
}
