import java.util.*;
public class EDP3 {
    public static void main(String[] args) {

        test_binarytree_1(); //afegir, consultar, i eliminar
        test_binarytree_2(); //recorreguts implementats recursivament
        test_binarytree_3(); //equals i contains recursius
        test_binarytree_4(); //recorreguts implementats iterativament

    }

    public static void test_binarytree_4()
    {
        BinaryTree<String> x6 = new BinaryTree("X6", null, null);
        BinaryTree<String> x7 = new BinaryTree("X7", null, null);
        BinaryTree<String> x8 = new BinaryTree("X8", null, null);
        BinaryTree<String> x4 = new BinaryTree("X4", null, null);
        BinaryTree<String> x5 = new BinaryTree("X5", x6, x7);
        BinaryTree<String> x3 = new BinaryTree("X3", x8, x5);
        BinaryTree<String> x2 = new BinaryTree("X2", null, x4);
        BinaryTree<String> x1 = new BinaryTree("X1", x2, x3);

        System.out.println("PRE:iteratiu" + "\n");
        List<String> list_pre = RecorregutsArbresIteratius.PreOrderIteratiu(x1);
        ListIterator<String> it = list_pre.listIterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\n" + "POST:iteratiu");
        List<String> list_post = RecorregutsArbresIteratius.PostOrderIteratiu(x1);
        ListIterator<String> it_post = list_post.listIterator();
        while (it_post.hasNext())
            System.out.println(it_post.next());

        System.out.println("\n" + "IN:iteratiu");
        List<String> list_in = RecorregutsArbresIteratius.InOrderIteratiu(x1);
        ListIterator<String> it_in = list_in.listIterator();
        while (it_in.hasNext())
            System.out.println(it_in.next());

    }
    public static void test_binarytree_3()
    {
        BinaryTree<String> x6 = new BinaryTree("X6", null, null);
        BinaryTree<String> x7 = new BinaryTree("X7", null, null);
        BinaryTree<String> x8 = new BinaryTree("X8", null, null);
        BinaryTree<String> x4 = new BinaryTree("X4", null, null);
        BinaryTree<String> x5 = new BinaryTree("X5", x6, x7);
        BinaryTree<String> x3 = new BinaryTree("X3", x8, x5);
        BinaryTree<String> x2 = new BinaryTree("X2", null, x4);
        BinaryTree<String> x1 = new BinaryTree("X1", x2, x3);

        boolean aux = x1.contains("X4"); //hauria de ser true
        boolean aux_2 = x1.equals(x1);//hauria de ser true
        boolean aux_3 = x1.equals(x3); //hauria de ser false
    }

    public static void test_binarytree_2()
    {
        BinaryTree<String> x6 = new BinaryTree("X6", null, null);
        BinaryTree<String> x7 = new BinaryTree("X7", null, null);
        BinaryTree<String> x8 = new BinaryTree("X8", null, null);
        BinaryTree<String> x4 = new BinaryTree("X4", null, null);
        BinaryTree<String> x5 = new BinaryTree("X5", x6, x7);
        BinaryTree<String> x3 = new BinaryTree("X3", x8, x5);
        BinaryTree<String> x2 = new BinaryTree("X2", null, x4);
        BinaryTree<String> x1 = new BinaryTree("X1", x2, x3);

        BinaryTreeIterator<String> it_pre = x1.iteratorPre();
        BinaryTreeIterator<String> it_in = x1.iteratorIn();
        BinaryTreeIterator<String> it_post = x1.iteratorPost();

        System.out.println("Recorregut en pre-order" + "\n");
        while (it_pre.hasNext())
            System.out.println(it_pre.next());

        System.out.println("Recorregut en inorder" + "\n");
        while (it_in.hasNext())
            System.out.println(it_in.next());

        System.out.println("Recorregut en post-order" + "\n");
        while (it_post.hasNext())
            System.out.println(it_post.next());

    }
    public static void test_binarytree_1()
    {
        BinaryTree<String> Fulla1 = new BinaryTree("Fulla 1", null, null);
        BinaryTree<String> Fulla2 = new BinaryTree("Fulla 2", null, null);
        BinaryTree<String> Fulla3 = new BinaryTree("Fulla 3", null, null);
        BinaryTree<String> Fulla4 = new BinaryTree("Fulla 4", null, null);

        BinaryTree<String> PrimerNode = new BinaryTree("PrimerNode", Fulla1, Fulla2);
        BinaryTree<String> SegonNode = new BinaryTree("SegonNode", Fulla3, Fulla4);

        BinaryTree<String> PareDeTots = new BinaryTree("Pare", PrimerNode, SegonNode);

        BinaryTree<String> FillEsquerrePareDeTots = PareDeTots.getLeftCh();
        BinaryTree<String> FillDretPareDeTots = PareDeTots.getRightCh();

        PareDeTots.removeLeftCh();
        PareDeTots.removeRightCh();


    }
}
