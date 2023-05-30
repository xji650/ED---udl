import java.util.*;

public interface BinarySearchTreeInterface <T> extends Collection<T>{

    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c); //no fa falta
    boolean equals(Object o);
    Iterator<T> iterator();
    Object[] toArray();
    boolean isEmpty();

    public void insert(T x);
    public void eliminate(T x);
    public TreeNode<T> findMin();
    public TreeNode<T> findMax();
    int size(TreeNode<T> tn);


    public T getRoot();
    public int height(TreeNode<T> tn);
    public int getSize();
    public BinarySearchTreeIterator<T> iteratorIn();
}

