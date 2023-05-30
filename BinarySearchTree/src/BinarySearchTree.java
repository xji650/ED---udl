import java.util.*;

public class BinarySearchTree <T extends Comparable<? super T>>
        extends AbstractCollection<T>
        implements BinarySearchTreeInterface<T>{

    private TreeNode<T> root;
    int tamany;

    public BinarySearchTree(){
        root = null;
        tamany = 0;
    }

    public BinarySearchTree (T element, BinarySearchTree<T> leftSubTree, BinarySearchTree<T> rightSubTree)
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

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return tamany;
    }

    @Override
    public int size(TreeNode<T> tn) {
        if (tn == null)
            return 0;
        else
            return 1 + size (tn.left) + size (tn.right);
    }

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
            BinarySearchTree<T> aux = (BinarySearchTree<T>)o;
            return equalsRec(this.root, aux.root);
        }
    }

    @Override
    public void insert(T x) {
        root = insert(x, root);
        tamany++;
    }

    @Override
    public void eliminate(T x) {
        root = eliminate (x, root);
        tamany--;
    }

    @Override
    public TreeNode<T> findMin() {
        return ifindMin(root);
    }

    @Override
    public TreeNode<T> findMax() {
        return ifindMax(root);
    }

    @Override
    public T getRoot() {
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
        return this.tamany;
    }

    @Override
    public boolean isEmpty()
    {
        return tamany == 0;
    }

    @Override
    public BinarySearchTreeIterator<T> iteratorIn() {
        return new InBinTreeItr();
    }

    //Operacions privades BST

    private TreeNode<T> ifindMin(TreeNode<T> tn)
    {
        /*if (tn != null)
        {
            while (tn.left != null)
                tn = tn.left;
            return tn;
        }
        else
            throw new IllegalStateException();*/
        if (tn.left == null)
            return tn;
        else
            return ifindMin(tn.left);
    }

    private TreeNode<T> ifindMax (TreeNode<T> tn)
    {
        if (tn != null)
        {
            while (tn.right != null)
                tn = tn.right;
            return tn;
        }
        else
            throw new IllegalStateException();
    }

    private TreeNode<T> insert (T element, TreeNode<T> tn)
    {
        if (tn == null)
            tn = new TreeNode(element, null, null);
        else if (element.compareTo(tn.element) < 0)
            tn.left = insert (element, tn.left);
        else if (element.compareTo(tn.element) > 0)
            tn.right = insert (element, tn.right);
        else
            throw new IllegalStateException(); // duplicat
        return tn;
    }

    //Operacions privades d'arbres i iterator

    private TreeNode<T> eliminate (T element, TreeNode<T> tn)
    {
        if (tn == null)
            throw new IllegalStateException();
        if (element.compareTo(tn.element) < 0)
            tn.left = eliminate(element, tn.left);
        else if (element.compareTo(tn.element) > 0)
            tn.right = eliminate (element, tn.right);
        else if (tn.left != null && tn.right != null) // dos fills
        {
            tn.element = ifindMin(tn.right).element;
            tn.right = eliminateMin(tn.right);
        }
        else
            tn = (tn.left != null) ? tn.left : tn.right; //fulla o un fill
        return tn;
    }

    private TreeNode<T> eliminateMin (TreeNode<T> tn)
    {
        if (tn == null)
            throw new IllegalStateException();
        else if (tn.left != null)
        {
            tn.left = eliminateMin(tn.left);
            return tn;
        }
        else
            return tn.right;
    }

    private boolean containsRec(TreeNode<T> arrel, Object buscar)
    {
        if (arrel == null) return false;
        else
            return arrel.element.equals(buscar) ||
                    containsRec(arrel.left, buscar) ||
                    containsRec (arrel.right, buscar);
    }

    private boolean equalsRec (TreeNode<T> tn1, TreeNode<T> tn2)
    {
        if ((tn1 == null) && (tn2 == null))
            return tn1 == tn2;

        return (tn1.element.equals(tn2.element) &&
                equalsRec(tn1.left, tn2.left) &&
                equalsRec(tn1.right, tn2.right));
    }

    //recorregut inorder a un BST retorna els elements en ordre (de més
    //petit a més gran)
    private class InBinTreeItr implements BinarySearchTreeIterator<T>
    {
        List<TreeNode<T>> listTree;
        ListIterator<TreeNode<T>> it;
        TreeNode<T> lastReturned;

        InBinTreeItr()
        {
            lastReturned = null;
            listTree = inorder(BinarySearchTree.this.root);
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
}

