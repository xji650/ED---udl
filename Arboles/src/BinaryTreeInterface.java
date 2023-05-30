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

/*Recordeu que una interfície pot extendre a una altre interfície. Això es fa
quan volem afegir mètodes, que s'implementaràn a la clase. Parlem de
subinterfície.*/

public interface BinaryTreeInterface<T> extends Collection<T> {
   void clear();
   boolean contains(Object o);
   boolean containsAll(Collection<?> c); //no fa falta
   boolean equals(Object o);
   BinaryTree<T> getLeftCh();
   BinaryTree<T> getRightCh();
   T getRoot();
   int height(TreeNode<T> tn);
   boolean isEmpty();
   int getSize();
   Iterator<T> iterator();
   BinaryTreeIterator<T> iteratorPre();
   BinaryTreeIterator<T> iteratorIn();
   BinaryTreeIterator<T> iteratorPost();
   BinaryTreeIterator<T> iteratorLevels();
   void removeLeftCh();
   void removeRightCh();
   int size(TreeNode<T> tn);
   Object[] toArray(); //no fa falta 
    
}
