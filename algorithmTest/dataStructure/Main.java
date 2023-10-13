package dataStructure;


public class Main {
    public static void main(String[] args) throws Exception{
        

        arrayListTest();
        // singleLinkedListTest();

       
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
