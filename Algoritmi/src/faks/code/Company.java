package faks.code;
import java.io.*;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
    // Each MapEntryobject is a pair consisting of a key (a Comparable // object) and a value (an arbitrary object).
    K key;
    E value;
    public MapEntry(K key, E val) {
        this.key= key;this.value= val;
    }
    public int compareTo(K that) {
        // Compare this map entry to that map entry.@SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }
    public String toString() {
        return "<" + key + "," + value + ">";
    }
}


class CBHT<K extends Comparable<K>, E> {
    private SLLNode<MapEntry<K,E>>[] buckets;
    @SuppressWarnings("unchecked")

    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr= buckets[b]; curr!= null; curr= curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry= new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr= buckets[b]; curr!= null; curr= curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntryreplace the existing entry ...
                curr.element= newEntry;return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred= null, curr= buckets[b]; curr!=null; pred=curr, curr=curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if(pred==null) {
                    buckets[b] = curr.succ;
                }
                else {
                    pred.succ=curr.succ;
                }
                return;
            }
        }
    }
    //mora da se overridne toString

    public String toString() {

        String temp = "";


        for(int i=0;i<buckets.length;i++) {

            for(SLLNode<MapEntry<K, E>> curr = buckets[i]; curr!=null; curr=curr.succ) {
                temp+=curr.element.key.toString() + " " + curr.element.value.toString()+" ";
            }
        }

        return temp;
    }
}

public class Company {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,Integer> tabela = new CBHT<>(N*2);
        for (int i=0;i<N;i++){
            String line = br.readLine();;
            String parts[] = line.split("\\s+");
            String vraboten = parts[0];
            String manager = parts[1];

           SLLNode<MapEntry<String,Integer>> node = tabela.search(manager);

           if (node!=null){
               int count = node.element.value;
               tabela.insert(manager,count+1);
           }
           else {
               tabela.insert(manager,1);
           }
        }
        System.out.println(tabela);
    }
}