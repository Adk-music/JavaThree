package LessonOne.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Objects {

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

        Object[] objects = new Object[10];
        for (int i = 0; i < objects.length ; i++) {
            objects[i] = i * 5;
        }

        swap(objects,0,1);
        System.out.println(Arrays.toString(objects));

        System.out.println(myList(objects));

    }

    public static void swap(Object[] objects,int first, int second){
        if(first >= 0 && first < objects.length && second >= 0 && second < objects.length){
             Object b = objects[second];
             objects[second] = objects[first];
             objects[first] = b;
        }
    }

    public static ArrayList<Object> myList(Object[] objects){
        ArrayList<Object> myList = new ArrayList<>();
        for (int i = 0; i < objects.length ; i++) {
            myList.add(objects[i]);
        }
        return myList;
    }

}
