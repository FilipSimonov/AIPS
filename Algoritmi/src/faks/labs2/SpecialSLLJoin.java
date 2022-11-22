package faks.labs2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialSLLJoin<E>{

    public SLL<Integer> specialJoin(SLL<Integer> lista1,SLL<Integer> lista2){
        SLL<Integer> rezultat = new SLL<Integer>();
        SLLNode<Integer> node1 = lista1.getFirst();
        SLLNode<Integer> node2 = lista2.getFirst();

        while (node1!=null && node2!=null){
            rezultat.insertLast(node1.element);
            node1 = node1.succ;
            if(node1!=null){
                rezultat.insertLast(node1.element);
                node1=node1.succ;
            }
            rezultat.insertLast(node2.element);
            node2=node2.succ;
            if(node2!=null)
            {
                rezultat.insertLast(node2.element);
                node2=node2.succ;
            }
        }
        if(node1!=null){
            rezultat.insertLast(node1.element);
            node1 = node1.succ;
        }
        if (node2!=null){
            rezultat.insertLast(node2.element);
            node2 = node2.succ;
        }
        return rezultat;
    }

    public static void main(String[] args) throws IOException{

        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        SpecialSLLJoin<Integer> sj = new SpecialSLLJoin();
        System.out.println(sj.specialJoin(lista1,lista2));

    }
}
