package Models.Shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Momento {

    private Queue<Object> momentoList = new ArrayDeque<>();

    public void push(Object state) {
        momentoList.add(state);
    }

    public Object poll() {
        return momentoList.poll();
    }

    public boolean remove(Object state) {
        return momentoList.remove(state);
    }

    public int getSize() {
        return momentoList.size();
    }

    public ArrayList<Object> getListShapes() {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object item: momentoList){
            objects.add(item);
        }
        return objects;
    }

}