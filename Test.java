package LessonOne.classwork;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("aaa",12);
        map.put("abc",14);
        map.put("aer",15);

        System.out.println(map.get("aaa"));
        System.out.println(map.get("abc"));
        map.remove("abc");
        System.out.println(map);


    }
}
