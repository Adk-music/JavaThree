package LessonOne.classwork;
import sun.font.CreatedFontTracker;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;


public class MyHashMap<K,V> {

        private ArrayList<Node> table;
        private int initialCapacity;

        class Node{
            V value;
            K key;
            Node next;

            public Node() {
                value = null;
                key = null;
                next = null;

            }


        }

        public MyHashMap() {
            initialCapacity = 131;
            table = new ArrayList<>();
            for (int i = 0; i < initialCapacity ; i++) {
                table.add(new Node());
            }

        }

        public void put(K key, V value){
            int hash = (key.hashCode()) % initialCapacity;
            if(table.get(hash).value == null) {
                table.get(hash).value = value;
                table.get(hash).key = key;
            } else {
                Node node = table.get(hash);
                while (node.next != null){
                    node = node.next;
                }
                    node.next = new Node();
                    node.next.value = value;
                    node.next.key = key;
            }
        }

        public V get(K key){
            int hash = (key.hashCode()) % initialCapacity;
            if(table.get(hash) == null){
                return null;
            } else {
                Node node = table.get(hash);
                while (!node.key.equals(key)){
                    node = node.next;
                    if(node == null) return null;
                }
                return node.value;
            }

        }

        public void remove(K key){
            int hash = (key.hashCode()) % initialCapacity;
            if(table.get(hash) != null){
                Node node = table.get(hash);
                Node previous = null;
                while (!node.key.equals(key)) {
                    previous = node;
                    node = node.next;
                    if(node == null) return;
                }
                table.remove(hash);
                if(previous != null) {
                    previous.next = node.next;
                }
            }
        }

    @Override
    public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
        for (Node node : table) {
            if (node.value != null){
                stringBuilder.append(node.value).append("; ");
            }
        }
        return stringBuilder.toString();
    }
}

