import java.util.ListIterator;

public class MainSortedLinked {
    public static void main (String[] args){
        Llibre l1 = new Llibre(1);
        Llibre l2 = new Llibre (4);
        Llibre l3 = new Llibre (2);
        Llibre l4 = new Llibre (5);
        Llibre l5 = new Llibre (0);
        SortedLinkedList<Llibre> sl = new SortedLinkedList<Llibre>();
        sl.insert(l1);
        sl.insert(l2);
        sl.insert(l3);
        sl.insert(l4);
        sl.insert(l5);
        ListIterator<Llibre> itr = sl.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next().ISBN);
        }

    }
}
