package faks.labs1.JoinList;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

class SLL<E extends Comparable<E>> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }
    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
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
    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }
    public Iterator<E> iterator () {
        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<E>();
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    private class LRIterator<E> implements Iterator<E> {
        private SLLNode<E> place, curr;

        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = null;
        }
        public boolean hasNext() {
            return (place != null);
        }

        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            curr = place;
            place = place.succ;
            return nextElem;
        }
        public void remove() {
            //Not implemented
        }
    }

    public SLL<E> joinLists(SLL<E> list2){
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> jazol1 = this.getFirst(), jazol2 = list2.getFirst();
        //SLLNode<E> jazol2 = list2.getFirst();

        while(jazol1 != null && jazol2 != null){
            if(jazol1.element.compareTo(jazol2.element) < 0){ //jazol1<jazol2
                rezultat.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }
            else{
                rezultat.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }

        }

        if(jazol1 != null){
            while(jazol1 != null){
                rezultat.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }
        }

        if(jazol2 != null){
            while(jazol2 != null){
                rezultat.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }
        }
        SLLNode<E> tmp = rezultat.getFirst();
        while (tmp.succ != null) {
            if (tmp.element.compareTo(tmp.succ.element) == 0&&tmp.succ.succ != null)
                tmp.succ=tmp.succ.succ;
            else if(tmp.element.compareTo(tmp.succ.element) == 0&&tmp.succ.succ == null)
                tmp.succ = null;
            else tmp = tmp.succ;
        }
        return rezultat;
    }
}


public class SLLJoinLists {
    public static void main(String[] args) throws IOException {
        SLL<Integer> lista1= new SLL<Integer>();
        SLL<Integer> lista2 = new SLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza= s.split(" ");
        for(int i=0;i<N;i++){
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }
        SLL<Integer> spoeni = new SLL<Integer>();
        spoeni= lista1.joinLists(lista2);
        Iterator<Integer> it = spoeni.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
        }
        System.out.println();
    }
}
