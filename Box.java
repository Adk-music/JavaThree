package LessonOne.homework;

import java.util.ArrayList;

public class Box <Type extends Fruit>  {


   private ArrayList<Type> fruits = new ArrayList<>();

   public void addFruit(Type fruit){
       fruits.add(fruit);
   }

   public float getWeight(){
       float sum = 0;
       for(Type fruit : fruits){
           sum += fruit.getWeight();
       }
       return sum;
   }

   public boolean compare(Box<? extends Fruit> otherBox){
      return this.getWeight() == otherBox.getWeight();
   }

   public void fruitTransfer(Box<Type> otherBox){
     for (Type fruit :this.fruits){
         otherBox.addFruit(fruit);
     }
     this.fruits.clear();
   }


    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
