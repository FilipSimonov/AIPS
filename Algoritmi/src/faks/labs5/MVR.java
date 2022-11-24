package faks.labs5;

import java.util.NoSuchElementException;
import java.util.Scanner;

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
class Gragjanin{
    String ImePrezime;
    int LKarta;
    int Pasosh;
    int Vozachka;
    public Gragjanin(String imePrezime, int lKarta, int pasosh, int vozachka){
        ImePrezime = imePrezime;
        LKarta=lKarta;
        Pasosh=pasosh;
        Vozachka=vozachka;
    }

    @Override
    public String toString() {
        return ImePrezime;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());

        ArrayQueue<Gragjanin> LKRedica= new ArrayQueue<>(N);
        ArrayQueue<Gragjanin> PasoshRedica= new ArrayQueue<>(N);
        ArrayQueue<Gragjanin> VozachkaRedica= new ArrayQueue<>(N);

        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if(covek.LKarta==1){
                LKRedica.enqueue(covek);
            }
            else if(covek.Pasosh==1){
                PasoshRedica.enqueue(covek);
            }
            else{
                VozachkaRedica.enqueue(covek);
            }
        }
        while(!(LKRedica.isEmpty())){
            Gragjanin covek = LKRedica.dequeue();
            if(covek.Pasosh==1){
                PasoshRedica.enqueue(covek);
            }
            else if(covek.Vozachka==1){
                VozachkaRedica.enqueue(covek);
            }
            else System.out.println(covek);
        }
        while (!(PasoshRedica.isEmpty())){
            Gragjanin covek = PasoshRedica.dequeue();
            if(covek.Vozachka==1){
                VozachkaRedica.enqueue(covek);
            }
            else System.out.println(covek);
        }
        while (!(VozachkaRedica.isEmpty())) {
            Gragjanin covek = VozachkaRedica.dequeue();
            System.out.println(covek);
        }
    }
}
