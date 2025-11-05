package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        items =  new ArrayList<>();
    }

    public void add(T item){
        if(items.size()<maxSize){
            items.add(item);
        }
    }

    public List<T> getItems(){
        return items;
    }

    public void displayItems(){
        for (T item:items){
            System.out.println(item);
        }
    }
}
