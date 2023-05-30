import java.util.*;

public class RecorregutsArbresIteratius {
    public static <T> List<T> PreOrderIteratiu (BinaryTree<T> arbre)
    {

        Stack<BinaryTree<T>> pila = new Stack<BinaryTree<T>>();
        BinaryTree<T> arbreSencer, subArbreLeft, subArbreRight;
        List<T> llista = new ArrayList<T>();

        if ((arbre != null) && (!arbre.isEmpty()))
            pila.push(arbre);

        while (!pila.isEmpty())
        {
            arbreSencer = pila.pop();
            subArbreLeft = arbreSencer.getLeftCh();
            subArbreRight = arbreSencer.getRightCh();

            //segons pre-order: primer visitem el node
            llista.add(arbreSencer.getRoot());

            //primer el dret per tenir-lo al fons de la pila
            if (!subArbreRight.isEmpty())
                pila.push(subArbreRight);

            //ho fem al final per a tenir-lo al top de la pila
            if (!subArbreLeft.isEmpty())
                pila.push(subArbreLeft);
        }
        return llista;
    }

    public static <T> List<T> PostOrderIteratiu (BinaryTree<T> arbre)
    {

        Stack<BinaryTree<T>> pila = new Stack<BinaryTree<T>>();
        BinaryTree<T> arbreSencer, subArbreLeft, subArbreRight;
        List<T> llista = new ArrayList<T>();

        if ((arbre != null) && (!arbre.isEmpty()))
            pila.push(arbre);

        while (!pila.isEmpty())
        {
            arbreSencer = pila.pop();
            subArbreLeft = arbreSencer.getLeftCh();
            subArbreRight = arbreSencer.getRightCh();

            BinaryTree<T> aux = buildBinaryTree(arbreSencer.getRoot());

            if (!subArbreRight.isEmpty())
            {
                pila.push(aux);
                pila.push(subArbreRight);
            }
            else
                llista.add(arbreSencer.getRoot());

            if (!subArbreLeft.isEmpty())
                pila.push(subArbreLeft);

        }
        return llista;
    }

    public static <T> BinaryTree<T> buildBinaryTree (T root)
    {
        TreeNode<T> aux = new TreeNode(root, null, null);
        return new BinaryTree(aux);
    }

    public static <T> List<T> InOrderIteratiu(BinaryTree<T> arbre)
    {

        Stack<BinaryTree<T>> pila = new Stack<BinaryTree<T>>();
        BinaryTree<T> arbreSencer, subArbreLeft, subArbreRight;
        List<T> llista = new ArrayList<T>();

        if ((arbre != null) && (!arbre.isEmpty()))
            pila.push(arbre);

        while (!pila.isEmpty())
        {
            arbreSencer = pila.pop();
            subArbreLeft = arbreSencer.getLeftCh();
            subArbreRight = arbreSencer.getRightCh();

            BinaryTree<T> aux = buildBinaryTree(arbreSencer.getRoot());

            if (!subArbreRight.isEmpty())
                pila.push(subArbreRight);

            if (!subArbreLeft.isEmpty())
            {
                pila.push(aux);
                pila.push(subArbreLeft);
            }
            else
                llista.add(arbreSencer.getRoot());

        }
        return llista;
    }
}
