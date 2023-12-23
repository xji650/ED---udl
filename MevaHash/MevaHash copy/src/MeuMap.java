public interface MeuMap <K, V> {
    public void buidar();
    public boolean teClau(K key);
    public boolean teValor (V value);
    public java.util.Set<Entrada<K,V>> entrySet();
    public V get (K key);
    public boolean isEmpty();
    public java.util.Set<K> keySet();
    public V put (K key, V value);
    public void eliminar (K key);
    public int size();
    public java.util.Set<V> values();
    public static class Entrada<K, V>{
        K clau;
        V valor;
        public Entrada (K key, V value){
            this.clau = key;
            this.valor = value;
        }
        public K getKey(){
            return clau;
        }
        public V getValue(){
            return valor;
        }
        public String toString(){
            return "[" + clau + ", " + valor + "]";
        }
    }

}
