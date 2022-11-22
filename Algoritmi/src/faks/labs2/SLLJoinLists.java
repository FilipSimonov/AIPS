package faks.labs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class SLLJoinLists<E extends Comparable<E>>{

    public SLL<E> join(SLL<E> lista1, SLL<E> lista2){

        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> node1 = lista1.getFirst();
        SLLNode<E> node2 = lista2.getFirst();

        while (node1!=null && node2!=null){
            if(node1.element.compareTo(node2.element)<0){
                rezultat.insertLast(node1.element);
                node1 = node1.succ;
            }
            else {
                rezultat.insertLast(node2.element);
                node2 = node2.succ;
            }
        }
        if(node1!=null){
            while (node1!=null && node1!=node1.succ){
                rezultat.insertLast(node1.element);
                node1 = node1.succ;
            }
        }
        if(node2!=null && node2!=node2.succ){
            while (node2!=null){
                rezultat.insertLast(node2.element);
                node2 = node2.succ;
            }
        }
        SLLNode<E> tmp = rezultat.getFirst();
        while (tmp.succ!=null){
            if(tmp.element.compareTo(tmp.succ.element)==0 && tmp.succ.succ!=null){
                tmp.succ = tmp.succ.succ;
            }
            else if(tmp.element.compareTo(tmp.succ.element)==0 && tmp.succ.succ==null){
                tmp.succ = null;
            }
            else tmp = tmp.succ;
        }
        return rezultat;
    }

    public static void main(String[] args) throws IOException {

        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
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

        SLLJoinLists<Integer> spoeni = new SLLJoinLists<Integer>();
        System.out.println(spoeni.join(lista1,lista2));

    }
}
