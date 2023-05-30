/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author Sergio Sayago, based on Josep m. Ribó
 * @param <T>
 */

/*Podem veure el nostre arbre com a part de la JCF. Per això
fem hereti de la classe abstracta AbstractCollection. Si us fixeu,
totes les collections del JCF hereten d'aquesta classe. Típicament,
fem que el nostre arbre implementi una interfície, que a la seua vegada
extén la interfície Collection - és una pràctica de disseny POO.*/

public class BinaryTree<T> extends AbstractCollection<T> 
                           implements BinaryTreeInterface<T> {

    private TreeNode<T> root;
    int tamany;
    
    public BinaryTree(){
       root = null;
       tamany = 0;
    }
    
    public BinaryTree (T element, BinaryTree<T> leftSubTree, BinaryTree<T> rightSubTree)
    {
        root = new TreeNode(element, null, null);
        int leftS = 0;
        int rightS = 0;
        
        if (leftSubTree != null)
        {
            root.left = leftSubTree.root;
            leftS = leftSubTree.getSize();
        }
        else
            root.left = null;
        
        if (rightSubTree != null)
        {
            root.right = rightSubTree.root;
            rightS = rightSubTree.getSize();
        }
        else
            root.right = null;
        
        tamany = leftS + rightS + 1; 
    }
    
    //aquest constructor el necessitem per als mètodes getLeft i getRighChildren
    public BinaryTree(TreeNode<T> tn){ //abans era privat
       this.root = tn;
       this.tamany = size(tn);
    }    
    
    @Override
    public boolean isEmpty()
    {
        return tamany == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new PreBinTreeItr();
    }

    @Override
    public int size(TreeNode<T> t) {
         if (t == null)
             return 0;
         else
             return 1 + size (t.left) + size (t.right);
    }

    @Override
    public BinaryTree<T> getLeftCh() {
        if (root == null) throw new NoSuchElementException();
       return new BinaryTree<T>(root.left);

    }

    @Override
    public BinaryTree<T> getRightCh() {
        if (root == null) throw new NoSuchElementException();
       return new BinaryTree<T>(root.right);

    }

    @Override
    public T getRoot() {
       if (root == null) throw new NoSuchElementException();       
       return root.element;
    }

    @Override
    public int height(TreeNode<T> tn) {
        if (tn == null)
            return -1;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    @Override
    public int getSize() {
        return tamany; 
    }

    @Override
    public BinaryTreeIterator<T> iteratorPre() {
       return new PreBinTreeItr();
    }

    @Override
    public BinaryTreeIterator<T> iteratorIn() {
        return new InBinTreeItr();
    }

    @Override
    public BinaryTreeIterator<T> iteratorPost() {
        return new PostBinTreeItr();
    }

    @Override
    public BinaryTreeIterator<T> iteratorLevels() {
        return new PreBinTreeItr(); //BreathBinTreeItr();
    }

    @Override
    public void removeLeftCh() {
        if (root.left != null){
          tamany  = size(root.right) + 1;
          root.left = null;
       }
    }

    @Override
    public void removeRightCh() {
        if (root.right != null){
          tamany  = size(root.left) + 1;
          root.right = null;
       }
    }        

    @Override
    public int size() {
        return tamany;
    }
    
    @Override
    public void clear(){
        root = null;
        tamany = 0;
    }
    
    @Override
    public boolean contains(Object o)
    {
        return containsRec(root, o);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        else
        {
            BinaryTree<T> aux = (BinaryTree<T>)o;
            return equalsRec(this.root, aux.root);
        }        
    }
    
    private boolean equalsRec (TreeNode<T> tn1, TreeNode<T> tn2)
    {
        if ((tn1 == null) || (tn2 == null))
            return tn1 == tn2;
        
        return (tn1.element.equals(tn2.element) &&
                equalsRec(tn1.left, tn2.left) &&
                equalsRec(tn1.right, tn2.right));
        //return equalsIte(tn1,tn2);
    }

    //pregunta segon parcial

    private boolean equalsIte(TreeNode<T> tn1, TreeNode<T> tn2)
    {
        boolean sonIguals = true;
        Stack<TreeNode<T>> pila = new Stack<TreeNode<T>>();
        TreeNode<T> ta,tb;

        if ((tn1 == null) || (tn2 == null))
            sonIguals =  (tn1 == tn2);

        if (tn1.element.equals(tn2.element)) {
            if (tn1.left != null)
                pila.push(tn1.left);
            if (tn2.left != null)
                pila.push(tn2.left);
            if (tn1.right != null)
                pila.push(tn1.right);
            if (tn2.right != null)
                pila.push(tn2.right);
            while (!pila.empty() && sonIguals) {
                ta = pila.pop();
                tb = pila.pop();
                if ((ta.element.equals(tb.element))) {
                    if (ta.left != null)
                        pila.push(ta.left);
                    if (tb.left != null)
                        pila.push(tb.left);
                    if (ta.right != null)
                        pila.push(ta.right);
                    if (tb.right != null)
                        pila.push(tb.right);
                }
                else
                    sonIguals = false;
            }
        }
        else
               sonIguals = false;

        return sonIguals;
    }
    private boolean containsRec(TreeNode<T> arrel, Object buscar)
    {
        if (arrel == null) return false;
        else
            return arrel.element.equals(buscar) || 
                    containsRec(arrel.left, buscar) ||
                    containsRec (arrel.right, buscar);
    }
    
    private class PreBinTreeItr implements BinaryTreeIterator<T>
    {
       List<TreeNode<T>> listTree;
       ListIterator<TreeNode<T>> it;
       TreeNode<T> lastReturned;
       
       PreBinTreeItr()
       {
          lastReturned = null; 
          listTree = preorder(BinaryTree.this.root);
          it = listTree.listIterator();
       }
       
       private List<TreeNode<T>> preorder(TreeNode<T> tn)
       {
           List<TreeNode<T>> lis = new ArrayList<TreeNode<T>>();         
           
           if (tn != null)
           {
               lis.add(tn);
               lis.addAll(preorder(tn.left));
               lis.addAll(preorder(tn.right));
         }
        return lis;
       }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            lastReturned = it.next();
            return lastReturned.element;
        }

        @Override
        public void set(T o) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.element = (T) o;
        }
        
    }
    
    private class InBinTreeItr implements BinaryTreeIterator<T>
    {
       List<TreeNode<T>> listTree;
       ListIterator<TreeNode<T>> it;
       TreeNode<T> lastReturned;
       
       InBinTreeItr()
       {
          lastReturned = null; 
          listTree = inorder(BinaryTree.this.root);
          it = listTree.listIterator();
       }
       
       private List<TreeNode<T>> inorder(TreeNode<T> tn)
       {
           List<TreeNode<T>> lis = new ArrayList<TreeNode<T>>();         
           
           if (tn != null)
           {
               lis.addAll(inorder(tn.left));
               lis.add(tn);
               lis.addAll(inorder(tn.right));
         }
        return lis;
       }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            lastReturned = it.next();
            return lastReturned.element;
        }

        @Override
        public void set(T o) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.element = (T) o;
        }
        
    }
    
    private class PostBinTreeItr implements BinaryTreeIterator<T>
    {
       List<TreeNode<T>> listTree;
       ListIterator<TreeNode<T>> it;
       TreeNode<T> lastReturned;
       
       PostBinTreeItr()
       {
          lastReturned = null; 
          listTree = postorder(BinaryTree.this.root);
          it = listTree.listIterator();
       }
       
       private List<TreeNode<T>> postorder(TreeNode<T> tn)
       {
           List<TreeNode<T>> lis = new ArrayList<TreeNode<T>>();         
           
           if (tn != null)
           {
               lis.addAll(postorder(tn.left));               
               lis.addAll(postorder(tn.right));
               lis.add(tn);
         }
        return lis;
       }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            lastReturned = it.next();
            return lastReturned.element;
        }

        @Override
        public void set(T o) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.element = (T) o;
        }
        
    }
}
