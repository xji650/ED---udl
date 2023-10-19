import java.util.ListIterator;

public class SortedLinkedList<T extends Comparable> extends MyLinkedList<T> {
    public SortedLinkedList(){
        super();
    }
    public void insert(T x) {
        Node<T> current = getHeader().seguent;
        while (current.element != null && current.element.compareTo(x) < 0){
            current = current.seguent;
        }
        addBefore(x, current);
    }
    private void addBefore(T e, Node<T> node)
    {
        Node<T> nouNode = new Node<T>(e, node, node.anterior);
        nouNode.anterior.seguent = nouNode;
        nouNode.seguent.anterior = nouNode;
        super.incSize();
    }
}
