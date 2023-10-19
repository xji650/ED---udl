import java.util.*;

public class MyLinkedList<T> extends AbstractSequentialList<T> implements List<T>{

    private Node<T> header = new Node<T>(null, null, null);
    private int size = 0;

    //metodo para SortedLinkedList
    public Node<T> getHeader(){
        return header;
    }

    public MyLinkedList()
    {
        header.seguent = header.anterior = header;
    }

    public MyLinkedList(Collection<? extends T> c)
    {
        this();
        addAll(c); // aquest m√®tode l'heretem d'AbstractCollection - superclasse d'AbstractSequentialList
    }

    @Override
    public int size()
    {
        return this.size;
    }

    //metodo para SortedLinkedList
    public void incSize(){
        size++;
    }

    public ListIterator<T> listIterator(int index)
    {
        return new ListItr(index);
    }

    private T remove(Node<T> n)
    {
        if (n == header)
            throw new NoSuchElementException();
        T result = n.element;
        n.anterior.seguent = n.seguent;
        n.seguent.anterior = n.anterior;
        n.seguent = n.anterior = null;
        n.element = null;
        size--;
        return result;
    }

    private class ListItr implements ListIterator<T>
    {

        private Node<T> lastReturned = header;
        private Node<T> current;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index)
        {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException();

            current = header.seguent;

            for (nextIndex = 0; nextIndex < index; nextIndex++)
                current = current.seguent;
        }

        @Override
        public void add(T e)
        {
            lastReturned = header; //pq fem modificaci√≥ sobre la llista
            addBefore(e, current);
            nextIndex++;
        }

        private void addBefore(T e, Node<T> node)
        {
            Node<T> nouNode = new Node<T>(e, node, node.anterior);
            nouNode.anterior.seguent = nouNode;
            nouNode.seguent.anterior = nouNode;
            size++;
        }

        @Override
        public boolean hasNext()
        {
            return nextIndex != size;
        }

        @Override
        public T next()
        {
            if (nextIndex == size)
                throw new NoSuchElementException();
            lastReturned = current;
            current = current.seguent;
            nextIndex++;
            return lastReturned.element;
        }

        public void remove()
        {
            Node<T> lastNext = lastReturned.seguent;
            try
            {
                MyLinkedList.this.remove(lastReturned);
            }
            catch (NoSuchElementException e)
            {
                throw new IllegalStateException();
            }
            if (current == lastReturned) //si anem enrera
                current = lastNext;
            else
                nextIndex--;
            lastReturned = header; //pa fem modificaci√≥ sobre la llista
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex != 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            current = current.anterior;
            lastReturned = current;
            nextIndex--;
            return lastReturned.element;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex-1;
        }

        @Override
        public void set(T e) {
            if (lastReturned == header)
                throw new IllegalStateException();
            lastReturned.element = e;
        }
    }

    //seria private si no utilizo SortedLinkedList
    public static class Node<T>{
        T element;
        Node<T> seguent;
        Node<T> anterior;

        Node (T e, Node<T> next, Node<T> ant)
        {
            element = e;
            seguent = next;
            anterior = ant;
        }
    }

}

