package com.axelpalacios.todoapp;

import java.util.ArrayList;

public class MyPriorityQueue {
    private ArrayList<ToDo> heap = new ArrayList<>();

    public void insert(ToDo task){
        heap.add(task);
        heap.sort((a,b)->a.getPriority()-b.getPriority());
    }

    public ToDo remove(){
        if(heap.isEmpty()) return null;
        return heap.remove(0);
    }

    public ToDo peek(){
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    public ArrayList<ToDo> getAll(){
        return heap;
    }
}
