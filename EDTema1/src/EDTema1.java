import java.io.*;

public class EDTema1 {
    public static void main(String[] args) {
        // TODO code application logic here
        int [] seq = initSortedSequence();

        //linearSearch(seq,99);
        //binarySearch (seq,99);

        linearSearch(seq,49);
        binarySearch (seq,49);
    }

    public static int [] initSortedSequence()
    {
        int [] a = new int [100];

        for (int i = 0; i < a.length; i++)
        {
            a [i] = i;
        }
        return a;

    }
    public static void linearSearch(int [] sequence, int target)
    {
        int numComp = 0;
        boolean trobat = false;
        int i = 0;

        while (i < sequence.length && trobat == false)
        {
            numComp += 1;
            if (sequence[i] == target)
            {
                trobat = true;
            }
            else
            {
                i++;
            }
        }

        System.out.println("Resultats búsqueda lineal en array ordenat: target: "+ target);
        System.out.println("Element trobat a la posició: " + i);
        System.out.println ("Numero de comparacions: " + numComp);
        System.out.println("Solució de temps lineal");
        System.out.println("----");
    }

    public static void binarySearch (int [] sequence, int target)
    {
        int low = 0;
        int high = sequence.length - 1;
        int mid = -1;
        int numComp = 0;
        boolean trobat = false;

        while (low <= high && trobat == false)
        {
            numComp += 1;
            mid = (low + high) / 2;

            if (sequence[mid] < target)
            {
                low = mid +1;
            }
            else if (sequence[mid] > target)
                high = mid - 1;
            else
                trobat = true;
        }

        System.out.println("Resultats búsqueda binaria en array ordenat: target: " + target);
        System.out.println("Element trobat a la posició: " + mid);
        System.out.println ("Numero de comparacions: " + numComp);
        System.out.println("Solució de temps logarítmic: O(logN)");
        System.out.println("----");
    }

}

