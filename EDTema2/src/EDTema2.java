import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EDTema2 {
    public static void main(String[] args) {
        Persona p1 = new Persona (20);
        Persona p2;
        Persona p3;
        p2 = p1;
        p3 = p1;
        p3.edad = 38;
        System.out.println(p1.edad);//38

        //ejemplo de herencia y creación de objetos
        System.out.println("Se crearán dos objetos, el padre, y el hijo");
        Cuadrado cuadrado = new Cuadrado();

        //ejemplo conversión de tipo
        System.out.println("Ahora se crea una Figura con ID = 0");
        Figura fg = new Figura();
        System.out.println(fg.id);
        System.out.println("Ahora creo un Cuadrado");
        Cuadrado c = new Cuadrado ();
        fg = (Figura)c;
        System.out.println(fg.id);
        // no puedo hacer fg.lado, porque lado es de cuadrado

        ejemploUsoInterfaces();

        //ejemplo genéricos y comodines
        List<Engineer> l = new ArrayList<Engineer>();
        List <ReqEngineer> lr = new LinkedList<ReqEngineer>();
        l.add(new Engineer());
        lr.add(new ReqEngineer());
        copy (l, lr);
    }
    public static void ejemploUsoInterfaces(){
        BubbleSort bs = new BubbleSort();
        QuickSort qs = new QuickSort();
        aplicaAlgoritmo(bs);
        aplicaAlgoritmo(qs);
    }

    public static void aplicaAlgoritmo(Algoritmo a){
        a.ordena();
    }

    //ejemplo uso genéricos con comodines
    public static void copy (List<? super Engineer> dest, List<? extends Engineer> src){
        dest.add(src.get(0));
    }
}

