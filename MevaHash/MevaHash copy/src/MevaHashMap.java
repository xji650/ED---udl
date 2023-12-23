import java.util.*;

public class MevaHashMap<K, V> implements MeuMap<K,V> {
    private static int MIDA_INICIAL = 4;
    private static int CAPACITAT_MAX = 1<<30;
    private int capacitat;
    private static float FACTOR_CARREGA = 0.75f;
    private int size = 0;

    //completar
    //private LinkedList<????>[] taula;
    
    public MevaHashMap(){
        this (MIDA_INICIAL);
    }
    public MevaHashMap(int capacitatInicial){
        if (capacitatInicial > CAPACITAT_MAX)
            this.capacitat = CAPACITAT_MAX;
        else
            this.capacitat = capacitatInicial; // ha de ser potencia de 2
        taula = new LinkedList[capacitat]; 
    }
    @Override
    public void buidar() {
        size = 0;
        esborrarEntrades();
    }

    @Override
    public boolean teClau(K key) {
        //escriu el vostre codi aqui
    }

    @Override
    public boolean teValor(V value) {
        //escriu el vostre codi aqui
    }
    @Override
    public Set<Entrada<K, V>> entrySet() {
        java.util.Set<MeuMap.Entrada<K,V>> set = new java.util.HashSet<>();
        for (int i = 0; i < capacitat; i++){
            if (taula[i] != null){
                LinkedList<MeuMap.Entrada<K, V>> cubo = taula[i];
                ListIterator<MeuMap.Entrada<K, V>> itr = cubo.listIterator();
                while (itr.hasNext()){
                    set.add(itr.next());
                }
            }
        }
        return set;
    }

    @Override
    public V get(K key) {
        //escriu el vostre codi aquí
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        java.util.Set<K> set = new java.util.HashSet<K>();
        for (int i = 0; i < capacitat; i++){
            if (taula[i] != null){
                LinkedList<MeuMap.Entrada<K,V>> cubo = taula[i];
                ListIterator<MeuMap.Entrada<K,V>> itr = cubo.listIterator();
                while (itr.hasNext()){
                    Entrada<K,V> entrada = itr.next();
                    set.add(entrada.getKey());
                }
            }
            return set;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        //escriu el vostre codi aqui
    }

    @Override
    public void eliminar(K key) {
        int index = hash (key.hashCode());
        if (taula[index] != null){
            LinkedList<MeuMap.Entrada<K,V>> cubo = taula[index];
            ListIterator<MeuMap.Entrada<K,V>> itr = cubo.listIterator();
            while (itr.hasNext()){
                Entrada<K,V> entrada = itr.next();
                if (entrada.getKey().equals(key)){
                    cubo.remove(entrada);
                    size--;
                    break;
                }
            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {
        java.util.Set<V> set = new java.util.HashSet<V>();
        for (int i = 0; i < capacitat; i++){
            if (taula[i] != null){
                LinkedList<MeuMap.Entrada<K,V>> cubo = taula[i];
                ListIterator<MeuMap.Entrada<K, V>> itr = cubo.listIterator();
                while (itr.hasNext())
                    set.add(itr.next().getValue());
            }
        }
        return set;
    }

    private int hash(int hashCode){
        return funcioHash(hashCode) & (capacitat -1);
    }

    private static int funcioHash(int h){
        h ^= (h >>> 20) ^(h >>> 12);
        return h ^(h >>> 7) ^(h >>> 4);
    }

    private void esborrarEntrades(){
        for (int i = 0; i < capacitat; i++){
            if (taula[i] != null){
                taula[i].clear();
            }
        }
    }

    private void rehash(){
        java.util.Set<MeuMap.Entrada<K,V>> set = entrySet();
        capacitat *= 2;
        taula = new LinkedList[capacitat];
        size = 0;

        Iterator<Entrada<K,V>> itr = set.iterator();
        while (itr.hasNext()) {
            Entrada<K, V> entrada = itr.next();
            put(entrada.getKey(), entrada.getValue());
        }
    }
}
