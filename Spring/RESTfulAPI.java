package Spring;


import java.util.*;

class Book{
    private int id;

    public int getId(){
        return id;
    }

}



public class RESTfulAPI {
    public static void main(String[] args){
        List<Book> books = new ArrayList<Book>();

        books.removeIf(book->book.getId() == 1);
    }
}
