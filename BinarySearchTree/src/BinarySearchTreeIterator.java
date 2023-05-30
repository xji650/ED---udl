import java.util.*;

public interface BinarySearchTreeIterator <T> extends Iterator<T> {
    boolean hasNext();
    T next();
    void set(T o);
}
