package LessonOne.homework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 10 ; i++) {
            appleBox.addFruit(new Apple());
            orangeBox.addFruit(new Orange());
            orangeBox2.addFruit(new Orange());
        }

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox.compare(orangeBox2));
        orangeBox.fruitTransfer(orangeBox2);
        System.out.println(orangeBox2.getWeight());


    }

}
