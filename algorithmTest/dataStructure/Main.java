package dataStructure;


import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        // arrayListTest();
        // singleLinkedListTest();
        // doubleLinkedListTest();
        // stack();

        // priortyQueue();

    }
    
    public static void priortyQueue(){
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<Integer>();
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());


        priorityQueueLowest.offer(1);
        priorityQueueLowest.offer(2);
        priorityQueueLowest.offer(3);
        priorityQueueLowest.offer(4);
        int size = priorityQueueLowest.size();

        for (int i=0; i<size; i++)
            System.out.println(priorityQueueLowest.poll());
        
        priorityQueueHighest.offer(1);
        priorityQueueHighest.offer(2);
        priorityQueueHighest.offer(3);
        size = priorityQueueHighest.size();
        for (int i=0; i<size; i++)
            System.out.println(priorityQueueHighest.poll());




    }

    public static void stack() throws CloneNotSupportedException{
        Stack<Integer> original = new Stack<Integer>();
        original.push(10);

        Stack<Integer> copy = original;
        Stack<Integer> clone = (Stack<Integer>) original.clone();

        System.out.println("original Stack");
        int i = 0;
        for (Object a : original.toArray()){
            System.out.println("index " + i + " data  = " + a);
            i ++;
        }
        
        copy.push(30);
        System.out.println("\ncopy Stack");
        i = 0;
        for (Object a : copy.toArray()){
            System.out.println("index " + i + " data = " + a);
            i++;
        }


        System.out.println("\nclone Stack");
        i = 0;
        for (Object a : clone.toArray()){
            System.out.println("index " + i + " data = " + a);
            i++;
        }

        System.out.println("\noriginal stack reference : " + original);
        System.out.println("copy stack reference : " + copy);
        System.out.println("clone stack reference : " + clone);

    }



    public static void doubleLinkedListTest() throws CloneNotSupportedException{
        DoubleLinkedList<Integer> original = new DoubleLinkedList<>();
        original.add(10);

        DoubleLinkedList<Integer> copy = original;

        copy.add(30);
        System.out.println("original list");
        for (int i=0; i<original.size(); i++){
            System.out.println("index " + i + " data = " + original.get(i));
        }

        System.out.println("copy list");
        for (int i=0; i<copy.size(); i++){
            System.out.println("index " + i + " data = " + copy.get(i));
        }

        System.out.println("original list reference : " + original);
        System.out.println("copy list reference : " + copy);

    }


    public static void singleLinkedListTest() throws CloneNotSupportedException{
        SingleLinkedList<Integer> original = new SingleLinkedList<Integer>();
        original.add(10);

        SingleLinkedList<Integer> copy = original;
        @SuppressWarnings("unchecked")
        SingleLinkedList<Integer> clone = (SingleLinkedList<Integer>) original.clone();

        copy.add(20);
        clone.add(30);
        
        System.out.println("original list");
        for (int i=0; i<original.size(); i++)
            System.out.println("index " + i + " data = " + original.get(i));

        System.out.println("\ncopy list");
        for(int i=0; i<copy.size(); i++)
            System.out.println("index " + i + " data = " + original.get(i));

        System.out.println("\nclone list");
        for(int i=0; i<clone.size(); i++)
            System.out.println("index " + i + " data = " + clone.get(i));

        
        System.out.println("\noriginal list reference : " + original);
        System.out.println("copy list reference : " + copy);
        System.out.println("clone list reference : " + clone);
    
    }

    public static void arrayListTest() throws CloneNotSupportedException{
        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(10);

        ArrayList<Integer> copy = original;
        ArrayList<Integer> clone = (ArrayList<Integer>) original.clone();

        copy.add(20);
        clone.add(30);


        System.out.println("original list");
        for(int i=0; i<original.size(); i++)
            System.out.println("index " + i + " data = " + original.get(i));

        System.out.println("\ncopy list");
        for(int i=0; i<copy.size(); i++)
            System.out.println("index " + i + " data = " + copy.get(i));

        System.out.println("\nclone list");
        for(int i=0; i<clone.size(); i++)
            System.out.println("index " + i + " data = " + clone.get(i));

        System.out.println("\noriginal list reference : " + original);
        System.out.println("copy list reference : " + copy);
        System.out.println("clone list reference : " + clone);
    }



}
