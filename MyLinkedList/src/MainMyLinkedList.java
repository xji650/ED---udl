import java.util.*;
public class MainMyLinkedList {
    public static void main(String[] args) {
        // TODO code application logic here
        MyLinkedList<String> myList = new MyLinkedList<String>();
        myList.add("Sergio");
        myList.add("Alba");
        myList.add("Teresa");

        System.out.println("Del principi al final");
        ListIterator<String> myList_Itr = myList.listIterator();

        while (myList_Itr.hasNext())
        {
            System.out.println(myList_Itr.next());
            myList_Itr.remove();
        }
        System.out.println("Estat final de la llista: " + myList);

        System.out.println("\n" + "Del final al principi");
        myList.add("Sergio");
        myList.add("Alba");
        myList.add("Teresa");
        myList_Itr = myList.listIterator(3);
        while (myList_Itr.hasPrevious())
        {
            System.out.println(myList_Itr.previous());
            myList_Itr.remove();
        }
        System.out.println("Estat final de la llista: " + myList);


    }

}
