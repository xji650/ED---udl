public class ED4{
    public static void main(String[] args) {

    Persona p111 = new Persona("Sergio", "111");
    Persona p222 = new Persona("Isabel", "222");
    Persona p333 = new Persona("Magda", "333");
    Persona p555 = new Persona("Ramon", "555");
    Persona p777 = new Persona("Toni", "777");
    Persona p999 = new Persona("Alba", "999");

    //test insert
    BinarySearchTree<Persona> bst = new BinarySearchTree(p777,null,null);
    bst.insert(p222);
    bst.insert(p999);
    bst.insert(p111);
    bst.insert(p555);
    bst.insert(p333);

    //test iterador en inorde = hauria de donar resultat de mes petit a mes gran
    BinarySearchTreeIterator<Persona> bst_it = bst.iteratorIn();
    while (bst_it.hasNext())
        System.out.println(bst_it.next());

    //test mètodes Min i Max
    TreeNode<Persona> tmax = bst.findMax();
    TreeNode<Persona> tmin = bst.findMin();

    System.out.println("\n" + "Persona amb DNI més petit: " + tmin.element.toString());
    System.out.println("\n" + "Persona amb DNI més gran: " + tmax.element.toString());

    System.out.println("\n" + "Mida del BST: " + bst.getSize());

    //test metodes eliminar
    bst.eliminate(p777);
    bst.eliminate(p999);

    System.out.println("\n" + "Mida després d'eliminar dos persones: " + bst.getSize());

    BinarySearchTreeIterator<Persona> bst_it2 = bst.iteratorIn();
    while (bst_it2.hasNext())
          System.out.println(bst_it2.next());

    bst.eliminate(p555);
    System.out.println("\n" + "Mida després d'eliminar tres persones: " + bst.getSize());

    BinarySearchTreeIterator<Persona> bst_it3 = bst.iteratorIn();
    while (bst_it3.hasNext())
        System.out.println(bst_it3.next());

    bst.eliminate(p222);
    System.out.println("\n" + "Mida després d'eliminar cuatre persones: " + bst.getSize());

    //test
    Persona T777 = new Persona("Sergio", "777");
    Persona T222 = new Persona("Sergiob", "222");
    Persona T111 = new Persona("Sergioc", "111");
    Persona T555 = new Persona("Sergiod", "555");
    Persona T333 = new Persona("Sergioe", "333");
    Persona T444 = new Persona("Sergiof", "444");
    Persona T999 = new Persona("Sergiog", "999");

    BinarySearchTree<Persona> bt = new BinarySearchTree(T777,null,null);

    bt.insert(T222);
    bt.insert(T999);
    bt.insert(T111);
    bt.insert(T555);
    bt.insert(T333);
    bt.insert(T444);

    bt.eliminate(T222);

    }

}

