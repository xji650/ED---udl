public class Llibre implements Comparable<Llibre>{
    public Integer ISBN;
    public Llibre (Integer t){
        ISBN = t;
    }
    @Override
    public int compareTo(Llibre o) {
        return this.ISBN.compareTo(o.ISBN);
    }
}
