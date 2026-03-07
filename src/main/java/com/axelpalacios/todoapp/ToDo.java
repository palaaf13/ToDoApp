package com.axelpalacios.todoapp;

public class ToDo {
    private String title;
    private String description;
    private int priority;

    public ToDo(String title, String description, int priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle(){ return title; }
    public String getDescription(){ return description; }
    public int getPriority(){ return priority; }

    @Override
    public String toString(){
        return title + " (Priority: " + priority + ")";
    }
}