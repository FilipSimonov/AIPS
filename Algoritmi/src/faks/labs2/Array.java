package faks.labs2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array<E> {
    private E data[];
    private int size;

    public Array(int size) {
        data = (E[]) new Object[size];
        this.size = size;
    }
    public void set(int position, E o) {
        if (position >= 0&&position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }

    public int getLength() {
        return size;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++){
            if(o.equals(data[i]))
                return i;
        }
        return -1;
    }

    public static int brojDoProsek(Array<Integer> niza){
        int sum = 0;
        for(int i=0;i<niza.getLength();i++){
            sum+=niza.get(i);
        }
        double average = (double)sum/niza.getLength();
        double min = Math.abs(niza.get(0)-average);
        int k = 0;
        for (int i=1;i<niza.getLength();i++){
            if((Math.abs(niza.get(i)-average))<min){
                min=(Math.abs(niza.get(i)-average));
                k=i;
            }
            if((Math.abs(niza.get(i)-average)) == min){
                if(niza.get(i)<niza.get(k)){
                    min=(Math.abs(niza.get(i)-average));
                    k=i;
                }
            }
        }
        return niza.get(k);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        Array<Integer> niza = new Array<Integer>(N);
        for (int i=0;i<N;i++){
            s = stdin.readLine();
            niza.set(i,Integer.parseInt(s));
        }


        System.out.println(brojDoProsek(niza));
    }



}