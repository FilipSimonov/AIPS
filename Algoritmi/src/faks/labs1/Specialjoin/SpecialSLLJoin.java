package faks.labs1.Specialjoin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
class SLL<E>{
    private SLLNode<E> first;
    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }
    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }
    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }
    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }
    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }
    public SLLNode<E> getFirst() {
        return first;
    }

}

public class SpecialSLLJoin {
    private static SLL<Integer> specialJoin(SLL<Integer> lista1, SLL<Integer> lista2){
        SLL<Integer> spoenaLista = new SLL<>();
        SLLNode<Integer> first1L = lista1.getFirst();
        SLLNode<Integer> first2L = lista2.getFirst();
        int br1,br2;
        while((first1L != null) || (first2L != null)){
            br1=0;br2=0;
            while((first1L != null) && (br1 != 2)){
                spoenaLista.insertLast(first1L.element);
                first1L= first1L.succ;
                br1++;
            }
            while((first2L != null) && (br2 != 2)){
                spoenaLista.insertLast(first2L.element);
                first2L=first2L.succ;
                br2++;
            }
        }
        return spoenaLista;
    }
    public static void main(String[] args) throws IOException {
        SLL<Integer> lista1=new SLL<>();
        SLL<Integer> lista2 = new SLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N= Integer.parseInt(s);
        s= stdin.readLine();
        String [] pomniza = s.split(" ");
        for(int i=0;i<N;i++){
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }
        s= stdin.readLine();
        N=Integer.parseInt(s);
        s=stdin.readLine();
        pomniza=s.split(" ");
        for(int i=0;i<N;i++){
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }
        SLL<Integer> spoeni = specialJoin(lista1,lista2);
        System.out.println(spoeni);
    }
}
