package com.example.task_6;


import com.example.task_6.Shapes.Shape;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Momento {

    private Queue<Shape> momentoList = new ArrayDeque<>();


    public void push(Shape state) {

        momentoList.add(state);
    }

    public Shape poll() {

        return momentoList.poll();

    }

    public int getSize() {
        return momentoList.size();
    }

    public ArrayList<Shape> getListShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        for (Shape item: momentoList){
            shapes.add(item);
        }
        return shapes;
    }

}