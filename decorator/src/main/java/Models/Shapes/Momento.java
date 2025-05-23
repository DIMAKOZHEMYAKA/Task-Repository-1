package Models.Shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Momento {

    private Queue<Decorate> momentoList = new ArrayDeque<>();

    public void push(Decorate state) {
        momentoList.add(state);
    }

    public Decorate poll() {
        return momentoList.poll();
    }

    public boolean remove(Decorate state) {
        return momentoList.remove(state);
    }

    public int getSize() {
        return momentoList.size();
    }

//    public ArrayList<Decorate> getListShapes() {
//        ArrayList<Decorate> objects = new ArrayList<>();
//        for (Decorate item: momentoList){
//            objects.add(item);
//        }
//        return objects;
//    }


    public Queue<Decorate> getMomentoList() {
        return momentoList;
    }
}