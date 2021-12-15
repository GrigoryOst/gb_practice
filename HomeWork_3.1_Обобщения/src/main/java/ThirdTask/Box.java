package ThirdTask;

import java.util.ArrayList;
import java.util.Arrays;

class Box<T extends Fruits> {

    ArrayList<T> box = new ArrayList();

    public Box(T... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    void info() {
        if (box.isEmpty()) {
            System.out.println("Empty box");
        } else  {
            System.out.println("In the box are: " + box.get(0).toString() + " number: " + box.size());
        }
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            totalWeight = totalWeight + box.get(i).getWeight();
        }
        return totalWeight;
    }

    boolean compare (Box<? extends Fruits> box) {
        return this.getWeight() == box.getWeight();
    }

    public void replace (Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }
}
