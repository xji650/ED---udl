import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MevaHashMap<String, Integer> mapa = new MevaHashMap<>();
        mapa.put("Smith", 30);
        mapa.put("Anderson", 31);
        mapa.put("Lewis", 29);
        mapa.put("Cook", 29);
        mapa.put("Smith", 65);

        System.out.println("Edat de Lewis: " + mapa.get("Lewis")); //29
        System.out.println("Hi és Anderson a la taula de hash? " + mapa.teClau("Anderson")); //true
        System.out.println("Tenim edat 33 a la taula de hash? " + mapa.teValor(33)); //false

        mapa.eliminar("Smith"); //OK
        System.out.println("Hi és Smith a la taula de hash? " + mapa.teClau("Smith")); //false

    }
}