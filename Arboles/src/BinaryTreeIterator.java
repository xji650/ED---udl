/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author Sergio Sayago
 * @param <T>
 */
public interface BinaryTreeIterator<T> extends Iterator<T>{
    boolean hasNext();
    T next();
    void set(T o);
}
