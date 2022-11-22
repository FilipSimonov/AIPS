package faks.aud5;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E> {
    public boolean isEmpty ();
    public int size ();
    public E peek ();
    public void clear ();
    public void enqueue (E x);
    public E dequeue ();
}

class LinkedQueue<E> implements Queue<E> {
    // front i rear se linkovi do prviot i posledniot jazel
    SLLNode<E> front, rear;
    int length;
    public LinkedQueue () {
        clear();
    }
    public void clear () {
        front = rear = null;
        length = 0;
    }
    public boolean isEmpty () {
        return (length == 0);
    }
    public int size () { return length; }
    public E peek () {
        if (front == null)
            throw new NoSuchElementException();
        return front.getElement();
    }
    public void enqueue (E x) {
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }
    public E dequeue () {
        if (front != null) {
            E frontmost = front.getElement();
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

class SLLNode<E> {

    private E element;
    public SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ) {
        this.setElement(element);
        this.succ = succ;
    }

    @Override
    public String toString() {
        return getElement().toString();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

}
class Gragjanin{
    private String ime;
    private int licna;
    private int pasos;
    private int vozacka;

    public Gragjanin(String ime, int licna, int pasos, int vozacka) {
        this.ime = ime;
        this.licna = licna;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    @Override
    public String toString() {
        return ime;
    }
    public String getIme() {
        return ime;
    }

    public int getLicna() {
        return licna;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }
}
public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());

        LinkedQueue<Gragjanin> licnaQueue = new LinkedQueue<>();
        LinkedQueue<Gragjanin> pasosQueue = new LinkedQueue<>();
        LinkedQueue<Gragjanin> vozackaQueue = new LinkedQueue<>();

        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);

            if (covek.getLicna()==1)
                licnaQueue.enqueue(covek);
            else if (covek.getPasos()==1)
                pasosQueue.enqueue(covek);
            else if (covek.getVozacka()==1)
                vozackaQueue.enqueue(covek);
        }
        while (!licnaQueue.isEmpty()){
            Gragjanin pom = licnaQueue.dequeue();
            if (pom.getPasos()==1)
                pasosQueue.enqueue(pom);
            else if (pom.getVozacka()==1)
                vozackaQueue.enqueue(pom);
            else
                System.out.println(pom);
        }
        while (!pasosQueue.isEmpty()){
            Gragjanin pom = pasosQueue.dequeue();
            if (pom.getVozacka()==1)
                vozackaQueue.enqueue(pom);
            else
                System.out.println(pom);
        }
        while (!vozackaQueue.isEmpty())
            System.out.println(vozackaQueue.dequeue());
    }
}

